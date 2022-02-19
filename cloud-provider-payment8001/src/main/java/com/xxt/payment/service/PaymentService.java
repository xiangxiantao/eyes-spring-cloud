package com.xxt.payment.service;

import com.xxt.cloud.common.entity.Payment;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 14:28
 **/
public interface PaymentService {


    /**
     * create
     *
     * @param payment payment
     * @return num
     */
    int create(Payment payment);

    /**
     * get
     *
     * @param id id
     * @return results
     */
    Payment getById(Long id);

}
