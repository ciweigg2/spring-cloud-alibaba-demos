package com.ciwei.gift;

import com.ciwei.ribbon.annotation.EnableServerVersionRule;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @NAME AlibabaGiftSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableServerVersionRule
@EnableCircuitBreaker
public class AlibabaGiftSpringBootApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AlibabaGiftSpringBootApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}
