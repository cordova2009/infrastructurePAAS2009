package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.RequestException;
import com.hummingbird.common.exception.SignatureException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.util.TransOrderBuilder;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.Order;
import com.hummingbird.paas.entity.OrderProduct;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.mapper.OrderMapper;
import com.hummingbird.paas.mapper.OrderProductMapper;
import com.hummingbird.paas.services.OrderService;
import com.hummingbird.paas.services.ProductHandler;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.util.ProductHandlerFactory;
import com.hummingbird.paas.vo.PayNotifyBodyVO;
import com.hummingbird.paas.vo.PayResult;

/**
 * @author
 * @date 2015-12-02
 * @version 1.0 订单的接口实现
 */
@Service
public class OrderServiceImpl implements OrderService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());

	@Autowired
	OrderMapper dao;
	@Autowired
	OrderProductMapper productdao;
	

	/**
	 * 支付宝网关支付通知
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void payNotify(String appId, PayNotifyBodyVO body) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("支付宝网关支付通知开始");
		}
		
		if(body.getErrcode()==0){
			//支付成功
			//根据订单id去查询订单
			Order order = dao.selectByPrimaryKey(body.getOrderId());
			if(order==null){
				throw ValidateException.ERROR_PARAM_NULL.clone(null, "订单号"+body.getOrderId()+"找不到订单");
			}
//			ValidateUtil.assertNull(order, "订单号"+body.getOrderId()+"找不到订单");
			//判断订单状态 
			ValidateUtil.assertNotEqual(order.getPayStatus(),CommonStatusConst.STATUS_CREATE, "订单状态非待支付");
			paySuccess(order);
		}
		else{
			//支付失败
			//根据订单id去查询订单
			Order order = dao.selectByPrimaryKey(body.getOrderId());
			ValidateUtil.assertNull(order, "订单号"+body.getOrderId()+"找不到订单");
			//判断订单状态 
			ValidateUtil.assertNotEqual(order.getPayStatus(),CommonStatusConst.STATUS_CREATE, "订单状态非待支付");
			order.setPayStatus(CommonStatusConst.STATUS_FAIL);
			order.setUpdateTime(new Date());
			dao.updateByPrimaryKey(order);
		}

		if (log.isDebugEnabled()) {
			log.debug("支付宝网关支付通知完成");
		}
	}

	/**
	 * 支付成功
	 * @param order
	 * @throws BusinessException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void paySuccess(Order order) throws BusinessException {
		//查询订单的具体信息
		String productId = order.getProductId();
		//查询产品
		ProductHandler productHandler = ProductHandlerFactory.getProductHandler(productId);
		//ValidateUtil.assertNull(op, "产品[id"+productId+"]找不到");
		productHandler.handle(order);
		order.setPayStatus(CommonStatusConst.STATUS_OK);
		order.setUpdateTime(new Date());
		
		dao.updateByPrimaryKey(order);
	}
	
	/**
	 * 创建订单
	 * @param appId
	 * @param productId
	 * @param userId
	 * @param discount
	 * @return
	 * @throws DataInvalidException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public Order createOrder(String appId,String productId,Integer userId,Integer discount) throws DataInvalidException{
		Order ord = new Order();
		String orderId = AccountGenerationUtil.genNO("RM",8);//订单号
		ord.setInsertTime(new Date());//创建时间
		ord.setProductId( productId);//产品ID
		OrderProduct orderProduct=productdao.selectByPrimaryKey(productId);
		Long amount=null;
		if( orderProduct != null){
			if(CommonStatusConst.STATUS_OFF.equals(orderProduct.getStatus())){
				throw ValidateException.ERROR_PRODUCT_OFFLINE;
			}
			amount=orderProduct.getPrice()*1;
			ord.setProductCount(1);//产品数量
			ord.setProductPrice(orderProduct.getPrice());//产品单价
			ord.setAmount(amount);//总价
			ord.setProductDesc(orderProduct.getProductDescription());//产品描述
		}
		else{
			throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "产品不存在");
		}
		ord.setUpdateTime(new Date());//更新时间
		ord.setCreateBy(String.valueOf(userId));//创建人
		ord.setUserId(userId);//用户id
		ord.setPayType("ALI");//支付类型
		ord.setPayStatus("CRT");//支付状态
		ord.setAppId(appId);//应用id
		ord.setDiscount(discount);//产品折扣
		ord.setRealAmount(amount*100/discount);//折后价格
		ord.setOrderId(orderId);
		dao.insert(ord);
		return ord;
	}
	
	/**
	 * 查询支付结果
	 * @param orderId
	 * @return
	 * @throws BusinessException 
	 */
	public PayResult queryPayResult(String orderId, String payType) throws BusinessException{
		//根据payType 来判断是支付宝还是其它支付平台
		//请求支付宝查询支付结果
		PayResult pr = new PayResult();
		pr.setOrderId(orderId);
		pr.setPayType(payType);
		//默认不存在
		pr.setPayStatus("NON");
		try {
			Map body = new HashMap<>();
			body.put("orderId", orderId);
			BaseTransVO<Map> buildBaseTrans = TransOrderBuilder.buildBaseTrans("paas", "", body, false, false);
			String requestjson = JsonUtil.convert2Json(buildBaseTrans);
			PropertiesUtil pu= new PropertiesUtil();
			String url = pu.getProperty("third.alipay.url");
			String postRequest = new HttpRequester().postRequest(url, requestjson);
			if(postRequest==null){
				throw ValidateException.ERROR_REQUEST_INVALID.clone(null, "查询支付宝订单状态出错,地址无法访问");
			}
			ResultModel rm = JsonUtil.convertJson2Obj(postRequest, ResultModel.class);
			if(rm.isSuccessed()){
				Map result = (Map) rm.get("result");
				pr.setPayStatus(ObjectUtils.toString(result.get("payResult")));
				String paytime = ObjectUtils.toString(result.get("payTime"));
				if(StringUtils.isNotBlank(paytime)){
					pr.setPayTime(DateUtil.parse2date(paytime, "yyyy-MM-dd HH:mm:ss"));
				}
				pr.setTradeId(ObjectUtils.toString(result.get("tradeId")));
			}
			else
				throw new BusinessException(BusinessException.ERRCODE_REQUEST,"查询支付宝订单状态出错,结果错误");
		} catch (DataInvalidException | SignatureException | RequestException | ParseException e) {
			log.error(String.format("查询支付宝订单状态出错,程序错误"),e);
			throw new BusinessException(BusinessException.ERRCODE_REQUEST,"查询支付宝订单状态出错,程序错误",e);
		}
		return pr;
	}

}