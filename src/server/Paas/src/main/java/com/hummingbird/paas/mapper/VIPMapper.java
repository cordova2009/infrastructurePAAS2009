package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.vo.BuyVIPListVOResult;

public interface VIPMapper {
	public List<BuyVIPListVOResult> getBuyVIPListVOResult(String memberType);
}