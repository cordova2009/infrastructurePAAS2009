<div class="main">
			<div class="clear">
			<?php
			require_once APP_PATH.'modules/Member/views/common/nav.php';
			?>
				<div class=" auto">
					<div class="box">
						<div class="table text-center">
							<div class="cell">
								信用等级 <span class="tag2 marl20"><?=isset($overall['creditRating'])?$overall['creditRating']:'无';?></span>
							</div>
							<div class="cell">
								信用积分 <span class="fz26 marl20"><?=isset($overall['creditScore'])?$overall['creditScore']:'0';?></span>
							</div>
						</div>
					</div>
					<div class="box mart30 pad0">
						<div class="table3 pad20">
							<table>
								<tbody><tr class="bordb">
									<td class="wid120"></td>
									<td>项目</td>
									<td class="wid90">状态</td>
									<td class="wid60 ">信用分数</td>
								</tr>
								<tr class="bordb">
									<td>基本信息</td>
									<td>个人详细信息，工作信息</td>
									<td><?=isset($datail['personalInfo']['status'])?$datail['personalInfo']['status']:'';?></td>
									<td class="padl20"><?=isset($datail['personalInfo']['creditScore'])?$datail['personalInfo']['creditScore']:0;?>分</td>
								</tr>
								<tr class="bordb">
									<td>企业信息</td>
									<td colspan="2">
										<p class="bordb"><span class="right wid90"><?=isset($datail['myBiddeeInfo']['baseInfo']['status'])?$datail['myBiddeeInfo']['baseInfo']['status']:'未认证';?></span>基本信息</p>
										<p class="bordb"><span class="right wid90"><?=isset($datail['myBiddeeInfo']['legalPersonInfo']['status'])?$datail['myBiddeeInfo']['legalPersonInfo']['status']:'未认证';?></span>法人信息</p>
										<p class="bordb"><span class="right wid90"><?=isset($datail['myBiddeeInfo']['companyRegisteredInfo']['status'])?$datail['myBiddeeInfo']['companyRegisteredInfo']['status']:'未认证';?></span>公司注册信息</p>
										<p><span class="right wid90"><?=isset($datail['myBiddeeInfo']['bankInfo']['status'])?$datail['myBiddeeInfo']['bankInfo']['status']:'未认证';?></span>银行开户信息</p>
									</td>
									<td></td>
								</tr>
								<tr>
									<td>交易记录</td>
									<td colspan="2">
										<p class="bordb"><span class="right wid90"><?=isset($datail['tradeInfo']['biddeeNum']['status'])?$datail['tradeInfo']['biddeeNum']['status']:'0';?>次</span>发布标的次数</p>
										<p><span class="right wid90"><?=isset($datail['tradeInfo']['tradeAmount']['status'])?$datail['tradeInfo']['tradeAmount']['status']:'0';?>元</span>交易金额</p>
									</td>
									<td class="padl20">
										<p><?=isset($datail['tradeInfo']['tradeInfo']['creditScore'])?$datail['tradeInfo']['tradeInfo']['creditScore']:'0';?>分 <i class="ico i-info"></i></p>
										<p><?=isset($datail['tradeInfo']['tradeAmount']['creditScore'])?$datail['tradeInfo']['tradeAmount']['creditScore']:'0';?>分</p>
									</td>
								</tr>
							</tbody></table>
						</div>
						<div class="padm20 ">
							<div class="charge_tips2 mart40">
								<p><i class="ico i-tips"></i> 温馨提示： 为了投标更快一步，建议您立即<a href="<?=U('/member/biddee/applyfor');?>" class="blue">申请招标人认证</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(1),#left-menu .submenu:eq(1) a:eq(0)").addClass('active');
})
</script>
</block>
