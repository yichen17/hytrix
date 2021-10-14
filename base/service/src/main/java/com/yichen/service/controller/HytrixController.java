package com.yichen.service.controller;

import com.yichen.service.service.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 16:52
 * @describe
 */
@Controller
@RequestMapping("/test")
public class HytrixController {

    @Autowired
    private TestFeign testFeign;

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        System.out.println(">>> arrive");
        String value=testFeign.get();
        System.out.println(">>> leave");
        return value;
    }

}
