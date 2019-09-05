package com.ciwei.gateway;

import com.ciwei.ribbon.annotation.EnableVersionRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @NAME AlibabaGiftSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@SpringBootApplication
@EnableVersionRule
public class AlibabaGateWaySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaGateWaySpringBootApplication.class, args);
    }

}
