package com.ciwei.live;

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
public class AlibabaLiveSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaLiveSpringBootApplication.class, args);
    }

}
