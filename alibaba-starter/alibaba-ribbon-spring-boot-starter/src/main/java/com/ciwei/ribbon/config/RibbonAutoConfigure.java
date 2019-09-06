package com.ciwei.ribbon.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon扩展配置类
 *
 * @author Ciwei
 * @date 2018/11/17 9:24
 */
@EnableConfigurationProperties(RestTemplateProperties.class)
@Configuration
public class RibbonAutoConfigure {

//    @Configuration
//    @ConditionalOnProperty(value = ConfigConstants.CONFIG_RIBBON_ISOLATION_ENABLED, havingValue = "true")
//    @RibbonClients(defaultConfiguration = {RuleConfigure.class})
//    public class LbIsolationConfig {
//    }

}
