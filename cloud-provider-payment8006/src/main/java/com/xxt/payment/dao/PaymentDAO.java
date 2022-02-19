package com.xxt.payment.dao;

import com.xxt.cloud.common.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiantao.xiang
 * @date 2022-02-19 14:08
 **/
@Mapper
public interface PaymentDAO {

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
    Payment getById(@Param("id") Long id);

}
