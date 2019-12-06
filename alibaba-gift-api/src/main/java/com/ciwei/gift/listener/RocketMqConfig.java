package com.ciwei.gift.listener;

import com.alibaba.fastjson.support.spring.messaging.MappingFastJsonMessageConverter;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.context.annotation.Bean;

/**
 * 自定义发送和接收
 *
 * @author Ciwei
 */
@EnableBinding({MySource.class, MySink.class})
public class RocketMqConfig {

    /**
     * 如果在转换为JSON时不希望使用默认的Jackson实现
     * 而希望使用Alibaba的FastJson也是可以的
     * 注册MappingFastJsonMessageConverter就行
     *
     * @return com.alibaba.fastjson.support.spring.messaging.MappingFastJsonMessageConverter
     */
    @Bean
    @StreamMessageConverter
    public MappingFastJsonMessageConverter mappingFastJsonMessageConverter() {
        return new MappingFastJsonMessageConverter();
    }

}
