package com.yangluyao.springcloud.controller;

import com.yangluyao.springcloud.entities.CommonResult;
import com.yangluyao.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author YLY
 * @ClassName PaymentController
 * @Date 2020/4/22
 * @Version 1.0.1
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"111111111111111"));
        hashMap.put(2L,new Payment(2L,"222222222222222"));
        hashMap.put(3L,new Payment(3L,"333333333333333"));
    }
    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable(value = "id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql ,serverPort：" + serverPort, payment);
        return result;
    }
}
