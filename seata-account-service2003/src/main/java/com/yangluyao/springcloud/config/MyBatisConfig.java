package com.yangluyao.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yangluyao.springcloud.dao")
public class MyBatisConfig {
}
