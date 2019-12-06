package com.ciwei.gift.listener;

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
    String INPUTDLQ = "inputDlq";

    @Input(MySink.INPUT)
    SubscribableChannel input();

    @Input(MySink.INPUTDLQ)
    SubscribableChannel inputDlq();

}
