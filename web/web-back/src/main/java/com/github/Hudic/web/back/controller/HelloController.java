package com.github.Hudic.web.back.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 17:07
 */
@RestController
@RefreshScope
// 需要给加载变量的类上面加载@RefreshScope，在客户端执行/refresh的时候就会更新此类下面的变量值。使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class HelloController {
    @Value("${hudic.hello}")
    private String hello;
    @Value("${mysql.database}")
    private String database;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String from() {
        return hello;
    }

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public String getDatabase() {
        return database;
    }
}
