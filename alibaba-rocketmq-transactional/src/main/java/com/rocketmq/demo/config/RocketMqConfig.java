package com.rocketmq.demo.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 自定义发送和接收
 *
 * @author Ciwei
 */
@EnableBinding({MySource.class, MySink.class})
public class RocketMqConfig {

}
