package com.github.Hudic.web.index.controller;

import com.github.Hudic.web.index.service.impl.HystrixTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Hudic
 * Created by Makkah at 2018/12/25 16:03
 */
@RestController
public class HystrixTestController {
    private final HystrixTestService hystrixTestService;
    private final RestTemplate restTemplate;

    @Autowired
    public HystrixTestController(RestTemplate restTemplate, HystrixTestService hystrixTestService) {
        this.restTemplate = restTemplate;
        this.hystrixTestService = hystrixTestService;
    }

    @RequestMapping("/testHystrix")
    public String testHystrix() {
        URI uri = URI.create("http://localhost:6101/recommended");
        return restTemplate.getForObject(uri, String.class);
    }

    @RequestMapping("/testHystrix1")
    public String testHystrix1() {
        return hystrixTestService.testHystrix();
    }
}
