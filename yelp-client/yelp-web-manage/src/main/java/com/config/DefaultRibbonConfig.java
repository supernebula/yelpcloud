package com.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DefaultRibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
        //return new RandomRule();
    }
}
