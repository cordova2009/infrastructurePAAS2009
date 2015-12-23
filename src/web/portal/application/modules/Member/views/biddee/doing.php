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
			<td class="">
                <a href="javascript:;" class="blue" data-toggle="modal" data-target="#modalJubao">投诉</a>
               <!-- <a href="" class="blue">投诉</a></td>-->
			</tr>
			<?php }
}else{?>
	<tr><td colspan="8">暂无数据</td></tr>
		<?php }?>
		</tbody></table>
		<?php include(APP_PATH.'views/common/page.php'); ?>
<div class="modal modalJubao hide" id="modalJubao" >

    <div class="modal-body">
        <form action="<?=U('/project/index')?>" method="post" class="ajax-form" success="save_success" next_step="projectInfo">
            <div class="modal-header fz18	"><i class="ico_info marr5"></i> 投诉</div>
            <div class="modal-cont">
                <div class="cont1 ">
                    <div class="txt1">您为什么要投诉<span class="blue">某某某（2031245）</span>？</div>
                    <div class="modalJubao_list">
                        <a href="javascript:;"><i></i>
                            虚假投标人
                            <input name="refType" type="radio" class="hide" value="UBR" checked>
                        </a>
                        <a href="javascript:;"><i></i>
                            <input name="refType" type="radio" class="hide" value="DSS" checked>
                            施工速度慢
                        </a>
                        <a href="javascript:;"><i></i>
                            <input name="refType" type="radio" class="hide" value="UBD" checked>
                            虚假投标材料
                        </a>
                    </div>
                </div>
                <div class="cont1 hide">
                    <div class="txt1">您还可以详细描述被投诉人的恶意行为（选填）</div>
                    <textarea  class="textarea3" name="complainContent"></textarea>
                    <div class="btns text-right">
                        <a href="javascript:;" class="btn3 prev">上一步</a>
                        <input type="submit" value="提交" class="btn3" data-miss="modal">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<block name="script">
    <script type="text/javascript">
        $(".modalJubao_list a").click(function(event) {
            $(this).children('input[type=radio]').prop('checked',true);
            $(this).parents(".modalJubao").find(".cont1").addClass('hide');
            $(this).parents(".modalJubao").find(".cont1").eq(1).removeClass('hide')
        });
        $(".modalJubao .prev").click(function(event) {
            $(this).parents(".modalJubao").find(".cont1").addClass('hide');
            $(this).parents(".modalJubao").find(".cont1").eq(0).removeClass('hide')
        });
    </script>
</block>
