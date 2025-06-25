package com.microservice.inventory.controller;

import com.microservice.inventory.dto.InventoryResponse;
import com.microservice.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

/*
   @GetMapping("/{sku-code}")
   @ResponseStatus(HttpStatus.OK)
   public boolean isStockAvailable(@PathVariable("sku-code") String skucode  ){
       return inventoryService. isInStock(skucode);
   }
*/

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isStockAvailable(@RequestParam List<String> skucode){
        return inventoryService. isInStock(skucode);
    }

}
