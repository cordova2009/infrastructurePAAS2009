package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;

public interface BidRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidRecord record);

    /**
     * 根据主键查询记录
     */
    BidRecord selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidRecord record);
    /**
     * 根据主键更新记录
     */
    int selectCountByObjectId(String objectId);
    
    /**
     * 招标方统计投标信息
     * @param objectId
     * @return
     */
    MyObjectTenderSurveyBodyVOResult selectTenderSurveyByObjectId(String objectId);
}