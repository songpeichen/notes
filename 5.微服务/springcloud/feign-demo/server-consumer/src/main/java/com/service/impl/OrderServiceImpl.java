package com.service.impl;

import com.pojo.Order;
import com.pojo.Product;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    public Order selectOrderById(Long id) {
//        List<Product> productList = selectProductListByDiscoveryClient();
        List<Product> productList = selectProductListByLoadBalancerClient();
//        List<Product> productList = selectProductListByLoadBalancerAnnotation();
        return new Order(id, "orderNo111", "订单地址", 204.3, productList);
    }

    /**
     * 根据discoverClient调用服务
     */
    private List<Product> selectProductListByDiscoveryClient() {
        List<ServiceInstance> instances = discoveryClient.getInstances("server-provider");
        ServiceInstance s1 = instances.get(0);
        ResponseEntity<List<Product>> response = restTemplate.exchange("http://" + s1.getHost() + ":" + s1.getPort() + "/product/getProductList", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }

    /**
     * 根据loadBalancerClient调用服务
     */
    private List<Product> selectProductListByLoadBalancerClient(){
        ServiceInstance s1 = loadBalancerClient.choose("server-provider");
        System.err.println(s1.getPort());
        ResponseEntity<List<Product>> response = restTemplate.exchange("http://" + s1.getHost() + ":" + s1.getPort() + "/product/getProductList", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();

    }


    /**
     * 根据loadBalancerClient注解调用服务，在restTemplate的Bean上添加@LoadBalance注解
     */
    private List<Product> selectProductListByLoadBalancerAnnotation(){
        ResponseEntity<List<Product>> response = restTemplate.exchange("http://server-provider/product/getProductList", HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();

    }
}
