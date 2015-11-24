package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.ProjectPaymentRecord;

public interface ProjectPaymentRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentRecord record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentRecord selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentRecord record);
    
    /**
     * 根据标的Id查询付款记录
     * @param ObjectId
     * @return
     */
    List<ProjectPaymentRecord> selectPayByObjectId(String ObjectId);
    
    /**
     * 查询该标的已付款的金额
     * @param ObjectId
     * @return
     */
    Long getPaidAmountByObjectId(String ObjectId);
    
    /**
     * 根据标的Id查询收款记录
     * @param ObjectId
     * @return
     */
    List<ProjectPaymentRecord> selectReceiveByObjectId(String ObjectId);
    
    /**
     * 查询该标的已收款的金额
     * @param ObjectId
     * @return
     */
    Long getReceivedAmountByObjectId(String ObjectId);

}