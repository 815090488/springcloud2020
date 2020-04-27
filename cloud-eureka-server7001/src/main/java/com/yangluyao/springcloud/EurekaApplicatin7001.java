package com.yangluyao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @author 81509
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicatin7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicatin7001.class, args);
    }
}
