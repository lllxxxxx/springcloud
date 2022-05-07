package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/6 20:25
 */
@Service
@FeignClient(value = "",fallback = PaymentFallback.class)  //下面接口里面的方法会找这个注解里的value值对应的微服务
public interface PaymentService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
