package com.yichen.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 17:02
 * @describe 测试 controller
 */
@Controller
public class TestController {

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        return "visit interface get";
    }

}
