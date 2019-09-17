package com.ciwei.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ciwei
 * @date 2019/9/3
 */
@Configuration
@EnableConfigurationProperties(value = NacosFinalRuleProperties.class)
public class RuleConfigure {

    /**
     * 版本路由
     */
    @Bean
    @ConditionalOnMissingBean
    public IRule isolationRule() {
        return new NacosFinalRule();
    }

}
