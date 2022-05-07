package com.atguigu.springcloud.servcie;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/2 16:30
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderService {

//    CommonResult<Payment> getPaymentById(@Param("id")Long id);

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    public String payment();
}
