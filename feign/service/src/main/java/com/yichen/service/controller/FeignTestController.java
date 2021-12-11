package com.yichen.service.controller;

import com.yichen.service.service.feign.FeignTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yichen
 * @version 1.0.0
 * @ClassName FeignTestController.java
 * @Description TODO
 * @createTime 2021年12月11日 10:36:00
 */
@RequestMapping("/feign")
@RestController
public class FeignTestController {

    private static Logger logger= LoggerFactory.getLogger(FeignTestController.class);

    @Resource
    private FeignTest feignTest;

    @RequestMapping("/linkByEureka")
    public String linkByEureka(){
        logger.info("service linkByEureka");
        String res="";
        try{
            res=feignTest.linkByEureka();
        }
        catch (Exception e){
            res=e.getMessage();
        }
        return res;
    }



}
