package com.ganeshPolaki.Order_Service.controller;

import com.ganeshPolaki.Order_Service.dto.RequestDto;
import com.ganeshPolaki.Order_Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {


    @Autowired
    private OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody RequestDto request){
        service.placeOrder(request);
        return "order placed Successfully ";
    }
}
