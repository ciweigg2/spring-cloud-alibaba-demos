package com.rocketmq.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.ciwei.common.utils.SnowflakeIdWorker;
import com.rocketmq.demo.config.MySource;
import com.rocketmq.demo.config.RocketMqConfig;
import com.rocketmq.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ciwei
 */
@RestController
public class OrderController {

    private final MySource source;

    private final SnowflakeIdWorker snowflakeIdWorker;

    @Autowired
    public OrderController(MySource source, SnowflakeIdWorker snowflakeIdWorker) {
        this.source = source;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }

    /**
     * 正常情况
     */
    @GetMapping("/success")
    public String success() {
        Order order = new Order();
        order.setOrderId(snowflakeIdWorker.nextId());
        order.setOrderNo(RandomUtil.randomString(4));

        Message message = MessageBuilder
                .withPayload(order)
                .setHeader("orderId", order.getOrderId())
                .build();
        //发送半消息
        source.output().send(message);
        return "下单成功";
    }

    /**
     * 发送消息失败
     */
    @GetMapping("/produceError")
    public String produceError() {
        Order order = new Order();
        order.setOrderId(snowflakeIdWorker.nextId());
        order.setOrderNo(RandomUtil.randomString(4));

        Message message = MessageBuilder
                .withPayload(order)
                .setHeader("orderId", order.getOrderId())
                .setHeader("produceError", "1")
                .build();
        //发送半消息
        source.output().send(message);
        return "发送消息失败";
    }

    /**
     * 消费消息失败
     */
    @GetMapping("/consumeError")
    public String consumeError() {
        Order order = new Order();
        order.setOrderId(snowflakeIdWorker.nextId());
        order.setOrderNo(RandomUtil.randomString(4));

        Message message = MessageBuilder
                .withPayload(order)
                .setHeader("orderId", order.getOrderId())
                .setHeader("consumeError", "1")
                .build();
        //发送半消息
        source.output().send(message);
        return "消费消息失败";
    }

}
