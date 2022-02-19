package com.xxt.payment.service;

import com.xxt.payment.dao.PaymentDAO;
import com.xxt.cloud.common.entity.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 14:28
 **/
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDAO paymentDAO;

    @Override
    public int create(Payment payment) {
        return paymentDAO.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDAO.getById(id);
    }
}
