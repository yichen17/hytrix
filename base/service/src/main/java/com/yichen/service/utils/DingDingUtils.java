package com.yichen.service.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/11/2 9:18
 * @describe  钉钉工具类    功能： 1、报警   参考文章  https://blog.csdn.net/qq_42153997/article/details/106290215
 */
public class DingDingUtils {
    /**
     * 给钉钉群发送消息方法
     *
     * @param content 消息内容
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    public static String sendMsg(String content) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        try {
            //群机器人复制到的秘钥secret
            //String secret = "SECc986f2d199370a58870e17d86f976e12f6dc31bb6e3d71e44efas0a538bb5278";
            String secret = "SEC2736979dfb97fa35a7015d8a0281670e81feed8f7aa0f3df48be74a6da663c48";
            //获取系统时间戳
            long timestamp = Instant.now().toEpochMilli();
            //拼接
            String stringToSign = timestamp + "\n" + secret;
            //使用HmacSHA256算法计算签名
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            //进行Base64 encode 得到最后的sign，可以拼接进url里
            String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
            //钉钉机器人地址（配置机器人的webhook）
            String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=25595fb3f56732f742616489ea6d058c3dc3e06745ae5b47aac390a7b5d3bbe3&timestamp=" + timestamp + "&sign=" + sign;

            String result = HttpUtil.post(dingUrl, content);
            return result;
        } catch (Exception e) {
            // log.error("钉钉推送消息出现异常");
            return null;
        }

    }

    /**
     * @param content    内容
     * @param isAtAll    是否@所有人 如果写true mobileList失效
     * @param mobileList @人的手机号
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     */
    public static String buildReqStr(String content, boolean isAtAll, List<String> mobileList) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        //消息内容
        Map<String, String> contentMap = Maps.newHashMap();
        contentMap.put("content", content);
        //通知人
        Map<String, Object> atMap = Maps.newHashMap();
        //1.是否通知所有人
        atMap.put("isAtAll", isAtAll);
        //2.通知具体人的手机号码列表
        atMap.put("atMobiles", mobileList);
        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("msgtype", "text");
        reqMap.put("text", contentMap);
        reqMap.put("at", atMap);
        String contens = JSON.toJSONString(reqMap);

        String result = DingDingUtils.sendMsg(contens);
        return result;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        try {
            Integer i = null;
            if (i < 1) {

            }
        }catch(Exception e){
            DingDingUtils.buildReqStr("异常====>"+e.getMessage(), true, null);
        }
    }
}
