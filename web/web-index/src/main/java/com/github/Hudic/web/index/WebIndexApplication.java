package com.github.Hudic.web.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 15:10
 */
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
public class WebIndexApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebIndexApplication.class, args);
    }
}
