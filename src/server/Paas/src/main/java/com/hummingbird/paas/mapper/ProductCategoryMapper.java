package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProductCategory;

public interface ProductCategoryMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProductCategory record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProductCategory record);

    /**
     * 根据主键查询记录
     */
    ProductCategory selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProductCategory record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProductCategory record);

	/**
	 * 查询某个产品的产品目录
	 * @param productId
	 * @return
	 */
	ProductCategory selectCategoryByProductId(String productId);
}