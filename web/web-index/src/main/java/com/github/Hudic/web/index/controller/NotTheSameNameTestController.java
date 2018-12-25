package com.github.Hudic.web.index.controller;

import com.github.Hudic.web.index.service.NotTheSameNameTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hudic
 * Created by Makkah at 2018/12/25 10:48
 * 测试 方法名全不同的测试，feign服务提供方不做任何修改，只在feign调用方搞事情
 */
@RestController
public class NotTheSameNameTestController {
    private final NotTheSameNameTestService notTheSameNameTestService;

    // 使用构造器注入，因为Java变量的初始化顺序为：静态变量或静态语句块–>实例变量或初始化语句块–>构造方法–>@Autowired
    @Autowired
    public NotTheSameNameTestController(NotTheSameNameTestService service) {
        this.notTheSameNameTestService = service;
    }

    @RequestMapping("/notTheSameNameTest1")
    public String test1() {
        return notTheSameNameTestService.getNotTheSameNameTestHello();
    }

    @RequestMapping("/notTheSameNameTest2")
    public String test2() {
        return notTheSameNameTestService.getNotTheSameNameTestDatabase();
    }
}
