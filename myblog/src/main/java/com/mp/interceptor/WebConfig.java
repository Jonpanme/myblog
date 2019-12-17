package com.mp.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author meipeng
 * @date 2019-11-4 10:30
 * @function web控制类  用于拦截器过滤设置
 */
@Configuration  //加注解后才是一个有效的注解类
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    //拦截admin下所有请求，用LoginInterceptor去过滤  除了/admin 和  admin/login
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");


        super.addInterceptors(registry);
    }
}
