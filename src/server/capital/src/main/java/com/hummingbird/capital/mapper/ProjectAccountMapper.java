package com.hummingbird.capital.mapper;

import com.hummingbird.capital.entity.ProjectAccount;

public interface ProjectAccountMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String accountId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectAccount record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectAccount record);

    /**
     * 根据主键查询记录
     */
    ProjectAccount selectByPrimaryKey(String accountId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectAccount record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectAccount record);
    
    /**
     * 根据userId查询资金账户
     * @param userId
     * @return
     */
    ProjectAccount queryAccountInfo(Integer userId);
  
}