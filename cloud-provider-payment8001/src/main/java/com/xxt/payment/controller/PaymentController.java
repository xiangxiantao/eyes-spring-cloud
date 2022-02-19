package com.xxt.payment.controller;

import com.xxt.cloud.common.base.CommonResult;
import com.xxt.cloud.common.entity.Payment;
import com.xxt.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 14:29
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get")
    public CommonResult getById(Long id) {
        log.info("coming get");
        final Payment payment = paymentService.getById(id);
        return new CommonResult(200, "success" + port, payment);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("coming create");
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "success" + port, payment);
        } else {
            return new CommonResult(444, "fail" + port);
        }
    }

    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });

        return this.discoveryClient;
    }
}
