package com.Hudic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * jiangcq
 * 2018/12/6 19:37
 */
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class Authentication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Authentication.class);
        SpringApplication.run(Authentication.class);
        logger.info("Authentication服务启动成功🐒");
    }
}
