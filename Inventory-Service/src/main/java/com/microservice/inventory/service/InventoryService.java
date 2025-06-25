package com.microservice.inventory.service;

import com.microservice.inventory.dto.InventoryResponse;
import com.microservice.inventory.model.Inventory;
import com.microservice.inventory.model.Product;
import com.microservice.inventory.reposetory.InventoryRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo repo;

     @Autowired
    public RestTemplate restTemplate;

    @Transactional
    public List<InventoryResponse> isInStock(List<String> skuCode){
    System.out.println(skuCode);


        return repo.findBySkuCodeIn(skuCode).stream().map(
                inventory-> {
                    return InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build();
                }).collect(Collectors.toList());
    }

    public String hitThirdPartyApi(){
        Product req=new Product();
        req.setId("12");
        req.setName("ganesh Polaki");
        req.setDiscription("polaki ganesh den");
        req.setPrice(new BigDecimal(0023));

        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Product> entity=new HttpEntity<Product>(req,headers);

        ResponseEntity<Product> response = restTemplate.exchange("http://localhost:8080/api/product", HttpMethod.POST,entity, Product.class);

       System.out.println(response);
        return  "I did It now!!";
    }

}
