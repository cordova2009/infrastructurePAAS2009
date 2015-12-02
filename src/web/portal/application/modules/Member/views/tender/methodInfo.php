<?php
if(check_resp($resp)){
    $info = $resp['objectMethodInfo'];
}
?>
<div class="auto box pad0" id="methodInfo">
    <div class="h2">招标方式</div>
    <div class="padm40">
        <form action="<?=U('/member/tender/saveMethodInfo')?>" method="post" class="ajax-form" success="save_success" next_step="bidFileTypeInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class=" pbfs padt20">

            <div class="item ">
                <div class="lab"><span class="red">*</span>投标方式</div>
                <div class="value">
                    <div class="checkBtn2">
                        <a href="javascript:;" class="wid150 active">
                            公开招标
                            <input name="objectMethod" type="radio" class="hide" value="PUB" checked>
                        </a>
                        <a href="javascript:;"  class="wid150 marl50">
                            邀请招标
                            <input id="yao-qing" name="objectMethod" type="radio" class="hide" value="INV">
                        </a>
                        <i class="ico tip-qus"></i>
                    </div>
                </div>
            </div>
        </div>

        <div class="hide" id="yaoqing-wrap">
            <div class="clear padv40 mart60 tit9">
                <div class="left ">
                    <span class="red marr10">*</span> 邀请投标方
                </div>
                <div class="right">
                    <a href="#" class="btn">添加</a>
                    <a href="#" class="btn-grey2 marl10">删除</a>
                </div>
            </div>

            <div class="table charge_table">
                <table>
                    <tr class="bg2 thead">
                        <td class="wid70 "></td>
                        <td>公司名称</td>
                        <td class="wid150">用户名</td>
                    </tr>
                    <tr>
                        <td class="checklist"><i class="ico i-check"></i></td>
                        <td class="">xxxxx公司</td>
                        <td class="">李白白</td>
                    </tr>
                    <tr class="bg1">
                        <td class="checklist"><i class="ico i-check"></i></td>
                        <td class="">xxxxx公司</td>
                        <td class="">李白白</td>
                    </tr>
                </table>
            </div>

            <div class="text-center padv20">
                <a href="#" class="btn">确  定</a>
            </div>
        </div>
        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>
<script>
$(function(){
    $(".checkBtn2 a").click(function(){

        if($(this).children('input').val() == 'INV'){
            $("#yaoqing-wrap").show();
        }else{
            $("#yaoqing-wrap").hide();
        }
    });

    <?php if(isset($info) && !empty($info['objectMethod'])):?>
    $("input[name='objectMethod']").each(function(){

        if(this.value == '<?=$info['objectMethod']?>'){
            this.checked = true;
            return false;
        }
    })
    <?php endif;?>
})
</script>