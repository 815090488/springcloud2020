package com.yangluyao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author YLY
 * @ClassName FlowLimitController
 * @Date 2020/4/21
 * @Version 1.0.1
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "----------------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----------------testB";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
       log.info("test 测试RT");
        return "----------------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("test 测试异常比例");
        int i = 10/0;
        return "----------------testE  测试异常比例";
    }

    @GetMapping("/testF")
    public String testF() {
        log.info("test 测试异常数");
        int i = 10/0;
        return "----------------testF  测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        return "----------------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "----------------deal_testHotKey/(ㄒoㄒ)/~~";
    }
}
