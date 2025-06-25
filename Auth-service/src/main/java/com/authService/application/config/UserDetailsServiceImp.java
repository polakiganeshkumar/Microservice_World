package com.authService.application.config;

import com.authService.application.entity.UserInfo;
import com.authService.application.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private CredentialRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userFilter= repo.findByName(username);
        return userFilter.map(UserDetailsCl::new).orElseThrow(()->
                new UsernameNotFoundException("no User Found"));
    }
}
