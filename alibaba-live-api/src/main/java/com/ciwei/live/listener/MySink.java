package com.ciwei.live.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author 马秀成
 * @date 2019/9/25
 * @jdk.version 1.8
 * @desc 消费者
 */
public interface MySink {

    String INPUTLIVE = "inputLive";
    String INPUTDLQLIVE = "inputDlqLive";

    @Input(MySink.INPUTLIVE)
    SubscribableChannel input();

    @Input(MySink.INPUTDLQLIVE)
    SubscribableChannel inputDlq();

}
