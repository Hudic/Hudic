package com.github.Hudic.web.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 17:05
 */
@SpringBootApplication  //config client 启动类只需要@SpringBootApplication注解就可以
public class WebBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebBackApplication.class, args);
    }
}
