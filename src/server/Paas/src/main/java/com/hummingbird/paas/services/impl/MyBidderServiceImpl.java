package com.hummingbird.paas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.paas.mapper.BidderCerticateMapper;

import com.hummingbird.paas.services.MyBidderService;
@Service
public class MyBidderServiceImpl implements MyBidderService {
	
	@Autowired
	private BidderCerticateMapper bidderCerticateDao;
		  
	}


