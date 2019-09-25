package com.ciwei.gift.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 自定义发送和接收
 *
 * @author Ciwei
 */
@EnableBinding({MySink.class})
public class RocketMqConfig {

}
