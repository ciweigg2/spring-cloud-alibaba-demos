package com.ciwei.gift.listener;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author 马秀成
 * @date 2019/9/25
 * @jdk.version 1.8
 * @desc 生产者
 */
public interface MySource {

    String OUTPUTLIVE = "outputLive";

    @Output(MySource.OUTPUTLIVE)
    MessageChannel output();

}
