package com.yichen.service.service.feign;

import com.yichen.service.service.defaultImpl.TestFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 16:52
 * @describe 远程调用
 */
@FeignClient(name = "test",url = "http://localhost:8088",fallback = TestFeignImpl.class)
public interface TestFeign {

    @RequestMapping("/get")
    String get();

}
