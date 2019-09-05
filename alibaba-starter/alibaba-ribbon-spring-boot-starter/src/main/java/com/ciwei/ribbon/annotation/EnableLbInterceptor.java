package com.ciwei.ribbon.annotation;

import com.ciwei.ribbon.WebAppConfigurer;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 马秀成
 * @date 2019/9/5
 * @jdk.version 1.8
 * @desc
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({WebAppConfigurer.class})
public @interface EnableLbInterceptor {
}
