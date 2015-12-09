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
                <div class="clear padt40 mart60 tit9">
                    <div class="left ">
                        <span class="red marr10">*</span> 邀请投标方
                    </div>
                    <div class="right">
                        <a href="javascript:" class="btn" id="add-bidder">添加</a>
                        <a href="javascript:" class="btn-grey marl10" id="del-bidder">删除</a>
                    </div>
                </div>
                <p class="color5 marb40">（补充添加和删除说明............................ ）</p>
                <div class="table charge_table">
                    <table>
                        <tr class="bg2 thead">
                            <td class="wid70 "></td>
                            <td>公司名称</td>
                            <td class="wid150">用户名</td>
                        </tr>
                        <tbody id="bidder-body">
                            <?php
                            if(isset($info['inviteTender']) && is_array($info['inviteTender']))
                                foreach($info['inviteTender'] as $item):
                            ?>
                            <tr data="<?=$item['bidderId']?>">
                                <td class="checklist"><i class="ico i-check"></i></td>
                                <td class="">
                                    <input type="hidden" name="bidderId[]" value="<?=$item['bidderId']?>" >
                                    <input type="hidden" name="bidderName[]" value="<?=$item['bidderName']?>" >
                                    <?=$item['bidderName']?>
                                </td>
                                <td class=""><?=$bidderList[$item['bidderId']]['userName']?></td>
                            </tr>
                        </tbody>
                        <?php endforeach;?>
                    </table>
                </div>

                <div class="text-center padv20 hide" id="bidder-ok-wrap">
                    <a href="javascript:" class="btn" id="bidder-ok-btn">确  定</a>
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
    if('<?=$info['objectMethod']?>' == 'INV'){
        $("#yaoqing-wrap").removeClass('hide');
    }
    $("input[name='objectMethod']").each(function(){

        if(this.value == '<?=$info['objectMethod']?>'){
            this.checked = true;
            $(this).parent().addClass('active').siblings().removeClass('active');
            return false;
        }
    })
    <?php endif;?>

    var bidderList = <?=json_encode($bidderList)?>;

    //生成动态添加的html代码
    var _tr_html = '<tr>\
                        <td>\
                        <div class="checklist">\
                            <i class="ico i-check"></i>\
                        </div>\
                        </td>\
                        <td class="">%s</td>\
                        <td class="">&nbsp;</td>\
                    </tr>';
    var _select_html = '<select class="bidder_select wid160">';
    $.each(bidderList, function (i,item) {
        _select_html += '<option value="'+item.bidderId+'">'+item.bidderName+'</option>';
    });
    _select_html += '</select>';
    _tr_html = sprintf(_tr_html,_select_html)

    var bidder_body = $("#bidder-body");
    //为添加按钮绑定事件
    $("#add-bidder").click(function(){
        bidder_body.append(_tr_html);
        //手动触发下拉联动
        $(".bidder_select:last").change();
    });

    //二级联动触发事件
    $(document).on('change','.bidder_select',function(){

        $(this).parent().next().html(bidderList[this.value]['userName']);
        $("#bidder-ok-wrap").show();
    });

    //确定按钮事件
    $("#bidder-ok-btn").click(function(){

        $("#bidder-body select").each(function(){
            var $this = $(this);
            var _td_html = '<input type="hidden" name="bidderId[]" value="'+$this.val()+'" >';
            _td_html += '<input type="hidden" name="bidderName[]" value="'+$this.children(':selected').text()+'" >';
            _td_html += $this.children(':selected').text();
            $this.parent().html(_td_html);
        });

        //去除重复的行
        var data_list = [];
        $.each($("#bidder-body tr"),function(){
            var $this = $(this);
            var data = $this.attr('data');
            if(data != null){
                data_list.push(data);
            }else{
                data = $this.find("input[name='bidderId[]']").val();
                if($.inArray(data,data_list) > -1){
                    $this.remove();
                }else{
                    $this.attr('data',data);
                    data_list.push(data);
                }
            }
        });
        $("#bidder-ok-wrap").hide();
    })

    //删除事件
    $("#del-bidder").click(function(){
        var no_checked = true;
        $("#bidder-body .i-check").each(function(){
            var $this = $(this);
            if($this.hasClass('on')){
                $this.closest('tr').remove();
                no_checked = false;
            }
        });
        if(no_checked){
            layer.alert('请选择要删除的数据！',{icon:2});
        }
    })
})
</script>