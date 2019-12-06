package com.ciwei.common.config;

import com.nepxion.banner.LogoBanner;
import com.taobao.text.Color;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Banner初始化
 *
 * @author Ciwei
 * @date 2019/8/28
 */
public class BannerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            AlibabaInfos.getAlibabaInfos();
            LogoBanner logoBanner = new LogoBanner(BannerInitializer.class, "/ciwei/logo.txt", "Welcome to Ciwei", 5, 6, new Color[5], true);
            CustomBanner.show(logoBanner, AlibabaInfos.descriptions
            );
        }
    }

}
