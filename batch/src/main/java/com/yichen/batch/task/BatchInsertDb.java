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

    @Autowired
    private TTRiggerAnalyseDao dao;

    @Override
    public void run(String... args) throws Exception {
        int sum=0;
        for(int i=0;i<10000000;i++){
            TTriggerAnalysePo record=TTriggerAnalysePo.builder().name(""+UUID.randomUUID())
                    .amount(new BigDecimal(Math.random()*10000)).phone("").build();
            sum+=dao.insert(record);
        }
        logger.info("执行完毕，插入条数 {}",sum);
    }
}
