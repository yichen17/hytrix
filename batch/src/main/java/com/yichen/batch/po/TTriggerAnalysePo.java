package com.yichen.batch.po;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/11/23 15:56
 * @describe
 */
@Builder
@ToString
@Data
public class TTriggerAnalysePo {
    private Integer id;
    private BigDecimal amount;
    private String name;
    private String phone;


}
