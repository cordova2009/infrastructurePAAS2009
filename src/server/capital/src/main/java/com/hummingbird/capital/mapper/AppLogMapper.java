package com.hummingbird.capital.mapper;

import com.hummingbird.capital.entity.AppLog;

public interface AppLogMapper {
    int deleteByPrimaryKey(Integer idtAppLog);

    int insert(AppLog record);

    int insertSelective(AppLog record);

    AppLog selectByPrimaryKey(Integer idtAppLog);

    int updateByPrimaryKeySelective(AppLog record);

    int updateByPrimaryKey(AppLog record);
}