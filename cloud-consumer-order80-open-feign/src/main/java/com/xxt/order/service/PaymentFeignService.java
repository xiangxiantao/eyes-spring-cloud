package com.xxt.order.service;

import com.xxt.cloud.common.base.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiantao.xiang
 * @date 2022-02-21 20:08
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get")
    CommonResult getById(@RequestParam("id") Long id);
}
