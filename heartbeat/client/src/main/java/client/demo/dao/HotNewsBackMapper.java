package client.demo.dao;

import client.demo.model.HotNewsBack;
import client.demo.model.HotNewsBackExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HotNewsBackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int countByExample(HotNewsBackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int deleteByExample(HotNewsBackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int insert(HotNewsBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int insertSelective(HotNewsBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    List<HotNewsBack> selectByExampleWithBLOBs(HotNewsBackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    List<HotNewsBack> selectByExample(HotNewsBackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    HotNewsBack selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int updateByExampleSelective(@Param("record") HotNewsBack record, @Param("example") HotNewsBackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") HotNewsBack record, @Param("example") HotNewsBackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int updateByExample(@Param("record") HotNewsBack record, @Param("example") HotNewsBackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int updateByPrimaryKeySelective(HotNewsBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(HotNewsBack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hot_news_back
     *
     * @mbggenerated Fri Oct 29 16:11:23 CST 2021
     */
    int updateByPrimaryKey(HotNewsBack record);
}