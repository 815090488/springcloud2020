package com.yangluyao.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MySelfRule
 * @description: Ribbon负载均衡配置类
 * @author: yly
 * @create: 2020/4/2 09:02
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
