package com.yichen.useall.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/8/30 16:58
 * @describe mysql 数据库相关的工具类
 *   用途：根据 mysql表构建 其他服务的 model 类供 自己进行 单元测试
 *   1、在 navicat 中找到对应表，选择一条记录，右键行前选择 复制 insert 语句
 *   2、将语句放于 下面类的 main 中，运行即可生成对应的 由 fastjson 转换而成的 string
 *   3、将运行的结果放于 单元测试中，通过 JSONObject.parseObject() 生成对象
 */

public class SqlUtils {

    private static Logger logger= LoggerFactory.getLogger(SqlUtils.class);

    /**
     * 根据 insert sql 构造 json格式 数据字符串
     * <font color=red>这里的sql 必然是简单插入.也不存在列取别名</font>
     * @param insertSql insert 类型的数据sql
     * @return json 转换而来的 字符串
     */
    public static String constructMapFromInsertSql(String insertSql){
        String[] a=insertSql.replace("(","|").split("\\|");
        String [] b=a[1].replace(")","|").split("\\|");
        String []c=a[2].replace(")","|").split("\\|");
        String []fields=b[0].replace("`","").split(",");
        String []values=c[0].replace("'","").split(",");
        JSONObject res=new JSONObject();
        for(int i=0;i<fields.length;i++){
            res.put(FormatUtils.lineToHump(fields[i].trim()),values[i].trim());
        }
        // TODO 这里存在一个缺陷， NULL 类型被加了 双引号，需要手动转换，不然无法转回对象
        String r=JSONObject.toJSONString(res);

        //  去掉null 前后的 双引号
        r=r.replace("\"NULL\"","NULL");

        logger.info("转换后的结果{}",r);
        return r;
    }




    public static void main(String[] args) {
        constructMapFromInsertSql("INSERT INTO `wk_db_loan`.`wk_mall_order`(`id`, `account_id`, `order_account_id`, `phone`, `customer_id`, `cert_id`, `channel_id`, `sku`, `order_id`, `parent_order_id`, `product_img_url`, `product_name`, `pay_amt`, `cash_back_rate`, `cash_back_amt`, `vip_cash_back_amt`, `status`, `order_status`, `channel_order_time`, `channel_finish_time`, `cash_back_time`, `channel_update_time`, `create_time`, `update_time`) VALUES (6, 22041166667075004, 21048862, '18515190292', 1170262902, '652322199108302528', '1', '612967574146211840', '210027207213', '0', 'http://img11.360buyimg.com/n0/jfs/t1/122688/5/16527/34676/60d945a5Edf671206/0944f8118bb4940d.jpg', '路路测试京东订单', 899.00, 0.00, 100.00, 0.00, '3', '17', '2021-08-11 16:55:14', '2021-08-11 16:55:16', '2021-08-11 16:55:20', '2021-08-11 16:55:22', '2021-08-11 16:55:26', '2021-08-11 16:55:28');\n");

    }

}
