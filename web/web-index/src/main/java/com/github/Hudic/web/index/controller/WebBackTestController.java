package com.github.Hudic.web.index.controller;

import com.github.Hudic.web.index.service.WebBackTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hudic
 * Created by Makkah at 2018/12/25 9:35
 */
@RestController
public class WebBackTestController {
    private final WebBackTestService webBackTestService;

    // 使用构造器注入，因为Java变量的初始化顺序为：静态变量或静态语句块–>实例变量或初始化语句块–>构造方法–>@Autowired
    @Autowired
    public WebBackTestController(WebBackTestService webBackTestService) {
        this.webBackTestService = webBackTestService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return webBackTestService.getHello();
    }

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public String getDatabase() {
        return webBackTestService.getDatabase();
    }
}
