package com.xxt.payment.service;


import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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
    public String infoTimeOut(Integer id) {
//        int age = 10/0;
        int second = 3;
        long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "线程池:  " + Thread.currentThread().getName() + " paymentInfoTimeOut,id:  " + id + "\t"
                + "O(∩_∩)O哈哈~" + "  耗时(秒): " + second;
    }

}
