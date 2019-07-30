package com.example.demo.repository;

import com.example.demo.model.CofferOrder;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CofferOrder, Long> {
    List<CofferOrder> findByCustomerOrderById(String customer);
    List<CofferOrder> findByItemsName(String name);
}
