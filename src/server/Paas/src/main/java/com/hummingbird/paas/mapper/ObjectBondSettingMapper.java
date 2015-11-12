package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ObjectBondSetting;

public interface ObjectBondSettingMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ObjectBondSetting record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ObjectBondSetting record);

    /**
     * 根据主键查询记录
     */
    ObjectBondSetting selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ObjectBondSetting record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ObjectBondSetting record);
    
    /**
     * 查询投标保证金
     * @param objectId
     * @return
     */
    Integer getObjectBidderBond(String objectId);

	/**
	 * 根据标的id查询记录
	 * @param objectId
	 * @return
	 */
	ObjectBondSetting selectByObjectId(String objectId);
}