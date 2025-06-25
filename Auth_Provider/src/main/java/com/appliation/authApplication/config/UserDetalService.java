package com.appliation.authApplication.config;

import com.appliation.authApplication.model.UserDetail;
import com.appliation.authApplication.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetalService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDetail> users=repo.findAllByUserName(username);

        return users.map(UserDetailst :: new).orElseThrow(()->new UsernameNotFoundException("new user not found"));
    }
}
