package com.service;

import com.pojo.Order;
import com.pojo.Product;

import java.util.List;

public interface OrderService {
    Order selectOrderById(Long id);
}
