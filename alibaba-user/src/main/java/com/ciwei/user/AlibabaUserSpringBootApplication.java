package com.ciwei.user;

import com.ciwei.ribbon.annotation.EnableServerVersionRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @NAME AlibabaGiftSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableServerVersionRule
@EnableCircuitBreaker
public class AlibabaUserSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaUserSpringBootApplication.class, args);
    }

}
