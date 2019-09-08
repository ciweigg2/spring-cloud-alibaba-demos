package com.ciwei.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @NAME GateWayProperties
 * @USER Ciwei
 * @DATE 2019/9/7 17:34
 **/
@ConfigurationProperties(prefix = "alibaba.lb.gateway")
@Data
public class AlibabaGateWayProperties {

	/**
	 * 是否开启版本过滤器
	 */
	private boolean enabled;

}
