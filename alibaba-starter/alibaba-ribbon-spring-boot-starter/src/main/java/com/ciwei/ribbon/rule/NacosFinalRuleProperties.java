package com.ciwei.ribbon.rule;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "ribbon.is-cluster-version")
@Data
public class NacosFinalRuleProperties {

    /**
     * 是否开启集群版本控制
     */
    private boolean enabled = false;

}
