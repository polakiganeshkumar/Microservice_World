package com.ganeshPolaki.Order_Service.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {


    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilderb(){
        return WebClient.builder();
    }


}
