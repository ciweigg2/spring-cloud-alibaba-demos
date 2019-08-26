package com.ciwei.user.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @NAME UserProperties
 * @USER Ciwei
 * @DATE 2019/8/26 23:19
 **/
@ConfigurationProperties(prefix = "users.config")
@Data
@Configuration
public class UserProperties {

	private String name;

}
