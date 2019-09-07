package com.ciwei.gateway.filter;

import com.ciwei.common.constant.CommonConstant;
import com.ciwei.common.context.LbIsolationContextHolder;
import com.ciwei.gateway.properties.AlibabaGateWayProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 负载均衡隔离规则过滤器 开启根据version选择对应的服务 服务注册需要开启拦截器
 *
 * @author Ciwei
 * @date 2019/8/5
 */
@Configuration
@ConditionalOnProperty(name = "alibaba.lb.gateway.enable" ,havingValue = "true")
@EnableConfigurationProperties(value = AlibabaGateWayProperties.class)
public class GateWayLbIsolationFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取服务的version
        List<String> versionList = exchange.getRequest().getHeaders().get(CommonConstant.SPRING_CLOUD_VERSION);
        if (!CollectionUtils.isEmpty(versionList)) {
            //设置服务使用的version
            LbIsolationContextHolder.setVersion(versionList.get(0));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
