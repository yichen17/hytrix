//package com.yichen.service.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.Arrays;
//
///**
// * @author Qiuxinchao
// * @version 1.0
// * @date 2021/11/2 17:29
// * @describe
// */
//@ControllerAdvice
//public class GlobalExceptionController {
//
//    private static Logger logger= LoggerFactory.getLogger(GlobalExceptionController.class);
//
//    @ExceptionHandler(value = Throwable.class)
//    public void exceptionHandler(Throwable e){
//        System.out.println(" ======================= ");
//        logger.error(e.getMessage()+"\n"+ Arrays.toString(e.getStackTrace()));
//    }
//
//}
