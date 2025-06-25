package com.appliation.authApplication.controller;

import com.appliation.authApplication.dto.RequestUser;
import com.appliation.authApplication.service.OperateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    OperateUserService service;

    @PostMapping("/createUser")
    public ResponseEntity<?> saveUserDetails(@RequestBody RequestUser user)
    {
        service.SaveUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("user saved Successfully!!!");
    }
}
