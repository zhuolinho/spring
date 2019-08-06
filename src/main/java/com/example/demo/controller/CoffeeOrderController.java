package com.example.demo.controller;

import com.example.demo.controller.request.NewOrderRequest;
import com.example.demo.model.Coffee;
import com.example.demo.model.CoffeeOrder;
import com.example.demo.service.CoffeeOrderService;
import com.example.demo.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {
    @Autowired
    private CoffeeOrderService orderService;
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrderRequest) {
        log.info("Receive new Order {}", newOrderRequest);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrderRequest.getItems()).toArray(new Coffee[]{});
        return orderService.createOrder(newOrderRequest.getCustomer(), coffeeList);
    }
}
