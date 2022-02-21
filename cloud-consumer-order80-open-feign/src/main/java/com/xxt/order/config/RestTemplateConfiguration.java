package com.xxt.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 15:24
 **/
@Configuration
public class RestTemplateConfiguration {

    /**
     * LoadBalanced这个注解提供给restTemplate负载均衡的能力
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
