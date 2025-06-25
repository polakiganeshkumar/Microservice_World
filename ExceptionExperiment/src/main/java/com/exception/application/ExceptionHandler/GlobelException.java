package com.exception.application.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobelException {

    @ExceptionHandler({ArrayIndexOutOfBoundsException.class,IllegalArgumentException.class
    })
    public ResponseEntity<?> handleMyException(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Array index out of bound Exception");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> globalException(){
       return ResponseEntity.status(HttpStatus.ACCEPTED).body("something is fishy man");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> globalStateExc(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("message is not readable In the case !!");
    }

}
