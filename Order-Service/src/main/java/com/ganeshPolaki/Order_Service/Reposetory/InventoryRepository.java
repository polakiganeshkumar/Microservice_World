package com.ganeshPolaki.Order_Service.Reposetory;

import com.ganeshPolaki.Order_Service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Order,Long> {

}
