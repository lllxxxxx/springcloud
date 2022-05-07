package com.atguigu.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/1 21:04
 */
public interface LoadBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
