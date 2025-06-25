package com.ganeshPolaki.Order_Service.service;

import com.ganeshPolaki.Order_Service.Reposetory.InventoryRepository;
import com.ganeshPolaki.Order_Service.dto.InventoryResponse;
import com.ganeshPolaki.Order_Service.dto.OrderLineIteamsDto;
import com.ganeshPolaki.Order_Service.dto.RequestDto;
import com.ganeshPolaki.Order_Service.model.Order;
import com.ganeshPolaki.Order_Service.model.OrderLineIteams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private InventoryRepository respo;

    @Autowired
    private WebClient.Builder webClinet;

    public void placeOrder(RequestDto request){
         Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
         order.setOrderLineIteamsList(request.getOrders().stream().map(orderO->
                 mapToDto(orderO)).collect(Collectors.toList()));

        List<String> skuCodes=order.getOrderLineIteamsList().stream().map(OrderLineIteams :: getSkuCode).toList();

         // call inventory service place order if product is in stock
        InventoryResponse[] result=  webClinet.build().get()
                .uri("http://inventory/api/inventory",uriBuilder ->
                        uriBuilder.queryParam("skucode",skuCodes).build())
                        .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                        .block();

       boolean allProductInStock= Arrays.stream(result).allMatch( InventoryResponse :: isInStock);

      if(allProductInStock){
          respo.save(order);
      }else{
          throw new IllegalArgumentException("product is not in stock, please try again later");
      }

    }

    private OrderLineIteams mapToDto(OrderLineIteamsDto order) {
        OrderLineIteams orderI=new OrderLineIteams();
        //orderI.setId(order.getId());
        orderI.setSkuCode(order.getSkuCode());
        orderI.setPrice(order.getPrice());
        orderI.setQuantity(order.getQuantity());

         return orderI;
    }

}
