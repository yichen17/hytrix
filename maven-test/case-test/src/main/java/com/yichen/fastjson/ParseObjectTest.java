package com.yichen.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yichen.model.Person;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/20 9:34
 * @describe 测试 fastjson 中 parseObject 方法 转换类是否需要默认构造函数
 */
public class ParseObjectTest {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("name","yichen");
        map.put("age","18");
        String s = JSONObject.toJSONString(map);
        Person person = JSON.parseObject(s, Person.class);
        System.out.println(person);
    }

}
