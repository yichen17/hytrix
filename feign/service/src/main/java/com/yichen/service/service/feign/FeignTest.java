package com.yichen.service.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yichen
 * @version 1.0.0
 * @ClassName FeignTest.java
 * @Description 用于测试 feign 的相关功能  通过注册中心调用
 * @createTime 2021年12月11日 10:35:00
 */
@FeignClient(name = "FEIGN-INTERFACE")
public interface FeignTest {

    @RequestMapping("/feign/linkByEureka")
    String linkByEureka();

}
