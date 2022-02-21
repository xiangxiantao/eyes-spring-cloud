package com.xxt.order.controller;


import com.xxt.cloud.common.base.CommonResult;
import com.xxt.cloud.common.entity.Payment;
import com.xxt.order.service.PaymentFeignService;
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

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get")
    public CommonResult getById(Long id) {
        return paymentFeignService.getById(id);
    }
}
