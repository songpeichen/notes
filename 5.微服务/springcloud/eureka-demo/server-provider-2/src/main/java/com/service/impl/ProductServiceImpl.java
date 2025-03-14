package com.service.impl;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> getProducerList() {
        return Arrays.asList(
                new Product(1, "服务2-商品a", 99, 10.0D),
                new Product(2, "服务2-商品b", 98, 20.0D),
                new Product(3, "服务2-商品c", 97, 30.0D),
                new Product(4, "服务2-商品d", 96, 40.0D)
        );
    }
}
