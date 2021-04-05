package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProviderController {
    @Autowired
    ProductService productService;
    @RequestMapping("/getProductList")
    public Object getProductList(){
        List<Product> producerList = productService.getProducerList();
        return producerList;
    }
}
