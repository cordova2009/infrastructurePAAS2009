<div class="main">
			<div class="clear">
			<?php
			require_once APP_PATH.'modules/Member/views/common/nav.php';
			?>
			<div class=" auto ">
					<div class="content">
						<div class="xm_info">
							<div class="table">
								<div class="cell">
									<div class="txt1  "><?=$doneNum?>	<span class="fz16">个</span></div>
									<div class="txt2">已结束的工程</div>
								</div>
								<div class="cell">
									<div class="txt1"><?=$bidingNum?> <span class="fz16">个</span></div>
									<div class="txt2 color8">在招标的工程</div>
								</div>
								<div class="cell">
									<div class="txt1"><span class="orange"><?=$doingNum?> </span><span class="fz16">个</span></div>
									<div class="txt2 color8">实施中的工程</div>
								</div>
							</div>
							
						</div>
					</div>
					<div class="content mart20">
						<div class="box pad0">
							<div class="tab_box2">
								<div class="hd tab_tit ul3 clear">
									<ul>
										<li class="" data-type="biding" data-index="<?=isset($bidingi)?$bidingi:0?>">招标中的项目</li>
										<li class="" data-type="doing" data-index="<?=isset($doingi)?$doingi:0?>">实施中的项目</li>
										<li class="on" data-type="done" data-index="<?=isset($donei)?$donei:0?>">已结束的项目</li>
									</ul>
								</div>
								<div class="bd">
									<!--投标中-->
									<div class="tblist" style="display: none;">
										<div class="table tblistTbale" id="biding"  ></div>
									</div>
									<!--实施中-->
									<div class="tblist" style="display: none;" >
										<div class="table tblistTbale" id="doing"></div>
									</div>
									<!--已结束-->
									<div class="tblist" style="display: block;" >
										<div class="table tblistTbale" id="done"></div>
									</div>
								</div>
							</div>		
						</div>
					</div>				
				</div>
			</div>
		</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(1),#left-menu .submenu:eq(1) a:eq(1)").addClass('active');
    $(".tblistTbale tr:odd").addClass('bg1');
function loadings()
{
   var type =$(this).data('type');
   var index =$(this).data('index');
   $(this).parent().find('li').removeClass('on');
   $(this).addClass('on');
$(".bd .tblist").hide().eq($(this).index()).show()
    var wrap = $("#"+type);
    if(wrap.html() !=''){
        wrap.parent().show();
	return ;
    }

//    var data = <?=json_encode(['type'=>$type,'pageIndex'=>$pageIndex])?>;
    var data = {'type':type,'pageIndex':index};
    var loading = layer.load();
    //开始加载下一个页面
    $.post('<?=U('getProbject')?>', data, function (rs) {
        wrap.append(rs.html);
    }, 'json').always(function () {
        layer.close(loading);
    });
}
//loadings() ;
$('.tab_box2 li').click(loadings);
$('.tab_box2 li.on').trigger("click");
})
</script>
</block>
