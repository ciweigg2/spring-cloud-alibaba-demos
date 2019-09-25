package com.ciwei.gift.listener;

import com.ciwei.common.utils.SnowflakeIdWorker;
import com.ciwei.gift.mybatis.model.AlibabaGift;
import com.ciwei.gift.mybatis.service.AlibabaGiftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 礼物服务的消费者，接收到添加用户成功后增加礼物
 *
 * @author Ciwei
 */
@Service
@Slf4j
public class GiftReceiveService {

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Autowired
    private AlibabaGiftService alibabaGiftService;

    @StreamListener(MySink.INPUT)
    public void receive(Message message) {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            log.error("============Exception：礼物服务器宕机了 ,进入通知逻辑 ，记录失败记录");
            //模拟用户插入数据后服务器宕机了，没有commit事务消息
            throw new RuntimeException("============礼物服务器宕机了");
        }
        Long userId = Long.valueOf((String) message.getHeaders().get("userId"));
        AlibabaGift alibabaGift = new AlibabaGift();
        alibabaGift.setUserId(userId);
        alibabaGift.setGiftId(snowflakeIdWorker.nextId());
        alibabaGift.setGiftName("我爱G.E.M邓紫棋");
        alibabaGiftService.save(alibabaGift);
        log.info("新用户礼物赠送成功");
    }

    /**
     * 消费死信队列
     */
    @StreamListener(MySink.INPUTDLQ)
    public void receiveDlq(Message message) {
        Long userId = Long.valueOf((String) message.getHeaders().get("userId"));
        System.err.println("============消费死信队列消息，记录日志并预警：" + userId);
    }

    /**
     * 处理全局异常的方法
     *
     * @param errorMessage 异常消息对象
     */
    @StreamListener("errorChannel")
    public void handleError(ErrorMessage errorMessage) {
        log.error("发生异常. errorMessage = {}", errorMessage);
    }

}
