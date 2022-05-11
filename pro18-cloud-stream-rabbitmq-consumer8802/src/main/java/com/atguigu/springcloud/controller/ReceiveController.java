package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/11 20:58
 */
@Controller
@EnableBinding(Sink.class)
public class ReceiveController {

    @Value("${server.port}")
    private String serverPort;

    public void input(Message<String> message){
        System.out.println(message.getPayload()+serverPort);
    }

}
