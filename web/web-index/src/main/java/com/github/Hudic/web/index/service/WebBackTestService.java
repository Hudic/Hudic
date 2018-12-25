package com.github.Hudic.web.index.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Hudic
 * Created by Makkah at 2018/12/25 9:45
 */
@FeignClient(name = "web-back")
public interface WebBackTestService {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String getHello();

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    String getDatabase();
}
