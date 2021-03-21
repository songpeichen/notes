package com.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelTestController {
    @RequestMapping("/test")
    public Object test() {
        return "test";
    }
}
