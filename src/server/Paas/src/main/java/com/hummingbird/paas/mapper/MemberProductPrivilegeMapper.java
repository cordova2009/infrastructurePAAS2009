package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.MemberProductPrivilege;

public interface MemberProductPrivilegeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MemberProductPrivilege record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MemberProductPrivilege record);

    /**
     * 根据主键查询记录
     */
    MemberProductPrivilege selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MemberProductPrivilege record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MemberProductPrivilege record);
    /**
     *根据产品id 找到 
     * */
    List<String> getPriviliges(Integer productId);

  
}