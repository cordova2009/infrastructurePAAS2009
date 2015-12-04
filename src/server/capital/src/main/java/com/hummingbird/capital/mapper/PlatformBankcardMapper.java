package com.hummingbird.capital.mapper;

import java.util.List;

import com.hummingbird.capital.entity.PlatformBankcard;

public interface PlatformBankcardMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(PlatformBankcard record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(PlatformBankcard record);

    /**
     * 根据主键查询记录
     */
    PlatformBankcard selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(PlatformBankcard record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(PlatformBankcard record);
    
    List<PlatformBankcard> getPlatformBankcard();
}