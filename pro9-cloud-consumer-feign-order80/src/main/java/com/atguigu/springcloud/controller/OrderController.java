package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.servcie.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/2 16:37
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPay(@PathVariable("id")Long id){
        return orderService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String ap(){
        return orderService.payment();
    }

}
