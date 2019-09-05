package com.ciwei.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlt
 * @date 2019/9/3
 */
@Configuration
public class RuleConfigure {

    /**
     * 版本路由
     */
    @Bean
    public IRule isolationRule() {
        return new CustomIsolationRule();
    }

}
