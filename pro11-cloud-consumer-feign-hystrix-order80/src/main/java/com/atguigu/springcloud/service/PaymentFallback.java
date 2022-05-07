package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/6 21:51
 */
@Component
public class PaymentFallback implements PaymentService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return null;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return null;
    }
}
