package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.Objects;

public interface ObjectMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String ObjectsId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Objects record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Objects record);

    /**
     * 根据主键查询记录
     */
    Objects selectByPrimaryKey(String ObjectsId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Objects record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Objects record);
    
    /**获取对应列表数组
     * */
    List<Objects> getPages(@Param("begin") int begin ,@Param("limit") int limit);
}