package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.ProjectPaymentPay;

public interface ProjectPaymentPayMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentPay record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentPay record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentPay selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentPay record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentPay record);
    /**
     * 根据标的获得最后一次付款的记录信息
     * @param objectId
     * @return
     */
    ProjectPaymentPay getLastRecord(String objectId);
    
    /**
     * 根据期数查询记录
     * @param period
     * @return
     */
    ProjectPaymentPay getRecordByPeriod(@Param("objectId")String objectId,@Param("period")Integer period);
    
    /**
     * 查询标的付款列表
     * @param objectId
     * @return
     */
    List<ProjectPaymentPay> queryPaidRecord(String objectId);
    
    /**
     * 按时付款次数
     */
    int getBiddeeOnTimeNum(Integer biddeeId);
    
    /**
     * 逾期付款次数
     */
    int getBiddeeOutTimeNum(Integer biddeeId);
    /**
     * 按时付款次数
     */
    int getBidderOnTimeNum(Integer bidderId);
    
    /**
     * 逾期付款次数
     */
    int getBidderOutTimeNum(Integer bidderId);
}