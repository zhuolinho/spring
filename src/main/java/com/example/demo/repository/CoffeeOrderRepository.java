package com.example.demo.repository;

import com.example.demo.model.CofferOrder;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeOrderRepository extends CrudRepository<CofferOrder, Long> {
}
