package com.yangluyao.springcloud.dao;

import com.yangluyao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yly
 * @ClassName PaymentService
 * @Date 2020/3/29 22:14
 * @Version 1.0
 **/
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}