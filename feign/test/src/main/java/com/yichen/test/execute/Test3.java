package com.yichen.test.execute;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/15 16:11
 * @describe  测试验证
 */
public class Test3 {
    public static void main(String[] args) {
        JSONObject res=new JSONObject();
        res.put("11","11");
        String d=res.toJSONString();
        JSONObject jsonObject = JSONObject.parseObject(d);
        System.out.println(jsonObject);
    }
}
