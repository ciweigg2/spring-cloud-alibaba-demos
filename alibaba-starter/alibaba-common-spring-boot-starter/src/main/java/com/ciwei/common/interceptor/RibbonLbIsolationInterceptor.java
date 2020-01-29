package com.ciwei.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.ciwei.common.constant.CommonConstant;
import com.ciwei.common.context.LbIsolationContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 负载均衡隔离规则截器
 *
 * @author Ciwei
 * @date 2019/8/5
 */
public class RibbonLbIsolationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String version = request.getHeader(CommonConstant.SPRING_CLOUD_VERSION);
        if(StrUtil.isNotEmpty(version)){
            LbIsolationContextHolder.setVersion(version);
        }
        return true;
    }

}