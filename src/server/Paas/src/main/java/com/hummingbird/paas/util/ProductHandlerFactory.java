/**
 * 
 * ProductHandlerFactory.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.util;

import org.apache.commons.lang.StringUtils;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.SpringBeanUtil;
import com.hummingbird.paas.entity.ProductCategory;
import com.hummingbird.paas.mapper.ProductCategoryMapper;
import com.hummingbird.paas.services.ProductHandler;
import com.hummingbird.paas.services.impl.BiddeeMemberProductHandler;
import com.hummingbird.paas.services.impl.BidderMemberProductHandler;

/**
 * @author john huang
 * 2015年12月2日 下午5:37:26
 * 本类主要做为产品 处理器的获取工厂,主要是根据产品id获取对应的处理器
 */
public class ProductHandlerFactory {

	static String BIDDEE_MEMBER = "BIDDEE_MEMBER";
	static String BIDDER_MEMBER = "BIDDER_MEMBER";
	
	static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(ProductHandlerFactory.class);
	
	/**
	 * 获取对应的产品 处理器
	 * @param productId
	 * @return
	 */
	public static ProductHandler getProductHandler(String productId) throws BusinessException{
		if (log.isDebugEnabled()) {
			log.debug(String.format("从产品id[%s]中获取对应的产品 处理器",productId));
		}
		//加载产品目录
		ProductCategoryMapper cateDao = SpringBeanUtil.getInstance().getBean(ProductCategoryMapper.class);
		ProductCategory pc = cateDao.selectCategoryByProductId(productId);
		if(pc==null){
			throw ValidateException.ERROR_SYSTEM_INTERNAL.clone(null, "无法找到合适的产品处理器");
		}
		else{
			if(StringUtils.equals(pc.getName(),BIDDEE_MEMBER)){
				return (ProductHandler) SpringBeanUtil.getInstance().getBean("biddeeMemberProductHandler");
			}
			else if(StringUtils.equals(pc.getName(),BIDDER_MEMBER)){
				return (ProductHandler) SpringBeanUtil.getInstance().getBean("bidderMemberProductHandler");
			}
		}
		throw ValidateException.ERROR_SYSTEM_INTERNAL.clone(null, "无法找到合适的产品处理器");
	}
	
	
}
