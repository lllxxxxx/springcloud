package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/4/27 22:25
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info(String.valueOf(i));
        if(i>0){
            return new CommonResult(200,"succ"+serverPort,i);
        }else {
            return new CommonResult(444,"error",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id")Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info(String.valueOf(paymentById));
        if(paymentById!=null){
            System.out.println("ff");
            return new CommonResult<>(200,"succ"+serverPort,paymentById);
        }else {
            return new CommonResult<>(444,"error",null);
        }

    }

}
