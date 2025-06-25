package com.ganeshPolaki.Order_Service.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="t_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineIteams> orderLineIteamsList;

}
