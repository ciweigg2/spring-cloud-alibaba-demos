package com.ciwei.gift.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * @author Ciwei
 */
@RocketMQTransactionListener(txProducerGroup = "live-tx-provider-group", corePoolSize = 5, maximumPoolSize = 10)
@Slf4j
public class SendToLiveTransactionListenerImpl implements RocketMQLocalTransactionListener {

    /**
     * 提交本地事务
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
        //插入用户数据
        String sentToJson = new String(((byte[]) message.getPayload()));
        log.info("发送创建直播的数据：" + sentToJson);
        //提交事务消息
        return RocketMQLocalTransactionState.COMMIT;
    }

    /**
     * 事务回查接口
     * <p>
     * 如果事务消息一直没提交，则定时判断用户数据是否已经插入
     * 是：提交事务消息
     * 否：回滚事务消息
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        log.info("事务回查逻辑 准备发送给直播服务 创建直播");
        int count = 1;
        return count > 0 ? RocketMQLocalTransactionState.COMMIT : RocketMQLocalTransactionState.ROLLBACK;
    }

}