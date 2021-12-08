package com.yichen.test.controller;

import com.alibaba.fastjson.JSON;
import com.yichen.test.model.ParamFromStreamDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 17:02
 * @describe 测试 controller
 */
@Controller
public class TestController {

    private static Logger logger= LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/get")
    @ResponseBody
    public String get()throws Exception{
//        Thread.sleep(2000);
//        System.out.println(">>> arrive");
        return "visit interface get";
    }

    @RequestMapping("/show")
    @ResponseBody
    public String show()throws Exception{
        return "visit interface show";
    }

    @RequestMapping("/paramStream")
    @ResponseBody
    public String paramStream(HttpServletRequest request){
        String reqString=getReqString(request);
        logger.info("reqString {}",reqString);
        ParamFromStreamDto dto = JSON.parseObject(reqString, ParamFromStreamDto.class);
        return dto.toString();
    }

    @RequestMapping("/paramStream1")
    @ResponseBody
    public String paramStream1(@RequestBody ParamFromStreamDto dto){
        logger.info("dto {}",dto);
        return dto.toString();
    }


    private String getReqString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return String.valueOf(sb);
    }


}
