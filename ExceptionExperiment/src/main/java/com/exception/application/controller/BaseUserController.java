package com.exception.application.controller;

import com.exception.application.dto.RequestBase;
import com.exception.application.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseUserController {

    @Autowired
    public BaseService service;

    @PostMapping("/baseExceptionController")
    public ResponseEntity<?> getAllInformation(@RequestBody RequestBase st){
        service.handleYourSelf(st);
        return ResponseEntity.status(HttpStatus.CREATED).body("we are uanble to handle this case !!!");
    }
}

