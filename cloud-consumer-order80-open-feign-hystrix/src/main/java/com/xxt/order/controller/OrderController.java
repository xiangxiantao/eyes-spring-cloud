package com.xxt.order.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xxt.cloud.common.base.CommonResult;
import com.xxt.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 14:29
 **/
@RestController
@Slf4j
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    //@HystrixCommand(fallbackMethod = "getByIdFallback", commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "300")
    //})
    //@HystrixCommand(commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "300")
    //})
    @GetMapping("/get")
    public CommonResult getById(Long id) {
        String result = paymentFeignService.timeout(id.intValue());
        System.out.println("对方都响应了:" + result);
        return new CommonResult<String>(200, "ok", result);
    }

    public CommonResult getByIdFallback(Long id) {
        return new CommonResult<String>(200, "ok", "本地的controller兜底");
    }

    public CommonResult globalFallback() {
        return new CommonResult<String>(200, "ok", "本地的全局controller兜底");
    }
}
