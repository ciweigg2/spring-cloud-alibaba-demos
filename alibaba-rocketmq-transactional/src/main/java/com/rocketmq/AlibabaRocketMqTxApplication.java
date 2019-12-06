package com.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Rocketmq事务 demo
 *
 * @author Ciwei
 */
@EnableTransactionManagement
@SpringBootApplication
public class AlibabaRocketMqTxApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaRocketMqTxApplication.class, args);
    }

}
