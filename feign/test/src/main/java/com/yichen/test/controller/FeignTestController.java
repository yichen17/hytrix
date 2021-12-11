package com.yichen.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yichen
 * @version 1.0.0
 * @ClassName FeignTest.java
 * @Description TODO
 * @createTime 2021年12月11日 10:32:00
 */
@RestController
@RequestMapping("/feign")
public class FeignTestController {

    private static Logger logger= LoggerFactory.getLogger(FeignTestController.class);

    /**
     * 测试 通过注册中心时，它的请求时长被ribbon覆盖 由原来的 10s 60s变成  1s  1s
     * @return
     */
    @RequestMapping("/linkByEureka")
    public String linkByEureka(){
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            logger.error(e.getMessage());
        }
        logger.info("linkByEureka");
        return "linkByEureka";
    }

}
