package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.vo.MyIncomeOverallReturnVO;
import com.hummingbird.paas.vo.MyPaymentOverallReturnVO;
import com.hummingbird.paas.vo.PaidAmountDetailReturnVO;
import com.hummingbird.paas.vo.QueryMyIncomeListReturnVO;
import com.hummingbird.paas.vo.QueryMyPaymentListReturnVO;
import com.hummingbird.paas.vo.WillPayAmountDetailReturnVO;

public interface ProjectService {
	/**
	 * 查询我的招标项目付款列表
	 * @param BeeId
	 * @return
	 * @throws MaAccountException
	 */
	public List<QueryMyPaymentListReturnVO> queryMyPaymentList(Integer biddeeId)throws MaAccountException;
	
	/**
	 * 查询我的投标项目收款列表
	 * @param BerId
	 * @return
	 * @throws MaAccountException
	 */
	public List<QueryMyIncomeListReturnVO> queryMyIncomeList(Integer bidderId)throws MaAccountException;

	
	/**
	 * 查询我的招标项目付款概况
	 * @param BeeId
	 * @return
	 * @throws MaAccountException
	 */
	public MyPaymentOverallReturnVO getMyPaymentOverall(Integer biddeeId)throws MaAccountException;

	/**
	 * 查询我的中标项目收款概况
	 * @param BerId
	 * @return
	 * @throws MaAccountException
	 */
	public MyIncomeOverallReturnVO getMyIncomeOverall(Integer bidderId)throws MaAccountException;

	
	/**
	 * 查询标的待付款列表
	 * @param objectId
	 * @return
	 * @throws MaAccountException
	 */
	public List<WillPayAmountDetailReturnVO> queryWillPayAmountDetail(String objectId)throws MaAccountException;

	/**
	 * 查询标的待收款列表
	 * @param objectId
	 * @return
	 * @throws MaAccountException
	 */
	public List<WillPayAmountDetailReturnVO> queryWillReceiveAmountDetail(String objectId)throws MaAccountException;

	
	/**
	 * 查询标的已付款信息列表
	 * @param objectId
	 * @return
	 * @throws MaAccountException
	 */
	public List<PaidAmountDetailReturnVO> queryPaidAmountDetail(String objectId)throws MaAccountException;
	
	/**
	 * 查询标的已收款信息列表
	 * @param objectId
	 * @return
	 * @throws MaAccountException
	 */
	public List<PaidAmountDetailReturnVO> queryReceivedAmountDetail(String objectId)throws MaAccountException;
	
}
