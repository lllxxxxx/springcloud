package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/6 22:31
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard9001.class,args);
    }
}
