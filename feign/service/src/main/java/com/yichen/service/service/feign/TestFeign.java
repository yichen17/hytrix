package com.yichen.service.service.feign;

import com.yichen.service.model.ParamFromStreamDto;
import com.yichen.service.service.defaultImpl.TestFeignImpl;
import com.yichen.service.service.factory.TestHystrixFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 16:52
 * @describe 远程调用
 */
//@FeignClient(name = "test",url = "http://localhost:8088",fallbackFactory = TestHystrixFactory.class)
@FeignClient(name = "test",url = "http://localhost:8088")
public interface TestFeign {

    @RequestMapping("/get")
    String get();

    @RequestMapping("/show")
    String show();

    /**
     * 一个参数 json 传输方式 通过流获取
     * @param reqString 请求数据
     * @return 返回结果
     */
    @RequestMapping(value = "/paramStream",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String paramStream(@RequestBody ParamFromStreamDto reqString);

    /**
     * 一个参数 json 传输方式 通过注解获取
     * @param reqString 请求数据
     * @return 返回结果
     */
    @RequestMapping(value = "/paramStream1",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String paramStream1(@RequestBody ParamFromStreamDto reqString);

}
