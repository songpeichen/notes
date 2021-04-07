package com.controller;

import com.pojo.Order;
import com.pojo.Product;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/{id}")
    public Object getProductList(@PathVariable("id") Long id){
        Order order = orderService.selectOrderById(id);
        return order;
    }
}
