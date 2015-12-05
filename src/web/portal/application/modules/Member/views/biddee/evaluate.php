<div class=" main">
			<!--company-->
			<div class="box xm_pro">
				<div class="txt1"><?=$evaluate['objectName']?></div>
				<div class="clear txt2">
					<span class="left"><img src="/images/dot1.png" alt=""></span>
					<div class="auto">
						<p>本次工程已圆满结束！<br>
							请留下您对承包公司的宝贵建议和评分！
						</p>
					</div>
				</div>
			</div>

			<div class="box zbgs mart30">
				<div class="clear">
					<span class="left leftImg"><img src="<?=$evaluate['logo']?>" height="69" width="69" alt=""></span>
					<span class="blue left name "> <?=$evaluate['bidderCompanyName']?></span>
					<div class="left wid300 lineh25 padt10">
						<span class="color6">标的金额</span><span class="padl20"> <?=$evaluate['winBidAmount']?></span><br>
						<span class="color6">中标时间</span><span class="padl20"><?=$evaluate['winBidTime']?></span>
					</div>
					<div class="left wid300 lineh25 padt10">
						<span class="color6">开工时间</span><span class="padl20"><?=$evaluate['startTime']?></span><br>
						<span class="color6">结束时间</span><span class="padl20"><?=$evaluate['endTime']?></span>
					</div>
				</div>
			</div>

			<form action="" method="post" id="form" class=" ajax-form" before="before_sub" success="after_sub">
			<div class="box mart30 pad0">
				<div class="tab_tit2 clear">
					<span>累计评价 <?=$evaluate['companyEvaluateNum']?></span>
				</div>
				<div class="bordb clear impress">
					<div class="left padr30">大家印象</div>
					<div class="auto ">
<div class="tags">
					<?php foreach($evaluate['tag'] as $v){
						echo '<a><as>'.$v['tagName'].'</as>（<span>'.$v['tagNum'].'</span>）</a>';
					} ?>
</div>
						<div class="addimpress">
							<input type="text" class="input1 wid190" name="tagNmae" > <input type="button" value="添加印象" class="btn-add marl10" id="tag">
						</div>
					</div>
				</div>

				<div class="pingfen">
					<p class="txt1">您对本次与<?=$evaluate['bidderCompanyName']?>的合作的评价</p>
					<div class="clear padt30">
						<div class="left wid300 padt20" id="evalstar">
						评分 
						<i class="ico i-star i-star2"></i>
						<i class="ico i-star i-star2"></i> 
						<i class="ico i-star i-star2" ></i> 
						<i class="ico i-star i-star2"></i> 
						<i class="ico i-star i-star2"></i>
						</div>
						<div class="left txt3Cont">
							<textarea name="evaluateContent" id="" class="textarea"></textarea>
							<input name="objectId" value="<?=$evaluate['objectId']?>" type="hidden">
							<input name="evaluateScore" value="0" type="hidden" id="evaluateScore">
							<div class="text-right padt10"><input type="submit" value="发表评价" class="btn-add"></div>
						</div>
					</div>
				</div>
				</form>


			</div>

			<!--list-->

		</div>
<block name="script">
<script type="text/javascript">
function before_sub(){
var i  = $("#evalstar i.i-star2").length ;
$("#evaluateScore").val(5-i);
$('.tags a as').each(function (i,e){
$('#form').append('<input type="hidden" name="tags[]" value="'+e.innerText+'">');
});
}

function after_sub()
{
$('#form input[type=hidden]').remove();
}
$(".tags a").click(taged);
function taged(o){
var obj = $(this).find('span');
var i = obj.html()
if($(this).hasClass('taged'))
{
i= parseInt(i)-1;
$(this).removeClass('taged');
}else{
i= parseInt(i)+1;
$(this).addClass('taged');
}
obj.html(i)
}

$("#tag").click(function (){
tag = $(this).prev().val();
 $(this).prev().val('');
var tmp = $('<a class="taged" ><as>'+tag+'</as>（<span>'+1+'）</span></a>').click(taged);
$('.tags').append(tmp);
});

$('#evalstar').click(function (e){
var size = $(event.target).index()
$('#evalstar').find('i').each(function (i,e){
if(i<=size){
$(e).removeClass('i-star2');
}else{
$(e).addClass('i-star2');
}
});
});

</script>
</block>
