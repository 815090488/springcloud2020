package com.yangluyao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yangluyao.springcloud.entities.CommonResult;
import com.yangluyao.springcloud.entities.Payment;
import com.yangluyao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author YLY
 * @ClassName CirleBreakerController
 * @Date 2020/4/22
 * @Version 1.0.1
 */
@RestController
public class CirleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback只负责业务异常  handlerFallback()
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
    //@SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
    exceptionsToIgnore = {IllegalArgumentException.class})//exceptionsToIgnore 忽略错误类,如果报此异常没有降级效果
    public CommonResult<Payment> fallback(@PathVariable Long id)  {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException ,该ID，没有对应记录，空指针异常");
        }

        return result;
    }
    //本例fallback
    public CommonResult handlerFallback(@PathVariable Long id,Throwable throwable)  {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444,"兜底异常handlerFallback"+throwable.getMessage(),payment);
    }

    //本例blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException throwable)  {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445,"blockHandler------sentinel限流"+throwable.getMessage(),payment);
    }

    //OpenFeigh

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long  id){
        return paymentService.paymentSQL(id);
    }

}
