package com.xxt.payment.controller;

import com.xxt.cloud.common.base.CommonResult;
import com.xxt.cloud.common.entity.Payment;
import com.xxt.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 14:29
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/get")
    public CommonResult getById(Long id) {
        final Payment payment = paymentService.getById(id);
        return new CommonResult(200, "success", payment);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "fail");
        }
    }
}
