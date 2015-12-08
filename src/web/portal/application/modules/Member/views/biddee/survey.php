<div class=" main">
			<!--标的信息-->
			<div class="biaodi_info">
				<div class="tit3">标的信息</div>
				<div class="clear padt10">
					<div class="left txtcont">
						<div class="txt1"><?=$survery['objectName']?></div>
						<div class="txt2">已有 <span class="orange fz64"><?=$survery['bidderNum']?></span>家公司参与投标</div>
					</div>
					<div class="left txtcont">
						<div class="txt3">最高投标价格 <span class="padl30"><?=price_format($survery['maxBidAmount'])?>元</span></div>
						<div class="txt3">最低投标价格 <span class="padl30"><?=price_format($survery['minBidAmount'])?>元</span></div>
					</div>
					<span class="right">
						<img src="/images/pingbiao.png" alt="">
					</span>
				</div>
			</div>

			<div class="box pad0 mart20" id="bidderid">
				<div class="tit3"><a href="javascript:;" class="right btn-orange " data-toggle="modal" data-target="#xzzb">选择中标人</a>投标人列表</div>
				<div class="table   mart20">
					<table>
						<tbody><tr class="bg2 thead">
							<td class="wid160 padl20 text-left">投标公司  </td>
							<td class="wid110 text-right">投标金额 </td>
							<td class="wid150 padm10">资质</td>
							<td class="wid100">开工日期</td>
							<td class="wid100">工期</td>
							<td class="wid100">投标时间</td>
							<td class="wid100">投标文件 </td>
							<td>查看 </td>
						</tr>
						<?php foreach($list as $v){?>
						<tr>
							<td class="padl20 text-left"><?=$v['bidderCompanyName']?></td>
							<td class="text-right"><span><?=price_format($v['bidAmount'])?></span>元</td>
							<td class="blue"><i class="ico i-ok4"></i><br><?=$v['certificationList'][0]['certificationName']?></td>
							<td><?=$v['projectExpectStartDate']?></td>
							<td><?=$v['projectExpectPeriod']?>天</td>
							<td><?=$v['bidTime']?></td>
							<td><a href="<?=$v['fileUrl']?>" class="blue">下载</a></td>
							<td><a href="<?=U('show')?>" ><i class="ico i-eye3"></i></a></td>
						</tr>
						<?php }?>
					</tbody></table>
				</div>
				<?php include(APP_PATH.'views/common/page.php'); ?>
			</div>
			<div class="box_tips hide">
				<i class="ico i-tips"></i> 您已选择了<span class="blue" id="names"></span>为中标人，请选择付款方式~
				</div>

			<div class="box pad0 mart30">
				<div class="tit3">付款方式</div>
				<div class="pad20">
					<div class="tab_box2">
						<div class="hd tab2_tit clear">
							<ul>
								<li class="on" data-type="PID">分期付款</li>
								<li data-type="MON">按月付款</li>
								<li data-type="ONE">一次性付清</li>
								<li data-type="CUM">自定义付款</li>
							</ul>
						</div>
						<form action="" method="post" class="ajax-form" >
						<div class="bd pay_form ">
							<div class="pay_way">
									<ul class="clear">
										<li>
											<div class="cell">
												<span class="left lab">首款</span>
												<input type="text" name="paySum_pid[1]" class="input1 left">
												<span class="left">元</span>
											</div>
											<div class="cell">
												<span class="left lab">付款时间</span>
												<input type="text" name="payDate_pid[1]" class="input1 left datepicker">
<input type="hidden" name="period_pid[1]" value="1">
											</div>
										</li>
									</ul>
									<div class="box_add">
										<a href="javascript:;" class="btnAdd" data-num="1" data-show="1">添加期数 <i class="ico i-add"  ></i></a>
									</div>
									<div class="box_totle">
										共 <span class="fz36 qi">1</span> 期             <span class="blue fz36 marl100 rmb">0</span>元
									</div>
							</div>
							<!--按月-->
							<div class="pay_way " style="display: none;">
									<ul class="clear">
										<li>
											<div class="cell">
												<span class="left lab">第一个月</span>
												<input type="text" class="input1 left" name="paySum_mon[1]">
												<span class="left">元</span>
											</div>
											<div class="cell">
												<span class="left lab">付款时间</span>
												<input type="text" class="input1 left datepicker" name="payDate_mon[1]">
<input type="hidden" name="period_mon[1]" value="1">
											</div>
										</li>
									</ul>
									<div class="box_add">
										<a href="javascript:;" class="btnAdd" data-num="1" data-show="1" data-type="mon" >添加期数 <i class="ico i-add" ></i></a>
									</div>
									<div class="box_totle">
										共 <span class="fz36 yue">1</span> 月             <span class="blue fz36 rmb marl100">0</span>元
									</div>

							</div>
							<!--一次性付清-->
							<div class="pay_way " style="display: none;">
									<div class="txt1 text-center">付款总金额<span class="fz36 blue rmb">0</span>元</div>
									<div class="text-center padt20">
										<span class=" lab">付款时间</span>
										<input type="text" class="input1  datepicker" name="payDate_one">
									</div>
							</div>
							<!--自定义付款-->
							<div class="pay_way " style="display: none;">
									<ul class="clear">
										<li>
											<div class="cell">
												<span class="left "><input type="text" placeholder="首款/第一期" class="input1 wid90"></span>
												<input type="text" class="input1 left wid180" name="paySum_cum[1]">
<input type="hidden" name="period_cum[1]" value="1">
												<span class="left">元</span>
											</div>
											<div class="cell">
												<span class="left lab">付款时间</span>
												<input type="text" class="input1 left datepicker" name="payDate_cum[1]">
											</div>
										</li>
									</ul>
									<div class="box_add">
										<a href="javascript:;" class="btnAdd" data-num="1" data-show="1" data-type="cum">添加期数 <i class="ico i-add" ></i></a>
									</div>
									<div class="box_totle">
										共 <span class="fz36 qi">1</span> 期             <span class="blue fz36 rmb marl100">0</span>元
									</div>

							</div>
						</div>
							<div class="text-center " style="margin-top:8px;">
							<input type="hidden" name="winBidId" id="winBidId" value="">
							<input type="hidden" name="objectId" id="objectId" value="<?=$surver['objectName']?>">
							<input type="hidden" value="" name="paySum_one" id="paySum">
							<input type="hidden" value="" name="payPeriod_cum" id="payPeriod_3">
							<input type="hidden" value="" name="payPeriod_pid" id="payPeriod_1">
							<input type="hidden" value="" name="payPeriod_mon" id="payPeriod_2">
							<input type="hidden" value="" name="payType" id="payType">
							<input type="submit" value="提&nbsp;&nbsp;交" class="btn-green">
							</div>
					</div>
				</div>
			</div>


			<!--list-->

		</div>
<div class="modal xzzb" id="xzzb" style="display: none;">
		<div class="modal-cont">
			<div class="txt1">请选择中标人</div>
			<div class="table">
				<table>
					<tbody><tr class="bg2 thead">
						<td class="wid160 padl20 text-left">投标公司  </td>
						<td class="wid140 text-right">投标金额 </td>
						<td class="wid120">竣工日期</td>
						<td>中标 </td>
					</tr>
					<?php foreach($list as $v){?>
					<tr class="">
						<td class="padl20 text-left"><?=$v['bidderCompanyName']?></td>
						<td class="text-right"><span><?=price_format($v['bidAmount'])?></span>元</td>
						<td><?=$v['projectExpectStartDate']?></td>
						<td><a href="javascript:;"><i class="ico i-ok5" data-id="<?=$v['bidId']?>"></i></a></td>
					</tr>
					<?php } ?>	
				</tbody></table>
				<div class="text-center padv30">
					<a href="javascript:;" class="btn-green" data-miss="modal" id="ok">确定</a>
					<a href="javascript:;" class="btn-green" data-miss="modal" style=" margin-left: 6px; ">取消</a>
				</div>
			</div>
		</div>
	</div>
<div class="temp-li0 hide">
		<ul>
			<li>
				<div class="cell">
					<span class="left lab"><span class="num">三</span>期</span>
					<input type="text" class="input1 left" id="paySum_pid">
					<span class="left">元</span>
				</div>
				<div class="cell">
					<span class="left lab">付款时间</span>
					<input type="text" class="input1 left datepicker" id="payDate_pid"> 
					<input type="hidden" id="period_pid" value="">
				</div>
			</li>
		</ul>
	</div>
<div class="temp-li1 hide">
		<ul>
			<li>
				<div class="cell">
					<span class="left lab">第<span class="num">三</span>个月</span>
					<input type="text" class="input1 left" id="paySum_mon">
					<span class="left">元</span>
				</div>
				<div class="cell">
					<span class="left lab">付款时间</span>
					<input type="text" class="input1 left datepicker" id="payDate_mon">
					<input type="hidden" id="period_mon" value="">
				</div>
			</li>
		</ul>
	</div>
<div class="temp-li3 hide">
		<ul>
			<li>
				<div class="cell">
					<span class="left "><input type="text" placeholder="首款/第一期" class="input1 wid90"></span>
					<input type="text" class="input1 left wid180" id="paySum_cum">
					<span class="left">元</span>
				</div>
				<div class="cell">
					<span class="left lab">付款时间</span>
					<input type="text" class="input1 left datepicker" id="payDate_cum">
					<input type="hidden" id="period_cum" value="">
				</div>
			</li>
		</ul>
	</div>
<block name="script">
<script src="/js/jquery.datetimepicker.js"></script>
<link href="/css/jquery.datetimepicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(function(){
		$(".tab_box2").slide({mainCell:".bd ",effect:"fade",trigger:"click"});
		$('.i-ok5').click(function(event) {
			$(".i-ok5").removeClass('on');
			$(this).addClass('on');
			$('#winBidId').val($(this).data('id'));
			var tmp = $(this).parent().parent(). siblings().eq(0).html()
			$('#names').html(tmp);
			var tmp = $(this).parent().parent(). siblings().eq(1).find('span').eq(0).html()
			$('.rmb').html(tmp);
			$('#paySum').val(tmp);
		});
		$("#ok").click(function (){
			if($(".i-ok5.on").length==0)
			{
			return;
			}
			$(".box_tips").show();
			$("#bidderid").hide();
			});
$(".tab2_tit").find('li').click(function (){
$("#payType").val($(this).data('type'));
})
		$(".btnAdd").click(function() {
			var i = $(this).attr("data-show")
			i++;
			 switch(i){
			 	case 2:
			 	num = "二";
			 	break;
			 	case 3:
			 	num = "三";
			 	break;
			 	case 4:
			 	num = "四";
			 	break;
			 	case 5:
			 	num = "五";
			 	break;
			 	case 6:
			 	num = "六";
			 	break;
			 }
			$(this).attr("data-num",num)
			$(this).attr("data-show",i)
			var ind = $(this).parents(".pay_way").index();
			$(".temp-li"+ind).find(".num").html(num)
			$(".temp-li"+ind).find('input').each(function (index,e){
				e.name= e.id+'['+i+']';
			});
			var html = $(".temp-li"+ind).find("ul").html();
			$("#payPeriod_"+ind).val(i);
			$(this).parents(".pay_way").find('ul').append(html);
			$(this).parents(".pay_way").find('span.qi').html(i);
		});
	})
</script>
</block>
