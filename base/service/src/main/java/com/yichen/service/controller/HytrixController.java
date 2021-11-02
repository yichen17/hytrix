package com.yichen.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yichen.service.service.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 16:52
 * @describe  controller 做降级处理     @HystrixProperty 相关参数见  HystrixPropertiesManager  类
 *         服务 熔断、降级、限流、隔离的概念    https://www.cnblogs.com/ming-blogs/p/10793694.html
 */
@Controller
@RequestMapping("/test")
public class HytrixController {

    @Autowired
    private TestFeign testFeign;

    @HystrixCommand(defaultFallback = "fallback",
    commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
    @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value = "10000")},
    threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "5"),
            @HystrixProperty(name = "maxQueueSize",value = "10")
    })
    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        System.out.println(">>> arrive");
        String value=testFeign.get();
        System.out.println(">>> leave");
        return value;
    }

}
