package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info(String.valueOf(i));
        if(i>0){
            return new CommonResult(200,"succ",i);
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
            return new CommonResult<>(200,"succ",paymentById);
        }else {
            return new CommonResult<>(444,"error",null);
        }

    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("*********element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance el:instances){
            log.info(el.getServiceId()+"\t"+el.getHost()+"\t"+el.getPort()+"\t"+el.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String apyment(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
