package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.ObjectAttachment;

public interface ObjectAttachmentMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ObjectAttachment record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ObjectAttachment record);

    /**
     * 根据主键查询记录
     */
    ObjectAttachment selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ObjectAttachment record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ObjectAttachment record);

	/**
	 * 根据标的查询附件
	 * @param objectId
	 * @return
	 */
	List<ObjectAttachment> selectByObjectId(String objectId);
	
	/**
	 * 查询招标附件
	 * @param objectId
	 * @return
	 */
	List<ObjectAttachment> selectTenderFileByObjectId(String objectId);
}