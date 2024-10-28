package com.aiden.automation.domain.repository.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.aiden.automation.domain.repository.mybatis.mapper")
@Configuration
public class MyBatisConfig {

}
