package com.ciwei.gateway.dynamic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author 马秀成
 * @date 2019/9/2
 * @jdk.version 1.8
 * @desc 动态规则配置
 */
@ConfigurationProperties(prefix = "nacos.dynamic.route")
@Configuration
@Slf4j
public class NacosDynamicRouteService implements ApplicationEventPublisherAware {

    private static final String DATA_ID = "gateway-router.json";
    private static final String Group = "alibaba";

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    private ApplicationEventPublisher applicationEventPublisher;

    @Bean
    public void refreshRouting() throws NacosException {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, "114.67.104.142:8848");
//        properties.put(PropertyKeyConst.NAMESPACE, "8282c713-da90-486a-8438-2a5a212ef44f");
        ConfigService configService = NacosFactory.createConfigService(properties);
        configService.addListener(DATA_ID, Group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                log.info(configInfo);

                boolean refreshGatewayRoute = JSONObject.parseObject(configInfo).getBoolean("refreshGatewayRoute");

                if (refreshGatewayRoute) {
                    List<RouteEntity> list = JSON.parseArray(JSONObject.parseObject(configInfo).getString("routeList")).toJavaList(RouteEntity.class);

                    for (RouteEntity route : list) {
                        update(assembleRouteDefinition(route));
                    }
                } else {
                    log.info("路由未发生变更");
                }
            }
        });
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 路由更新
     *
     * @param routeDefinition
     * @return
     */
    public void update(RouteDefinition routeDefinition) {

        try {
            this.routeDefinitionWriter.delete(Mono.just(routeDefinition.getId()));
            log.info("路由更新成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
            this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
            log.info("路由更新成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public RouteDefinition assembleRouteDefinition(RouteEntity routeEntity) {

        RouteDefinition definition = new RouteDefinition();

        // ID
        definition.setId(routeEntity.getId());

        // Predicates
        List<PredicateDefinition> pdList = new ArrayList<>();
        for (PredicateEntity predicateEntity : routeEntity.getPredicates()) {
            PredicateDefinition predicateDefinition = new PredicateDefinition();
            predicateDefinition.setArgs(predicateEntity.getArgs());
            predicateDefinition.setName(predicateEntity.getName());
            pdList.add(predicateDefinition);
        }
        definition.setPredicates(pdList);

        // Filters
        List<FilterDefinition> fdList = new ArrayList<>();
        for (FilterEntity filterEntity : routeEntity.getFilters()) {
            FilterDefinition filterDefinition = new FilterDefinition();
            filterDefinition.setArgs(filterEntity.getArgs());
            filterDefinition.setName(filterEntity.getName());
            fdList.add(filterDefinition);
        }
        definition.setFilters(fdList);

        // URI
        URI uri = UriComponentsBuilder.fromUriString(routeEntity.getUri()).build().toUri();
        definition.setUri(uri);

        return definition;
    }

}