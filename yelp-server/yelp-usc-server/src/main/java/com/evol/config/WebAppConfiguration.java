package com.evol.config;

import com.evol.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sn
 * @description
 * @date 2020/3/2
 */
@Configuration
public class WebAppConfiguration implements WebMvcConfigurer {

    @Bean
    public AuthorizationInterceptor getAccessLimitIntercept() {
        return new AuthorizationInterceptor();
    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getAccessLimitIntercept()).addPathPatterns("/**");
    }
}
