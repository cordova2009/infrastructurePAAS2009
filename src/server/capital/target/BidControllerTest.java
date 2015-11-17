package com.hummingbird.paas.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;



import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.service.IAuthenticationService;
import com.hummingbird.commonbiz.vo.BaseTransVO;

import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.MediaType;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.web.WebAppConfiguration;  
import org.springframework.test.web.servlet.MockMvc;  
import org.springframework.test.web.servlet.ResultHandler;  
import org.springframework.test.web.servlet.ResultMatcher;  
import org.springframework.ui.Model;  
import org.springframework.test.context.transaction.TransactionConfiguration;  
import org.springframework.transaction.annotation.Transactional;  
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.context.WebApplicationContext; 

import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;

/**
 * @author 
 * @date 2015-11-15
 * @version 1.0
 *  
 */
 
@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration  
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:dataSource.xml","spring-servlet.xml" })  
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否  
@TransactionConfiguration(defaultRollback = true)  
//记得要在XML文件中声明事务哦~~~我是采用注解的方式  
@Transactional  
public class BidControllerTest extends BaseController {

	@Autowired(required = true)
	protected BidService bidService;
	
	@Autowired  
    private WebApplicationContext wac;  
  
    private MockMvc mockMvc;  
  
    @Before  
    public void setup() {  
        // webAppContextSetup 注意上面的static import  
        // webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS  
        // WebApplicationContext context =  
        // ContextLoader.getCurrentWebApplicationContext();  
        // 如果控制器包含如上方法 则会报空指针  
        this.mockMvc = webAppContextSetup(this.wac).build();  
    }  

		
	/**
	 * 提交撮合投标保证金信息接口 测试
	 * @return
	 */
	 @Test  
    @Rollback(true)  //有些单元测试你不希望回滚  
	public void testsaveMakeMatchBidderBond() {
	
		String testjsoncontent = "    {        \"app\":{            \"appId\":\"zjhtwallet\",            \"timeStamp\":\"TIMESTAMP\",             \"nonce\":\"NONCE\",            \"signature\":\"SIGNATURE\"        },                \"body\":        {       \"token\":\"12345\",            \"bidId\":1,            \"objectId\":\"BH2015082135656\",            \"makeMatchBidderBondAmount\":300000        }    } ";
		String url = "http://127.0.0.1/if"+"/bid/saveMakeMatchBidderBond";
		
		
		mockMvc.perform((post(url))).andExpect(status().isOk())  
                .andDo(print())  ;
                //.andExpect(model().attributeHasNoErrors("teacher"));  
		
		String resultstr = new HttpRequester().postRequest(url, testjsoncontent);
		assertNotNull(resultstr);
		
		ResultModel rm = JsonUtil.convertJson2Obj(jsonstr, ResultModel.class);
		assertTrue(rm.isSuccessed());
		//assertEquals(【目标值】, 【实际值】);
	}
	
	
    }
