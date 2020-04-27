package com.yangluyao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yly
 * @ClassName EurekaApplicatin7002
 * @Date 2020/3/30 22:19
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicatin7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicatin7002.class, args);
    }
}
