package com.evol.manage.feign;

import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

//利用Feign配置的自定义,局部启用Hystrix
public class FeignDisableHystrixConfiguration{

    //局部启用Hystrix
    @Bean
    @Scope("prototype")
    public HystrixFeign.Builder feignBuilder(){
        return HystrixFeign.builder();
    }

    //局部禁用Hystrix
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder  feignBuilder(){
//        return Feign.builder();
//    }
}