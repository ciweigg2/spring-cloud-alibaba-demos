package com.ciwei.gift.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 马秀成
 * @date 2019/9/29
 * @jdk.version 1.8
 * @desc
 */
@Data
@ConfigurationProperties(prefix = "alibaba")
public class AllConfigurationProperties {

    /**
     * 普通变量
     */
    private String name;

    /**
     * 引用对象
     */
    private OtherProperties other;

    /**
     * 数组
     */
    private String[] server;

    /**
     * list
     */
    private List list;

    /**
     * map
     */
    private Map map;

    /**
     * 复杂map
     */
    private Map<String, ModuleConfig> modules = new LinkedHashMap();

    /**
     * 复杂list
     */
    private List<ModuleConfig> modulesList;

}
