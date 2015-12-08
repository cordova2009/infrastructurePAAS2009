<div class=" main">
    <?php require_once 'step.php'?>
    <div class="clear mart30" id="right-content">

        <?php require_once 'nav.php'?>
        <div class="auto box pad0" id="baseInfo">
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
    //左侧菜单第一个设置为高亮
    $("#side_menu_ul li:eq(0)").addClass('on');

    //左侧菜单事件绑定
    $("#side_menu_ul li").click(function () {
        var $this = $(this);
        var wrap = $($this.children('a').attr('href'));
        if(wrap.length > 0){
//            wrap.remove();
//            var form = $('<form></form>');
//            form.attr('next_step',$this.children('a').attr('href').replace('#',''));
//            save_success({step:$this.index(),objectId:'ZB00201512051631124'},form);
//            return false;
            $("#right-content .box").hide();
            $("#side_menu_ul li").removeClass('on');
            wrap.show();
            $this.addClass('on');
            //顶部的进度条变化
            step_toggle($this.index());
        }
        return false;
    });

    <?php if(isset($info) && $info['evaluationAmountVisiable'] == 'DIS'):?>
    $(".amount-visiable").each(function(){
        if(this.value == '<?=$info['evaluationAmountVisiable']?>'){
            this.checked = true;
            return false;
        }
    })
    <?php endif;?>
})

/**
 * 表单保存成功后的回调
 * @param resp
 * @param form
 * @returns {boolean}
 */
function save_success(resp,form) {
    var next_step = form.attr('next_step');
    var wrap = $(next_step);
    //已经加载过的，不需要再次加载
    if(wrap.length > 0){
        $("#right-content .box").hide();
        $("#side_menu_ul li").removeClass('on');
        wrap.show();
        $("#side_menu_ul li a").each(function(i){
            var $this = $(this);
            if($this.attr('href') == '#'+next_step){
                $this.parent('li').addClass('on');
                //顶部的进度条变化
                step_toggle(i);
            }
        })
        return true;
    }

    var data = {step: next_step,objectId:resp.objectId};
    var loading = layer.load();
    //开始加载下一个页面
    $.post('<?=U('/member/tender/step')?>', data, function (rs) {
        $("#right-content .box").hide();
        $("#right-content").append(rs.html);

        $("#side_menu_ul li")
            .removeClass('on')
            .eq(resp.step)
            .addClass('on').prev('li').children('a')
            .append('<i class="ico i-right"></i>');

        //顶部的进度条变化
        step_toggle(resp.step);

        //左侧的进度条变化
        var integrity = ((resp.step/11)*100).toFixed(0);
        $("#progress-info").text(integrity+'%');
        $("#progress-bar").animate({width:integrity+'%'},"slow");

    }, 'json').always(function () {
        layer.close(loading);
    });
}

/**
 * 顶部的进度条变化
 * @param step
 */
function step_toggle(step){
    if(step >= 1 && step < 4){
        $("#step-box li:eq(0)").addClass('active');
        $("#step-box li:gt(0)").removeClass('active');
    }else if(step >= 4 && step < 7){
        $("#step-box li:eq(1)").addClass('active');
        $("#step-box li:gt(1)").removeClass('active');
    }else if(step >= 7 && step < 10){
        $("#step-box li:eq(2)").addClass('active');
        $("#step-box li:gt(2)").removeClass('active');
    }else if(step == 10){
        $("#step-box li:eq(3)").addClass('active');
    }
}
</script>

<script src="/js/jquery.datetimepicker.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="/js/upload/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/js/upload/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="/js/upload/jquery.fileupload.js"></script>
</block>