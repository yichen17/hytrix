package com.yichen.service.service.defaultImpl;

import com.yichen.service.service.feign.TestFeign;
import org.springframework.stereotype.Component;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 16:58
 * @describe  默认实现
 */
@Component
public class TestFeignImpl implements TestFeign {
    @Override
    public String get() {
        return "this interface is block";
    }
}
