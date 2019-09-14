package com.ciwei.web;

import com.ciwei.ribbon.annotation.EnableServerVersionRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @NAME AlibabaWebSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableServerVersionRule
@EnableCircuitBreaker
public class AlibabaWebSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaWebSpringBootApplication.class, args);
    }

}
