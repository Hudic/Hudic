package com.github.Hudic.sys.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 16:47
 */
@EnableConfigServer
@EnableDiscoveryClient  //也要注册到eureka中心去，才能被已经在eureka中心注册过的eureka client(同是也得是config client)所使用
@SpringBootApplication
public class SysConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysConfigApplication.class, args);
    }
}
