package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/6 20:23
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //开启服务测服务降级
public class OrderHystrixOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixOrder80.class,args);
    }
}
