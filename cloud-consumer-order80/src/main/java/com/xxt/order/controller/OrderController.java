package com.xxt.order.controller;


import com.xxt.cloud.common.base.CommonResult;
import com.xxt.cloud.common.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 14:29
 **/
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    //private static final String payment_url = "http://localhost:8001/payment/";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public CommonResult getById(Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "payment/get?id={id}", CommonResult.class, id);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }
}
