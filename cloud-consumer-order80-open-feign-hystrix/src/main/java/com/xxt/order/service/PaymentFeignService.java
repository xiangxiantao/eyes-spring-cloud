package com.xxt.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiantao.xiang
 * @date 2022-02-21 20:08
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", fallback = PaymentFeignServiceFallbackImpl.class)
//@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/hystrix/timeout")
    String timeout(@RequestParam("id") Integer id);
}
