package com.ganeshPolaki.Order_Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HttpServiceCallController{

    @Autowired
    private WebClient.Builder webClinet;

    public String postWebCall(String endPoint){
        return "Polaki:Ganesh:Kumar";
    }
}
