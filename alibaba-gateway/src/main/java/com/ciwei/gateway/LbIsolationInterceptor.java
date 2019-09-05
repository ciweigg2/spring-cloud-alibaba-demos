package com.ciwei.gateway;

import com.ciwei.common.constant.CommonConstant;
import com.ciwei.common.context.LbIsolationContextHolder;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 负载均衡隔离规则截器
 *
 * @author zlt
 * @date 2019/8/5
 */
@Configuration
public class LbIsolationInterceptor implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> versionList = exchange.getRequest().getHeaders().get(CommonConstant.SPRING_CLOUD_VERSION);
        if (!CollectionUtils.isEmpty(versionList)) {
            LbIsolationContextHolder.setVersion(versionList.get(0));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
