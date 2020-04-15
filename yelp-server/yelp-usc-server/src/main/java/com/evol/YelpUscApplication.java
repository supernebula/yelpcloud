package com.evol;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.SpringCloudApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author evol
 */
//@SpringCloudApplication
//@EnableEurekaClient //从Edgware开始，该注解可以省略
@SpringBootApplication
@MapperScan("com.evol.mapper")
public class YelpUscApplication {

    public static void main(String[] args) {
        SpringApplication.run(YelpUscApplication.class, args);
    }
}
