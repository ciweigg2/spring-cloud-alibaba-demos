package com.rocketmq.demo.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author 马秀成
 * @date 2019/9/25
 * @jdk.version 1.8
 * @desc 消费者
 */
public interface MySink {

    String INPUT = "input";
    String INPUT1 = "input1";
    String INPUT2 = "input2";
    String INPUTDLQ = "inputDlq";
    String INPUTDLQ1 = "inputDlq1";
    String INPUTDLQ2 = "inputDlq2";

    @Input(MySink.INPUT)
    SubscribableChannel input();

    @Input(MySink.INPUT1)
    SubscribableChannel input1();

//    @Input(MySink.INPUT2)
//    SubscribableChannel input2();
//
    @Input(MySink.INPUTDLQ)
    SubscribableChannel inputDlq();

    @Input(MySink.INPUTDLQ1)
    SubscribableChannel inputDlq1();

//    @Input(MySink.INPUTDLQ2)
//    SubscribableChannel inputDlq2();

}
