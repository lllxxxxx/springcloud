package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/4/27 22:21
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
