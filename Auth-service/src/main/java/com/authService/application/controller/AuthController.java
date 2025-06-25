package com.authService.application.controller;

import com.authService.application.dto.RequestDto;
import com.authService.application.entity.UserInfo;
import com.authService.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(RequestDto request){
        UserInfo user=new UserInfo();
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("user created successfully");
    }

    @PostMapping("/generateToken")
    public ResponseEntity<String> generateJwtToken()
    {
        return null;
    }

    @PostMapping("/validateUser")
    public ResponseEntity<String> validateToken(){
        return null;
    }


}

