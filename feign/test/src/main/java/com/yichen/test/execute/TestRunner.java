package com.yichen.test.execute;

import cn.hutool.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/15 8:44
 * @describe 自定义runner
 */
public class TestRunner implements Runnable{

    private static Logger logger= LoggerFactory.getLogger(TestRunner.class);
    private static final String FORMAT="yyyy-MM-dd hh:mm:ss SSS";

    private static SimpleDateFormat dateFormat=new SimpleDateFormat(FORMAT);

    @Override
    public void run() {
        try {
            String start,end,value;
            while(true) {
                start = dateFormat.format(new Date());
                value = HttpRequest.get("http://localhost:9020/test/get").execute().body();
                end = dateFormat.format(new Date());
                logger.info(">>> {} start time={},value={},end time={}", Thread.currentThread().getName(),start, value, end);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
