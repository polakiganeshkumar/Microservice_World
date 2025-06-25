package com.microservice.inventory.reposetory;

import com.microservice.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    public List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
