package com.github.Hudic.sys.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 16:47
 */
@EnableConfigServer
@SpringBootApplication
public class SysConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysConfigApplication.class, args);
    }
}
