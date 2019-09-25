package com.ciwei.user.listener;

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

    @Output(MySource.OUTPUT)
    MessageChannel output();

}
