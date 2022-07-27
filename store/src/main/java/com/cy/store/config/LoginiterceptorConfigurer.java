package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/19 21:44
 * @Description: 完成处理器拦截器的注册
 */
@SuppressWarnings({"all"})
@Configuration //加载当前的拦截器并进行注册
public class LoginiterceptorConfigurer implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor loginInterceptor = new LoginInterceptor();


        //配置白名单:存放在List集合中
        List<String> patterns = new ArrayList<String>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");


        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")//要拦截的url是什么 /**代表所有请求被拦截
                .excludePathPatterns(patterns);
    }
}
