package com.ciwei.user.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 自定义发送和接收
 *
 * @author Ciwei
 */
@EnableBinding({MySource.class})
public class RocketMqConfig {

}
