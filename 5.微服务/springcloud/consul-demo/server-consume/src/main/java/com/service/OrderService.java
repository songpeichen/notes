package com.service;

import com.pojo.Order;

public interface OrderService {
    Order selectOrderById(Long id);
}
