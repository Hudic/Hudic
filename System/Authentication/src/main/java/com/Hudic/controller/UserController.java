package com.Hudic.controller;

import com.Hudic.model.User;
import com.Hudic.service.UserService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * jiangcq
 * 2018/12/7 9:16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名密码注册", notes = "用户名密码注册,默认选定前台访问用户角色")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", required = false, paramType = "String"),
            @ApiImplicitParam(name = "password", value = "登陆密码", required = false, paramType = "String")})
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONObject register(@RequestBody User user) {
        return userService.register(user);
    }

    @ApiOperation(value = "用户名密码登录", notes = "用户名密码登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", required = false, paramType = "String"),
            @ApiImplicitParam(name = "password", value = "登陆密码", required = false, paramType = "String")})
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestBody User user) {
        return userService.login(user);
    }
}
