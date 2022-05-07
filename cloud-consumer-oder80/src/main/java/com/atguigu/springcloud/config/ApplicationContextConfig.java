package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/4/28 9:44
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @param : null
     * @return RestTemplate
     * @author lllxxx
     * @description @Bean相当于在容器添加了这个实体类
     */
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
