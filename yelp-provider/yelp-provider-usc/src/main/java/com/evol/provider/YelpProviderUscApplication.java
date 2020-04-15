package com.evol.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //从Edgware开始，该注解可以省略
public class YelpProviderUscApplication {

    public static void main(String[] args) {
        SpringApplication.run(YelpProviderUscApplication.class, args);
    }

}
