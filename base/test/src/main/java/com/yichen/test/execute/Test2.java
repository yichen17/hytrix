package com.yichen.test.execute;

import cn.hutool.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/15 8:51
 * @describe 多线程测试
 */
public class Test2 {

    private static Logger logger= LoggerFactory.getLogger(Test1.class);

    public static void main(String[] args) throws Exception{
        for(int i=0;i<30;i++){
            Thread thread=new Thread(new TestRunner(),"thread"+i);
            Thread.sleep(180);
            thread.start();
        }
    }

}
