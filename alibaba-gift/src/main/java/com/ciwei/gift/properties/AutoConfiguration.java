package com.ciwei.gift.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author 马秀成
 * @date 2019/9/29
 * @jdk.version 1.8
 * @desc 测试自动装配
 */
@Slf4j
@EnableConfigurationProperties(AllConfigurationProperties.class)
@Configuration
public class AutoConfiguration {

    @Autowired
    AllConfigurationProperties allConfigurationProperties;

    @PostConstruct
    public void init(){
        System.out.println("allConfigurationProperties = " + allConfigurationProperties);
    }

}
