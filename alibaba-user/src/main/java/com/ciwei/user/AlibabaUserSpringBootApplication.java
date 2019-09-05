package com.ciwei.user;

import com.ciwei.ribbon.annotation.EnableRibbonLbInterceptor;
import com.ciwei.ribbon.annotation.EnableVersionRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @NAME AlibabaGiftSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@EnableFeignClients
@SpringBootApplication
@EnableRibbonLbInterceptor
@EnableVersionRule
public class AlibabaUserSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaUserSpringBootApplication.class, args);
    }

}
