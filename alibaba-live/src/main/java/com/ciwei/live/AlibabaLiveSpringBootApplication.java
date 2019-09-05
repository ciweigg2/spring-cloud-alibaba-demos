package com.ciwei.live;

import com.ciwei.ribbon.annotation.EnableRibbonLbInterceptor;
import com.ciwei.ribbon.annotation.EnableVersionRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @NAME AlibabaGiftSpringBootApplication
 * @USER Ciwei
 * @DATE 2019/8/26/026 10:20
 **/
@SpringBootApplication
@EnableRibbonLbInterceptor
@EnableVersionRule
public class AlibabaLiveSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaLiveSpringBootApplication.class, args);
    }

}
