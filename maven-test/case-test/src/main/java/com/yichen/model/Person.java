package com.yichen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/10/20 9:36
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String name;

    private String age;

}
