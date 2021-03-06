package com.xxt.payment.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author lixiaolong
 * @date 2020-02-20 11:11
 */
@Service
public class HystrixService {
    /**
     * 正常访问，肯定OK
     *
     * @param id
     * @return
     */
    public String infoOK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfoOK,id:  " + id + "\t"
                + "O(∩_∩)O哈哈~";
    }


    /**
     * 超时访问，设置自身调用超时的峰值，峰值内正常运行，超过了峰值需要服务降级 自动调用fallbackMethod 指定的方法
     * 超时异常或者运行异常 都会进行服务降级
     *
     * @param id id
     * @return results
     */
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000")
    })
    public String infoTimeOut(Integer id) {
//        int age = 10/0;
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "线程池:  " + Thread.currentThread().getName() + " paymentInfoTimeOut,id:  " + id + "\t"
                + "O(∩_∩)O哈哈~" + "  耗时(毫秒): " + (end - start);
    }


    /**
     * paymentInfoTimeOut 方法失败后 自动调用此方法 实现服务降级 告知调用者 paymentInfoTimeOut 目前无法正常调用
     *
     * @param id
     * @return
     */
    public String fallback(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfoTimeOutHandler8001系统繁忙或者运行报错，请稍后再试,id:  " + id + "\t"
                + "o(╥﹏╥)o";
    }


    @HystrixCommand(fallbackMethod = "cbFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),/* 是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public String cb(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return "调用成功" + new Random().nextInt();
    }

    public String cbFallback(Integer id) {
        return "系统错误，请稍后再试" + new Random().nextInt();
    }

}
