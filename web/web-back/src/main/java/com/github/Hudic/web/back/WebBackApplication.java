package com.github.Hudic.web.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 17:05
 */
@EnableDiscoveryClient
@EnableSwagger2
//@EnableFeignClients     //所需的依赖是starter-openFeign，而不是starter-feign (basePackages = "com.github.Hudic.web.back.controller")
@SpringBootApplication  //config client 启动类只需要@SpringBootApplication注解就可以
public class WebBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebBackApplication.class, args);
    }
}
