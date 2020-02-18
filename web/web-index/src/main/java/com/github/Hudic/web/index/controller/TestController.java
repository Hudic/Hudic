package com.github.Hudic.web.index.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hudic
 * Created by Makkah at 2018/12/21 11:12
 */
@RestController
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String index() {
        return "Hello World";
    }
}
