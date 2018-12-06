package com.Hudic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * jiangcq
 * 2018/12/6 18:12
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class Polaris {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Polaris.class);
        SpringApplication.run(Polaris.class);
        logger.info("Polaris模块启动成功🐖");
    }
}
