package com.service;

import com.pojo.Product;
import rx.Producer;

import java.util.List;

public interface ProductService {
    List<Product> getProducerList();
}
