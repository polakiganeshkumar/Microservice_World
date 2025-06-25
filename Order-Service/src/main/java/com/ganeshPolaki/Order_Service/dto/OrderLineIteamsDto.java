package com.ganeshPolaki.Order_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineIteamsDto {

    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
