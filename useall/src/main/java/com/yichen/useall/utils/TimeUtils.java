package com.yichen.useall.utils;

import com.yichen.useall.constants.CommonConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/21 9:21
 * @describe 时间工具类
 */
public class TimeUtils {

    /**
     * 将给定的时间戳转换成 年月日形式的格式
     * @param timestamp  待转化的时间戳
     * @return  年月日形式的日期格式
     */
    public static String timeStampToDate(String timestamp){
        return timeStampToDate(timestamp,CommonConstants.DATE_FORMAT);
    }

    /**
     * 将给定的时间戳转换成 年月日形式的格式
     * @param timestamp  待转化的时间戳
     * @param format  自定义的日期格式
     * @return  年月日形式的日期格式
     */
    public static String timeStampToDate(String timestamp,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(new Date(Long.parseLong(timestamp)));
    }


    public static void main(String[] args) {
        System.out.println(timeStampToDate("1634778053097"));
        Date date=new Date();
        System.out.println(date.getTime());
    }

}
