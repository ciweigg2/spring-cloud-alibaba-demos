package com.ciwei.user.listener;

import com.alibaba.fastjson.JSON;
import com.ciwei.user.mybatis.model.AlibabaUser;
import com.ciwei.user.mybatis.service.AlibabaUserService;
import com.ciwei.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * @author Ciwei
 */
@RocketMQTransactionListener(txProducerGroup = "user-tx-provider-group", corePoolSize = 5, maximumPoolSize = 10)
@Slf4j
public class UserTransactionListenerImpl implements RocketMQLocalTransactionListener {

    @Autowired
    private UserService userService;

    @Autowired
    private AlibabaUserService alibabaUserService;

    /**
     * 提交本地事务
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
        //插入用户数据
        String userJson =  new String(((byte[])message.getPayload()));
        AlibabaUser alibabaUser = JSON.parseObject(userJson, AlibabaUser.class);
        userService.insertUserRocketMQ(alibabaUser);
//        try {
//            int a = 1/0;
//        }catch (Exception e){
//            log.error("============Exception：用户插入数据后服务器宕机了，事务消息没提交，等待回查后提交事务呀");
//            //模拟用户插入数据后服务器宕机了，没有commit事务消息
//            throw new RuntimeException("============用户服务器宕机了");
//        }
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
        Long userId = Long.valueOf((String)message.getHeaders().get("userId"));
        System.out.println("============事务回查-userId：" + userId);
        //判断之前的事务是否已经提交：用户记录是否已经保存
        AlibabaUser alibabaUser = alibabaUserService.getById(userId);
        System.out.println(alibabaUser == null ? "============事务回查-用户未创建-回滚事务消息":"============事务回查-用户已创建-提交事务消息");
        return alibabaUser != null ? RocketMQLocalTransactionState.COMMIT : RocketMQLocalTransactionState.ROLLBACK;
    }

}