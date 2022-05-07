package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/4/27 22:06
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id")Long id);

}
