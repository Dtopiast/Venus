package com.dtopiast.venus.infraestructure.service.auth;

import com.dtopiast.venus.core.service.auth.IAuthenticationService;
import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.domain.user.model.User;
import com.dtopiast.venus.domain.user.specification.UserByNameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final IRepository<User> userIRepository;

    @Autowired

    public AuthenticationService(IRepository<User> userIRepository) {
        this.userIRepository = userIRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userIRepository.findOne(new UserByNameSpecification(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}