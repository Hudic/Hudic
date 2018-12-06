package com.Hudic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * jiangcq
 * 2018/12/6 17:07
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(EurekaServer.class);
        SpringApplication.run(EurekaServer.class);
        logger.info("EurekaServer启动成功🐕");
    }
}
