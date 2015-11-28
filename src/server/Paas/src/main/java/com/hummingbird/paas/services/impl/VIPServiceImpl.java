package com.hummingbird.paas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.paas.mapper.VIPMapper;
import com.hummingbird.paas.services.VIPService;
import com.hummingbird.paas.vo.BuyVIPListVOResult;

@Service
public class VIPServiceImpl implements VIPService {
	@Autowired
	VIPMapper vipDao;
	@Override
	public List<BuyVIPListVOResult> getBuyVIPListVOResult(String memberType) {
		// TODO Auto-generated method stub
		List<BuyVIPListVOResult> results=vipDao.getBuyVIPListVOResult(memberType);
		return results;
	}
}
