package com.dtopiast.venus.infraestructure.service.auth;

import com.dtopiast.venus.domain.user.model.User;
import com.dtopiast.venus.domain.user.specification.UserByNameSpecification;
import com.dtopiast.venus.core.service.repository.IRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final IRepository<User> userIRepository;

    @Autowired
    public SecurityFilter(TokenService tokenService, IRepository<User> userIRepository) {
        this.tokenService = tokenService;
        this.userIRepository = userIRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var username = tokenService.getSubject(token);
            if (username != null) {
                var user = userIRepository.findAll(new UserByNameSpecification(username)).getFirst();
                var authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
