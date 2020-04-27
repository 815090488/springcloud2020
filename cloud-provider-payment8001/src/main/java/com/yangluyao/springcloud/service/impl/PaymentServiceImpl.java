package com.yangluyao.springcloud.service.impl;

import com.yangluyao.springcloud.dao.PaymentDao;
import com.yangluyao.springcloud.entities.Payment;
import com.yangluyao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yly
 * @ClassName PaymentServiceImpl
 * @Date 2020/3/29 22:15
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}