package com.ciwei.user.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;

/**
 * @author 马秀成
 * @date 2019/8/27
 * @jdk.version 1.8
 * @desc nacos监听配置变化
 */
@Component
@Slf4j
public class NacosListener {

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @PostConstruct
    public void init() throws NacosException {
        nacosConfigProperties.configServiceInstance().addListener("users.properties", "alibaba", new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                log.info("onReceived(Properties) : {}", s);
            }
        });
    }

}
