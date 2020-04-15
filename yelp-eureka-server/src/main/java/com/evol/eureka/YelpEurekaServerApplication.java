package com.evol.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YelpEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YelpEurekaServerApplication.class, args);
    }

}
