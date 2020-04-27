package com.yangluyao.springcloud.service;

import com.yangluyao.springcloud.entities.CommonResult;
import com.yangluyao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author YLY
 * @ClassName PaymentService
 * @Date 2020/4/22
 * @Version 1.0.1
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long  id);
}
