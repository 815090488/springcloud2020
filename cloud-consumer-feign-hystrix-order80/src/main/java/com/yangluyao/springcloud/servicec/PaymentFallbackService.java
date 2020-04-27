package com.yangluyao.springcloud.servicec;

import org.springframework.stereotype.Component;

/**
 * @author YLY
 * @Date 2020/4/3
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back--paymentInfo_TimeOut";
    }
}
