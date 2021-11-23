package com.yichen.batch.dao;

import com.yichen.batch.po.TTriggerAnalysePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/11/23 15:54
 * @describe
 */
@Mapper
public interface TTRiggerAnalyseDao {

    int insert(@Param("records") TTriggerAnalysePo records);

}
