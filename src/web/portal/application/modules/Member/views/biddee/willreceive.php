<div class="main">
			<div class="clear">
			<?php
			require_once APP_PATH.'modules/Member/views/common/nav.php';
			?>
				<div class=" auto content">
					<div class="tit4">《<?=$detail['fundName']?>》应收款详情</div>
					<div class="table charge_table  ">
						<table>
							<tbody><tr class="bg2 thead">
								<td class="wid90 ">期/月/次</td>
								<td class="wid90">应收金额</td>
								<td class="wid90">时间段</td>
							</tr>
							<?php foreach($list as $v){ ?>
							<tr>
								<td><?=$v['fundName']?></td>
								<td><?=price_format($v['amount'])?>元</td>
								<td><?=$v['startDate'].'-'.$v['endDate']?></td>
							</tr>
							<?php }?>	
						</tbody></table>
					</div>
						<?php include(APP_PATH.'views/common/page.php'); ?>
				</div>
			</div>
		</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(1),#left-menu .submenu:eq(1) a:eq(2)").addClass('active');
    $(".tblistTbale tr:odd").addClass('bg1');
})
</script>
</block>
