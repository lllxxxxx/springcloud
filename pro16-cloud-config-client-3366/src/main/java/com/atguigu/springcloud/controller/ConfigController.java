package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/9 22:33
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${server.port}")
    private String servretPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configinfo")
    public String getConfigInfo(){
        return servretPort+configInfo;
    }
}
