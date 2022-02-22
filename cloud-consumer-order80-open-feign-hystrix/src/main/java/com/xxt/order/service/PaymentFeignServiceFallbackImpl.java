package com.xxt.order.service;

import org.springframework.stereotype.Component;

/**
 * @author xiantao.xiang
 * @date 2022-02-22 23:02
 **/
@Component
public class PaymentFeignServiceFallbackImpl implements PaymentFeignService{

    @Override
    public String timeout(Integer id) {
        return "PaymentFeignServiceFallbackImpl timeout 兜底";
    }
}
