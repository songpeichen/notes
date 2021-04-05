package com.service.impl;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.stereotype.Service;
import rx.Producer;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> getProducerList() {
        return Arrays.asList(
                new Product(1, "商品a", 99, 10.0D),
                new Product(2, "商品b", 98, 20.0D),
                new Product(3, "商品c", 97, 30.0D),
                new Product(4, "商品d", 96, 40.0D)
        );
    }
}
