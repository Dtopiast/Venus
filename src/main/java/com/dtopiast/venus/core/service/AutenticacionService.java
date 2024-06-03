package com.dtopiast.venus.core.service;

import com.dtopiast.venus.domain.user.model.User;
import com.dtopiast.venus.domain.user.specification.UserByNameSpecification;
import com.dtopiast.venus.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    private final Repository<User> userRepository;

    @Autowired

    public AutenticacionService(Repository<User> userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findAll(new UserByNameSpecification(username)).getFirst();
    }
}