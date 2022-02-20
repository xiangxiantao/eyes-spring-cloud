package com.xxt.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiantao.xiang
 * @date 2022-02-18 22:28
 **/
@SpringBootApplication
@EnableEurekaClient
//开启下面这个注解标识对指定的服务调用采用自定义的负载均衡策略
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RuleConfig.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
