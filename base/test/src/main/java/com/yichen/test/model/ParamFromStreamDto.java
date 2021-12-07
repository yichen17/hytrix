package com.yichen.test.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/12/7 16:08
 * @describe
 */
@Data
@ToString
public class ParamFromStreamDto {
    private Integer age;
    private String name;
    private String address;
}
