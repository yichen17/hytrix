package com.yichen.service.service.factory;

import com.yichen.service.service.defaultImpl.TestFeignImpl;
import com.yichen.service.service.feign.TestFeign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/11/2 17:26
 * @describe
 */
@Component
public class TestHystrixFactory implements FallbackFactory<TestFeign> {

    private static Logger logger= LoggerFactory.getLogger(TestHystrixFactory.class);

    @Override
    public TestFeign create(Throwable throwable) {
        if(throwable!=null){
//            logger.error(throwable.getMessage()+" >>> "+ Arrays.toString(throwable.getStackTrace()));
//            logger.error(throwable.getCause().toString());
//            logger.error(throwable.getStackTrace().toString());

//            int size=Math.min(5,throwable.getStackTrace().length);
//            for(int i=0;i<throwable.getStackTrace().length;i++){
//                logger.error(throwable.getStackTrace()[i].toString());
//            }

            logger.error("OrderApiFeign 触发降级 cause {},堆栈 => {}",throwable.getCause(),throwable.getStackTrace());
        }
        return new TestFeignImpl();
    }
}
