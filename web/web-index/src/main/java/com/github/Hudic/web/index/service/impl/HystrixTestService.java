package com.github.Hudic.web.index.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Hudic
 * Created by Makkah at 2018/12/25 14:49
 */
@Service
public class HystrixTestService {
    private final RestTemplate restTemplate;

    @Autowired
    public HystrixTestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "testFallback")
    public String testHystrix() {
        URI uri = URI.create("http://localhost:6101/recommended");
        return this.restTemplate.getForObject(uri, String.class);
    }

    public String testFallback() {
        return "Oops, something went wrong.";
    }
//    public HystrixTestService(RestTemplate restTemplate) {
//        RestTemplate restTemplate1 = restTemplate;
//    }
}
