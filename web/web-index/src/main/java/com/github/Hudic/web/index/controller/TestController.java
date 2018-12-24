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
@Api(consumes = "application/json;charset=UTF-8",
        produces = "application/json;charset=UTF-8",
        protocols = "http",
        value = "办件流转",
        tags = "办件流转的主要信息")
@RestController
public class TestController {
    @ApiOperation(value = "执行下一步流程", notes = "执行下一步流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qsblsh", value = "申报流水号", required = false, dataType = "String"),
            @ApiImplicitParam(name = "qsbxmmc", value = "事项名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "qbsName", value = "申请人", required = false, dataType = "String"),
            @ApiImplicitParam(name = "qisPost", value = "是否快递", required = false, dataType = "String"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "String"),
            @ApiImplicitParam(name = "limit", value = "分页大小", required = false, dataType = "String")
    })
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String index() {
        return "Hello World";
    }
}
