package com.ciwei.live.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * 礼物服务的消费者，接收到添加用户成功后增加礼物
 *
 * @author Ciwei
 */
@Service
@Slf4j
public class LiveReceiveService {

    @StreamListener(MySink.INPUTLIVE)
    public void receive(String receiveMessages) {
        log.info("新用户直播创建成功：" + receiveMessages);
    }

    /**
     * 降级处理和死信队列二选一就行
     *
     * 消息消费失败的降级处理逻辑(异常捕获后不会控制台打印)
     * TransactionTopic：消息通道对应的目标（destination，即：spring.cloud.stream.bindings.input.destination的配置）
     * gift-tx-consumer-group：消息通道对应的消费组（group，即：spring.cloud.stream.bindings.input.group的配置）
     */
    @ServiceActivator(inputChannel = "TransactionTopic.gift-tx-consumer-group.errors")
    public void error(Message<?> message) {
        log.info("通知相关负责人并且记录直播创建失败的记录");
    }

}
