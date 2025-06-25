package com.microservice.inventory.service;

import com.microservice.inventory.dto.InventoryResponse;
import com.microservice.inventory.model.Inventory;
import com.microservice.inventory.reposetory.InventoryRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo repo;

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
}
