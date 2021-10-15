package com.yichen.test.execute;

import cn.hutool.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/14 17:03
 * @describe 循环调用远程服务
 */
public class Test1 {

    private static Logger logger= LoggerFactory.getLogger(Test1.class);

    public static void main(String[] args) throws Exception{
        String format="yyyy-MM-dd hh:mm:ss SSS";
        SimpleDateFormat dateFormat=new SimpleDateFormat(format);
        String start,end,value;
        while(true){
            start=dateFormat.format(new Date());
            value= HttpRequest.get("http://localhost:9020/test/get").execute().body();
            end=dateFormat.format(new Date());
            logger.info(">>> start time={},value={},end time={}",start,value,end);
            Thread.sleep(100);
        }
    }

}
