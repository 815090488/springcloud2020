package com.yangluyao.springcloud.controller;

import com.yangluyao.springcloud.entities.CommonResult;
import com.yangluyao.springcloud.entities.Payment;
import com.yangluyao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author yly
 * @ClassName PaymentController
 * @Date 2020/3/29 22:13
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort："+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败,serverPort："+serverPort, null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***查询结果:" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,serverPort："+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,serverPort："+serverPort, null);
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
