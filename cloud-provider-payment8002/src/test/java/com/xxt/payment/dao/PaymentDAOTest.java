package com.xxt.payment.dao;

import com.xxt.cloud.common.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentDAOTest {

    @Autowired
    private PaymentDAO paymentDAO;

    @Test
    public void selectPayment() {
        final Payment payment = paymentDAO.getById(1L);
        System.out.println(payment);
    }

    @Test
    public void creat() {
        Payment payment = new Payment();
        payment.setSerial("无敌序列号");
        final int result = paymentDAO.create(payment);
        System.out.println(result);
    }
}