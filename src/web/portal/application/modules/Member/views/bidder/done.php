											<table>
												<tbody><tr class="bg2 thead">
													<td class="wid100">工程类别</td>
													<td class="wid210">项目名称</td>
													<td class="wid160">中标价格</td>
													<td class="wid160">中标公司</td>
													<td class="">操作</td>
												</tr>
<?php if (!empty($done)){ foreach($done as $v){?>
												<tr class="">
													<td class=""><span class="tag"><?=$v['industryId']?></span></td>
													<td class="blue  "><?=$v['objectName']?><br>(<?=$v['objectId']?>)</td>
													<td class=""><?=price_format($v['winBidAmount'])?>元</td>
													<td class=""><?=$v['winBidder']?></td>
													<td class=""><a href="#" class="btn-blue">评价</a></td>
												</tr>
<?php }}else{?>
<tr><td colspan="5">暂无数据</td></tr>
<?php }?>
											</tbody></table>
        <?php include(APP_PATH.'views/common/page.php'); ?>
