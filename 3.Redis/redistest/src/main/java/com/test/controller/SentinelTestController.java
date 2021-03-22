package com.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class SentinelTestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/testSet")
    public Object test() {
        redisTemplate.opsForValue().set("time", new Date().getTime()+"", 100000);
        return "succsee";
    }
    @RequestMapping("/testGet")
    public Object testGet() {
        return redisTemplate.opsForValue().get("time");
    }
}
