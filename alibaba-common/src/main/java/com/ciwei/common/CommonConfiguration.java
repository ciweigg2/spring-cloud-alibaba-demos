package com.ciwei.common;

import com.ciwei.common.utils.SnowflakeIdWorker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @NAME CommonConfiguration
 * @USER Ciwei
 * @DATE 2019/9/8 16:33
 **/
public class CommonConfiguration {

	/**
	 * 雪花算法实现
	 */
	@Bean
	@ConditionalOnMissingBean
	public SnowflakeIdWorker snowflakeIdWorker(){
		SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1, 1);
		return snowflakeIdWorker;
	}

}
