package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.ProjectPaymentDefineDetail;

public interface ProjectPaymentDefineDetailMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentDefineDetail record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentDefineDetail record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentDefineDetail selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentDefineDetail record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentDefineDetail record);
    
    /**
     * 根据招标Id查询下期付款定义
     */
    ProjectPaymentDefineDetail selectByObjectId(@Param("objectId")String objectId,@Param("period")Integer payPeriod);

    /**
     * 根据招标Id查询项目未付款部分的定义列表
     */
    List<ProjectPaymentDefineDetail> selectPayByObjectId(@Param("objectId")String objectId,@Param("period")Integer payPeriod);

}