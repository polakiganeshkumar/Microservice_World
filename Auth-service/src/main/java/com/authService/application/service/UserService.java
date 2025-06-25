package com.authService.application.service;

import com.authService.application.entity.UserInfo;
import com.authService.application.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private CredentialRepository repo;

    @Autowired
    public PasswordEncoder password;


    public String saveUser(UserInfo user){
         user.setPassword(password.encode(user.getPassword()));
         repo.save(user);
        return "data saved !!";
    }
}
