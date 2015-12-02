package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.paas.vo.BuyVIPListVOResult;

/*
 * 会员业务模型
 * @author HUANGXIHUA
 *
 */
public interface VIPService {

	List<BuyVIPListVOResult> getBuyVIPListVOResult(String memberType);
}