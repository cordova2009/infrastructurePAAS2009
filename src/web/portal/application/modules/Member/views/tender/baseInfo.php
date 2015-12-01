<div class=" main">
    <?php require_once 'step.php'?>
    <div class="clear mart30" id="right-content">

        <?php require_once 'nav.php'?>
        <div class="auto box pad0" id="base-info">
            <div class="h2">招标项目信息</div>
            <div class="padm30">
                <form action="<?=U('/member/tender/baseInfo')?>" method="post" class="ajax-form" success="save_success" next_step="projectInfo">
                <input name="objectId" value="<?=isset($info)?$info['objectId']:''?>" type="hidden" />
                <div class="shangwubiao zbxmxx">
                    <div class="item ">
                        <div class="lab"><span class="red">*</span>  招标项目名称</div>
                        <div class="value">
                            <input name="objectName" type="text" class="input1 " placeholder="" value="<?=isset($info)?$info['objectName']:''?>">
                        </div>
                    </div>
                    <div class="item ">
                        <div class="lab"><span class="red">*</span>  招标项目编号</div>
                        <div class="value">
                            <input name="biddingNo" type="text" class="input1 " placeholder="" value="<?=isset($info)?$info['biddingNo']:''?>">
                        </div>
                    </div>
                    <div class="item ">
                        <div class="lab"><span class="red">*</span>招标项目范围</div>
                        <div class="value">
                            <input name="objectScope" type="text" class="input1 " placeholder="" value="<?=isset($info)?$info['objectScope']:''?>">
                        </div>
                    </div>
                    <div class="item ">
                        <div class="lab"><span class="red">*</span>招标经办人</div>
                        <div class="value">
                            <input name="biddeeCompanyPrincipal" type="text" class="input1 " placeholder="" value="<?=isset($info)?$info['biddeeCompanyPrincipal']:''?>">
                        </div>
                    </div>
                    <div class="item ">
                        <div class="lab"><span class="red">*</span>招标办公电话</div>
                        <div class="value">
                            <input name="biddeeCompanyTelephone" type="text" class="input1 " placeholder="区号+座机号码+分机号码" value="<?=isset($info)?$info['biddeeCompanyTelephone']:''?>">
                        </div>
                    </div>
                    <div class="item ">
                        <div class="lab"><span class="red">*</span>采用币种</div>
                        <div class="value">
                            <div class="select">
                                <select name="currency" id="">
                                    <option value="CNY" <?php if(isset($info) && $info['currency'] == 'CNY') echo 'selected'?>>人民币</option>
                                    <option value="USD" <?php if(isset($info) && $info['currency'] == 'USD') echo 'selected'?>>美元</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="item ">
                        <div class="lab"><span class="red">*</span>标的估价</div>
                        <div class="value">
                            <span class="yuanbox">
                                <span class="yuan">元</span>
                                <input name="evaluationAmount" type="text" class="input1 price_format" placeholder="" value="<?=isset($info)?price_convert($info['evaluationAmount']):''?>">
                            </span>
                        </div>
                    </div>

                    <div class="item ">
                        <div class="lab">估价是否公开</div>
                        <div class="value">
                            <label class="marl60">
                                <input type="radio" name="evaluationAmountVisiable" value="ENB" class="verm amount-visiable" checked="checked"> 公开</label>
                            <label class="marl60">
                                <input type="radio" name="evaluationAmountVisiable" value="DIS" class="verm amount-visiable"> 不公开</label>
                        </div>
                    </div>

                    <div class="item ">
                        <div class="lab"><span class="red">*</span>承包方式</div>
                        <div class="value">
                            <textarea name="contractType" class="textarea" placeholder="设计—采购总承包"><?=isset($info)?$info['contractType']:''?></textarea>
                        </div>
                    </div>
                </div>

                <div class="text-center padv30">
                    <button type="submit" class="btn-green2">保存并继续</button>
                </div>

                </form>
            </div>
        </div>
    </div>
    <!--list-->
</div>
<block>
<link href="/css/jquery.datetimepicker.css" rel="stylesheet" type="text/css" />
</block>
<block name="script">
<script>
$(function(){
//    $("#left-menu .submenu:eq(0),#left-menu .submenu:eq(0) a:eq(0)").addClass('active');
    $("#side_menu_ul li:eq(0)").addClass('on');

    <?php if(isset($info) && $info['evaluationAmountVisiable'] == 'DIS'):?>
    $(".amount-visiable").each(function(){
        if(this.value == '<?=$info['evaluationAmountVisiable']?>'){
            this.checked = true;
            return false;
        }
    })
    <?php endif;?>
})


function save_success(resp,form) {
    var data = {step: form.attr('next_step'),objectId:resp.objectId};

    var loading = layer.load();
    $.post('<?=U('/member/tender/step')?>', data, function (rs) {
        $("#right-content .box").addClass('hide');
        $("#right-content").append(rs.html);

        $("#side_menu_ul li")
            .removeClass('on')
            .eq(resp.step)
            .addClass('on').prev('li').children('a')
            .append('<i class="ico i-right"></i>');

        var integrity = ((resp.step/11)*100).toFixed(0);
        $("#progress-info").text(integrity+'%');
        $("#progress-bar").animate({width:integrity+'%'},"slow");

    }, 'json').always(function () {
        layer.close(loading);
    });
}
</script>

<script src="/js/jquery.datetimepicker.js"></script>
</block>