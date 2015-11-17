package com.hummingbird.paas.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hummingbird.test.service.BaseTestService;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO

/**
 * @author 
 * @date 2015-11-15
 * @version 1.0
 *  service接口单元测试实现
 */
@Service
public class BidServiceImplTest  extends BaseTestService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	
	@Autowired
	BidService service;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

		/**
	 * 提交撮合投标保证金信息接口
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public void testsaveMakeMatchBidderBond() throws BusinessException{
		if(log.isDebugEnabled()){
				log.debug("提交撮合投标保证金信息接口单元测试开始");
			}
				//先执行参数，然后检查
		    String appId="fengniaotest";
		    SaveMakeMatchBidderBondBodyVO body = new SaveMakeMatchBidderBondBodyVO(); //请添加参数
			service.saveMakeMatchBidderBond(appId, body);
			assertEquals(【目标值】, 【实际值】);
			List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(""); //查询数据库
			//比较数据库值是否符合预期
			assertEquals(【目标值】, 【实际值】);
				
		if(log.isDebugEnabled()){
				log.debug("提交撮合投标保证金信息接口单元测试完成");
		}
	}
	
		
		
}