package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/2 22:19
 */
@Service
public class PaymentService {

    public String apymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"ok_id"+id;
    }

    @HystrixCommand(fallbackMethod = "hander",commandProperties = {//如果超时 调用hander方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//这个线程超时的时间三秒钟
    })  //Hystrix的服务降级注解  还需呀去主启动类上面开启服务
    public String time_out(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"tiom_out_id"+id;
    }

    public String hander(Integer id){
        return "哈哈哈,我在兜底";
    }


}
