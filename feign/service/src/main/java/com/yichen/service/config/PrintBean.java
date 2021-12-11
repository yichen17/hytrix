package com.yichen.service.config;

import com.alibaba.fastjson.JSON;
import com.yichen.service.service.feign.TestFeign;
import feign.Feign;
import feign.ReflectiveFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/12/10 14:16
 * @describe
 */
@Component
public class PrintBean implements ApplicationContextAware {

    @Resource
    private TestFeign testFeign;


    private static Logger logger= LoggerFactory.getLogger(PrintBean.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {


        for (String s : applicationContext.getBeanDefinitionNames()) {
//            if(s.contains("FeignClient")){
//                logger.info("==> {} bean value", JSON.toJSONString(applicationContext.getBean(s)));
//            }
//            if(s.contains("feign")){
//                logger.info("==> {}",s);
//            }
//            else{
//                logger.info(s);
//            }

//            if(applicationContext.getBean(s) instanceof Feign){
//                logger.info("==> {}",JSON.toJSONString(applicationContext.getBean(s)));
//            }

        }


    }
}
