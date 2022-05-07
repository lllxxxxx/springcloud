package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/4/30 23:08
 */
@RestController
@Slf4j
public class OrderController {
    public static final String URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String pay(){
        String res=restTemplate.getForObject(URL+"/payment/zk",String.class);
        return res;
    }
}
