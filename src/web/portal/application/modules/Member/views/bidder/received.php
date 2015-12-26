<div class="main">
			<div class="clear">
			<?php
			require_once APP_PATH.'modules/Member/views/common/nav.php';
			?>
				<div class=" auto content">
					<div class="tit4">《<?=$projectName?>》已收款详情</div>
					<div class="table charge_table  ">
						<table>
							<tbody><tr class="bg2 thead">
								<td class="wid90 ">期/月/次</td>
								<td class="wid90">收款金额</td>
								<td class="wid90">转账时间</td>
								<td class="wid90">转账银行名称</td>
								<td class="wid90 lineh20">银行转账凭证<br>编号</td>
							</tr>
							<?php foreach($list as $v){ ?>
							<tr>
								<td><?=$v['fundName']?></td>
								<td><?=$v['amount']?>元</td>
								<td><?=$v['transferDate']?></td>
								<td><?=$v['bankName']?></td>
								<td><?=$v['voucherNo']?></td>
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
    $("#left-menu .submenu:eq(2),#left-menu .submenu:eq(2) a:eq(2)").addClass('active');
    $(".tblistTbale tr:odd").addClass('bg1');
})
</script>
</block>
