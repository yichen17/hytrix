package com.yichen.service.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/15 9:20
 * @describe feign 重试配置
 */
//@Configuration
public class GlobalFeignConfigure {
    public static int connectTimeOutMillis = 1000;
    public static int readTimeOutMillis = 3000;
//    @Bean
    /**
     * 全局超时配置
     */
//    public Request.Options options() { return new Request.Options(connectTimeOutMillis, readTimeOutMillis);}
    @Bean
    /**
     * 重试配置
     */
    public Retryer feignRetry() {
        System.out.println("===========================================================================");
        return new Retryer.Default(10000,10000,1);
    }
}
