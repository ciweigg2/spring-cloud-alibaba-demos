package com.ciwei.ribbon;

import com.ciwei.common.interceptor.RibbonLbIsolationInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @NAME WebAppConfigurer
 * @USER Ciwei
 * @DATE 2019/9/4 21:52
 **/
public class WebAppConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 可添加多个
		registry.addInterceptor(new RibbonLbIsolationInterceptor()).addPathPatterns("/**");
	}

}
