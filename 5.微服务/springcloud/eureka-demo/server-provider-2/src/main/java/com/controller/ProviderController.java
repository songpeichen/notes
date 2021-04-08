package com.controller;

import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProviderController {
    @Autowired
    ProductService productService;
    @RequestMapping("/getProductList")
    public Object getProductList(){
        System.err.println("P2");
        return productService.getProducerList();
    }
}
