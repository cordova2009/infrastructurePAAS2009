<div class="main">
			<div class="clear">
			<?php
			require_once APP_PATH.'modules/Member/views/common/nav.php';
			?>
				<div class=" auto">
					<div class="box">
						<div class="table text-center">
							<div class="cell">
								信用等级
                                <span class="tag2 marl20">
                                    <?=$overall['creditRating']?>
                                </span>
							</div>
							<div class="cell">
								信用积分
                                <span class="fz26 marl20">
                                    <?=$overall['creditScore']?>
                                </span>
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
									<td>
                                        <?=$detail['baseInof']['personalInfo']['status']?>
                                    </td>
									<td class="padl20">
                                        <?=$detail['baseInof']['personalInfo']['creditScore']?>分
                                    </td>
								</tr>
								<tr class="bordb">
									<td>企业信息</td>
									<td colspan="2">
										<p class="bordb">
                                            <span class="right wid90">
                                                <?=$detail['myBiddeeInfo']['baseInfo']['status']?>
                                            </span>
                                            基本信息
                                        </p>
										<p class="bordb">
                                            <span class="right wid90">
                                                <?=$detail['myBiddeeInfo']['legalPersonInfo']['status']?>
                                            </span>
                                            法人信息
                                        </p>
										<p class="bordb">
                                            <span class="right wid90">
                                                <?=$detail['myBiddeeInfo']['companyRegisteredInfo']['status']?>
                                            </span>
                                            公司注册信息
                                        </p>
										<p>
                                            <span class="right wid90">
                                                <?=$detail['myBiddeeInfo']['bankInfo']['status']?>
                                            </span>
                                            银行开户信息
                                        </p>
									</td>
									<td></td>
								</tr>
								<tr>
									<td>交易记录</td>
									<td colspan="2">
										<p class="bordb">
                                            <span class="right wid90">
                                                <?=$detail['tradeInfo']['biddeeNum']['status']?>次
                                            </span>发布标的次数
                                        </p>
										<p>
                                            <span class="right wid90">
                                                <?=price_format($detail['tradeInfo']['tradeAmount']['status'])?>元
                                            </span>交易金额
                                        </p>
									</td>
									<td class="padl20">
										<p>
                                            <?=$detail['tradeInfo']['biddeeNum']['creditScore']?>分
                                        </p>
										<p>
                                            <?=$detail['tradeInfo']['tradeAmount']['creditScore']?>分
                                        </p>
									</td>
								</tr>
							</tbody></table>
						</div>
						<div class="padm20 ">
							<div class="charge_tips2 mart40">
								<p><i class="ico i-tips"></i> 温馨提示： 为了方便招标和吸引优秀的投标人，请你立即<a href="<?=U('/member/biddee/applyfor');?>" class="blue">填写招标人信息</a>入住平台</p>
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
