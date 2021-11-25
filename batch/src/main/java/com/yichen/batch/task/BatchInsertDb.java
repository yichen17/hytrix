package com.yichen.batch.task;

import com.yichen.batch.dao.TTRiggerAnalyseDao;
import com.yichen.batch.po.TTriggerAnalysePo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/11/23 16:05
 * @describe
 */
@Component
public class BatchInsertDb implements CommandLineRunner {

    private static Logger logger= LoggerFactory.getLogger(BatchInsertDb.class);

    private volatile int times=0;
    private final int maxTimes=1000000;
    private volatile int success=0;

    @Autowired
    private TTRiggerAnalyseDao dao;

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<30;i++){
            new Thread(new MyTask(),"my task"+i).start();
        }
        logger.info("执行结束，一共{}个插入成功",success);
    }

    public class MyTask implements Runnable{




        @Override
        public void run() {
            while (times<maxTimes){
                try{
                    logger.info("插入{}",times);
                    TTriggerAnalysePo record=TTriggerAnalysePo.builder().name(""+UUID.randomUUID())
                            .amount(new BigDecimal(Math.random()*10000)).phone("").build();
                    success+=dao.insert(record);
                    times++;
                    Thread.sleep(20);
                }
                catch (InterruptedException e){
                    logger.error(e.getMessage());
                }
            }
        }
    }

}
