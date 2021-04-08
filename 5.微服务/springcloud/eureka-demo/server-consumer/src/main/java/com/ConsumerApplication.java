package com;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {
    @Bean

//    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

//添加一个随机的负载均衡 注释掉了
//    @Bean
//    RandomRule randomRule(){
//        return new RandomRule();
//    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
