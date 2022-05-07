package com.atguigu.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/1 21:06
 */
@Component
public class MyLB implements LoadBalance {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current,next;
        do {
            current=this.atomicInteger.get();
            next=current>=2147483647?0 : current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println(next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
