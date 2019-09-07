package com.ciwei.ribbon.annotation;

import com.ciwei.ribbon.rule.RuleConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 马秀成
 * @date 2019/9/5
 * @jdk.version 1.8
 * @desc 开启服务版本拦截器
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(RuleConfigure.class)
public @interface EnableGateWayVersionRule {
}
