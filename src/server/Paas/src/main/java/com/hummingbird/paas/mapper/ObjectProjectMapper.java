package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.ObjectProject;
import com.hummingbird.paas.entity.Objects;

public interface ObjectProjectMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String objectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ObjectProject record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ObjectProject record);

    /**
     * 根据主键查询记录
     */
    ObjectProject selectByPrimaryKey(String objectId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ObjectProject record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ObjectProject record);
    
    List<ObjectProject> getPages(@Param("begin") int begin ,@Param("limit") int limit);
}