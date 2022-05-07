package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/1 19:49
 */
@RestController
@Slf4j
public class OrderCintroller {

    public static final String URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String pay(){
        String res=restTemplate.getForObject(URL+"/payment/consul",String.class);
        return res;
    }
}
