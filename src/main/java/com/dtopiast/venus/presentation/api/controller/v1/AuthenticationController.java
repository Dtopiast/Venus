package com.dtopiast.venus.presentation.api.controller.v1;

import com.dtopiast.venus.core.service.auth.JwtToken;
import com.dtopiast.venus.infraestructure.service.auth.TokenService;
import com.dtopiast.venus.domain.user.dto.AuthUserDto;
import com.dtopiast.venus.domain.user.model.User;
import com.dtopiast.venus.presentation.api.controller.base.MyController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/login")
public class AuthenticationController extends MyController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;
    @Autowired

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService){

        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping

    public ResponseEntity<JwtToken> authenticateUser(@RequestBody @Valid AuthUserDto authUserDto) {

        Authentication authToken = new UsernamePasswordAuthenticationToken(authUserDto.email(),
                authUserDto.password());
        var authenticate = authenticationManager.authenticate(authToken);
        var token = tokenService.getToken((User) authenticate.getPrincipal());
        return ResponseEntity.ok(new JwtToken(token));

    }

}