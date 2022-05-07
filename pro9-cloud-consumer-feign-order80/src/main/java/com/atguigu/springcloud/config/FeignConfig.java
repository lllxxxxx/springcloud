package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/2 17:24
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggorLever(){
        return Logger.Level.FULL;
    }

}
