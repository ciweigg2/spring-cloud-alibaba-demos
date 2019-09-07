package com.ciwei.gift;

import com.ciwei.ribbon.annotation.EnableServerVersionRule;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @NAME AlibabaGiftSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@SpringBootApplication
@EnableServerVersionRule
@EnableDistributedTransaction
@EnableCircuitBreaker
public class AlibabaGiftSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaGiftSpringBootApplication.class, args);
    }

}
