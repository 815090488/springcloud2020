package com.yangluyao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author yly
 * @ClassName ConsumerHystrixDashboard
 * @Date 2020/4/3 21:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard9001.class,args);
    }
}
