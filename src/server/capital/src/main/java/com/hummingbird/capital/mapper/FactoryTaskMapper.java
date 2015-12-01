package com.hummingbird.capital.mapper;

import java.util.List;

import com.hummingbird.capital.entity.FactoryTask;

public interface FactoryTaskMapper {
    int deleteByPrimaryKey(Integer idt_factory_task);

    int insert(FactoryTask record);

    int insertSelective(FactoryTask record);

    FactoryTask selectByPrimaryKey(Integer idt_factory_task);

    int updateByPrimaryKeySelective(FactoryTask record);

    int updateByPrimaryKey(FactoryTask record);

	/**
	 * 查询待运行的任务
	 * @return
	 */
	List<FactoryTask> selectTask4Gen();
}