package com.xxt.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiantao.xiang
 * @date 2022-02-18 22:28
 **/
@SpringBootApplication
@EnableFeignClients
public class FeignOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication.class, args);
    }
}
