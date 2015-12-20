<table>
<tbody><tr class="bg2 thead">
<td class=" wid170">项目名称</td>
<td class="wid100">中标金额</td>
<td class="wid100">中标人</td>
<td class="wid90">已付款</td>
<td class="wid90">应付款</td>
<td class="wid90">计划开工时间</td>
<td class="wid90">工期</td>
<td class="">操作</td>
</tr>
<?php if(!empty($doing)){
	foreach($doing as $v){?>
		<tr class="">
			<td class=""><a class="blue" href="<?=U('/project/detail',['objectId'=>$v['objectId']])?>"><?=$v['objectName']?><br>(<?=$v['objectId']?>)</a></td>
			<td class=""><?=price_format($v['winBidAmount'])?>元</td>
			<td class=""><?=$v['winBidder']?></td>
			<td class=""><?=price_format($v['receivedAmount'])?></td>
			<td class=""><?=price_format($v['willReceiveAmount'])?></td>
			<td class=""><?=$v['projectExpectStartDate']?></td>
			<td class=""><?=$v['projectExpectPeriod']?>天</td>
			<td class=""><a href="" class="blue">投诉</a></td>
			</tr>
			<?php }
}else{?>
	<tr><td colspan="8">暂无数据</td></tr>
		<?php }?>
		</tbody></table>
		<?php include(APP_PATH.'views/common/page.php'); ?>
