package com.service.impl;

import com.pojo.Order;
import com.pojo.Product;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public Order selectOrderById(Long id) {
        List<Product> productList = selectProductListByDiscoveryClient();
        Order order = new Order(id, "orderNo111", "订单地址", 204.3, productList);
        return order;
    }

    private List<Product> selectProductListByDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("server-provider");
        ServiceInstance s1 = instances.get(0);
        ResponseEntity<List<Product>> response = restTemplate.exchange("http://" + s1.getHost() + ":" + s1.getPort() + "/product/getProductList", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
        });
        return response.getBody();
    }
}
