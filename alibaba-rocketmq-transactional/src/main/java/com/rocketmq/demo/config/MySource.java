package com.rocketmq.demo.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author 马秀成
 * @date 2019/9/25
 * @jdk.version 1.8
 * @desc 生产者
 */
public interface MySource {

    String OUTPUT = "output";
    String OUTPUT1 = "output1";
    String OUTPUT2 = "output2";

    @Output(MySource.OUTPUT)
    MessageChannel output();

    @Output(MySource.OUTPUT1)
    MessageChannel output1();

//    @Output(MySource.OUTPUT2)
//    MessageChannel output2();

}
