package com.yangluyao.springcloud.service;

import com.yangluyao.springcloud.entities.CommonResult;
import com.yangluyao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author YLY
 * @ClassName PaymentServiceImpl
 * @Date 2020/4/22
 * @Version 1.0.1
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444444,"服务降级返回",new Payment(id,"errorSerial"));
    }
}
