package com.xxt.payment.controller;

import com.xxt.payment.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiantao.xiang
 * @date 2022-02-21 21:44
 **/
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/success")
    public String success(@RequestParam Integer id) {
        return hystrixService.infoOK(id);
    }


    /**
     * 超时或者异常
     *
     * @param id id
     * @return result
     */
    @GetMapping("/timeout")
    public String timeout(@RequestParam("id") Integer id) {
        return hystrixService.infoTimeOut(id);
    }

    @GetMapping("/cb")
    public String cb(@RequestParam("id") String id) {
        return hystrixService.cb(Integer.parseInt(id));
    }
}
