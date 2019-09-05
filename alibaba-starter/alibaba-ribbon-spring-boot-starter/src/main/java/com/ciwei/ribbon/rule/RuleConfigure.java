package com.ciwei.ribbon.rule;

import com.ciwei.ribbon.WebAppConfigurer;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlt
 * @date 2019/9/3
 */
@Configuration
public class RuleConfigure {

    @Bean
    public IRule isolationRule() {
        return new CustomIsolationRule();
    }

//    @Bean
//    public WebAppConfigurer webAppConfigurer(){
//        return new WebAppConfigurer();
//    }

}
