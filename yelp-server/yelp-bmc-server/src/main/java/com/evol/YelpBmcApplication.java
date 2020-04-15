package com.evol;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
@MapperScan("com.evol.mapper")
public class YelpBmcApplication {
    public static void main(String[] args){
        SpringApplication.run(YelpBmcApplication.class, args);
    }
}
