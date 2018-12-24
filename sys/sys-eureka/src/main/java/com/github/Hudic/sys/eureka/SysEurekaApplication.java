package com.github.Hudic.sys.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 15:01
 */
@EnableEurekaServer
@SpringBootApplication
public class SysEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysEurekaApplication.class, args);
    }
}
