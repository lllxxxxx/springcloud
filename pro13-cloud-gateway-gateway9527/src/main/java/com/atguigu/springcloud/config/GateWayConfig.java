package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/7 22:47
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder route=routeLocatorBuilder.routes();
        route.route("path_route",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return route.build();
    }
}
