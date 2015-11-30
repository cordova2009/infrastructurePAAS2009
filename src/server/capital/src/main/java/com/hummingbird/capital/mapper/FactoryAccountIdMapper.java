package com.hummingbird.capital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.capital.entity.FactoryAccountId;
import com.hummingbird.capital.entity.FactoryProcess;
import com.hummingbird.capital.entity.Product;

public interface FactoryAccountIdMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String accountId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(FactoryAccountId record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(FactoryAccountId record);

    /**
     * 根据主键查询记录
     */
    FactoryAccountId selectByPrimaryKey(String accountId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(FactoryAccountId record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(FactoryAccountId record);
    
    /**
	 * 创建帐户
	 * @param process
	 * @param product
	 * @param insertlist
	 */
	void createAccounts(@Param("process") FactoryProcess process,@Param("product") Product product,
			@Param("insertlist") List<String> insertlist);

	/**
	 * 获取可用的帐户
	 * @param productId
	 * @return
	 */
	List<FactoryAccountId> selectUseableAccount(String productId);
	
	/**
	 * 获取可用的帐户
	 * @param accountType
	 * @return
	 */
	String selectUseableAccountIdWithProc(java.util.Map map);
	/**
	 * 获取可用的帐户
	 * @param accountType
	 * @return
	 */
	String selectUseableAccountId(String productId);
	/**
	 * 获取可用的帐户
	 * @param accountType
	 * @return
	 */
	String selectUseableAccountIdByAccountType(String accountType);

	/**
	 * 尝试使用帐户
	 * @param factoryAccountId
	 * @return
	 */
	int useThisAccount(FactoryAccountId factoryAccountId);
}