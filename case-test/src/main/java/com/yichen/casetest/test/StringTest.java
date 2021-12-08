package com.yichen.casetest.test;

/**
 * @author yichen
 * @version 1.0.0
 * @ClassName StringTest.java
 * @Description 测试字符串相关问题
 *     总结：  String.substring() 入参范围为  [0,len]
 * @createTime 2021年12月08日 22:35:00
 */
public class StringTest {
    public static void main(String[] args) {
        String a="111";
        System.out.println(a.indexOf("."));
//        System.out.println(a.substring(-1));
        System.out.println(a.substring(3));
    }
}
