											<table>
												<tbody><tr class="bg2 thead">
													<td class="wid90">工程类别</td>
													<td class="wid170">项目名称</td>
													<td class="wid120">投标金额</td>
													<td class="wid100">开标日期</td>
												</tr>
<?php  if(!empty($biding)){ foreach($biding as $v){?>
												<tr class="">
													<td class=""><span class="tag"><?=$v['industryId']?></span></td>
													<td class="blue  "><a class="blue" href="<?=U('/project/detail',['objectId'=>$v['objectId']])?>"><?=$v['objectName']?><br>(<?=$v['objectId']?>)</a></td>
													<td class=""><?=price_format($v['bidAmount'])?>元</td>
													<td class=""><?=$v['bidOpenDate']?>天</td>
												</tr>
<?php }}else{?>
<tr><td colspan="4">暂无数据</td></tr>
<?php }?>
											</tbody></table>
        <?php include(APP_PATH.'views/common/page.php'); ?>
