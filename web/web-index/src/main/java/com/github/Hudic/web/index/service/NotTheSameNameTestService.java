package com.github.Hudic.web.index.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hudic
 * Created by Makkah at 2018/12/25 10:50
 * feign客户端 是否只需要接口一致而不需要方法名相同？ 的测试
 */
@FeignClient(name = "web-back")
public interface NotTheSameNameTestService {
    @RequestMapping("/hello")
    String getNotTheSameNameTestHello();

    @RequestMapping("/database")
    String getNotTheSameNameTestDatabase();
}
