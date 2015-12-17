<?php
extract($certificationInfo);
$cert_name_list = [
    'needPmCertification'=>'项目经理证明',
    'needConstructorCertification'=>'建造师证明',
    'needSafetyPermit'=>'安全生产许可证明',
    'needPmSafetyCertification'=>'项目经理安全生产考核合格证明',
];
if(is_array($bidRequirementInfo)){
    extract($bidRequirementInfo);
}
?>
<div class=" main">
    <?php require_once 'step.php'?>
    <div class="clear mart30" id="right-content">
        <?php require_once 'nav.php'?>
        <div class="auto box pad0" id="requirement">
            <div class="h2">资格审查</div>
            <div class="zhengming">
                <form action="<?=U('/member/bid/requirement')?>" method="post" class="ajax-form" success="save_success" next_step="businessStandard">
                    <input name="objectId" value="<?=$objectId?>" type="hidden" />
                    <input name="bidId" value="<?=isset($bidRequirementInfo['bidId']) ? $bidRequirementInfo['bidId'] : ''?>" type="hidden" />
                    <div class="tit6">投标人营业执照</div>
                    <div class="zhizhao_info">
                        <div class="text-center checkBtn">
                            <a href="javascript:;" <?php if($bidderInfo['businessLicenseType'] == 'NEW') echo 'class="active"'?>>统一社会信用代码</a>
                            <a href="javascript:;" <?php if($bidderInfo['businessLicenseType'] == 'OLD') echo 'class="active"'?>>非统一社会信用代码</a>
                        </div>
                        <div class="zhizhao">
                            <p>营业执照公司名称
                                <span class="padl40"><?=$bidderInfo['companyName']?></span>
                            </p>
                            <?php if($bidderInfo['businessLicenseType'] == 'NEW'):?>
                            <p>统一社会信用代码
                                <span class="padl40">
                                    <?=$bidderInfo['newBusinessLicenseNum'];?>
                                </span>
                            </p>
                            <p>统一社会信用代码扫描件
                                <span class="padl40">
                                    <a href="<?=imageView2($bidderInfo['newBusinessLicenseUrl'])?>" class="blue" target="_blank">查看</a>
                                </span>
                            </p>
                            <?php else:?>
                            <p>营业执照编号
                                <span class="padl40">
                                    <?=$bidderInfo['businessLicenseNum'];?>
                                </span>
                            </p>
                            <p>营业执照扫描件
                                <span class="padl40">
                                    <a href="<?=imageView2($bidderInfo['businessLicenseUrl'])?>" class="blue" target="_blank">查看</a>
                                </span>
                            </p>
                            <!--<p>组织机构代码证编号
                                <span class="padl40">
                                    <?/*=$bidderInfo['organizationCodeNum'];*/?>
                                </span>
                            </p>
                            <p>组织机构代码证扫描件
                                <span class="padl40">
                                    <a href="<?/*=imageView2($bidderInfo['organizationCodeUrl'])*/?>" class="blue" target="_blank">查看</a>
                                </span>
                            </p>
                            <p>税务登记证编号
                                <span class="padl40">
                                    <?/*=$bidderInfo['taxRegistrationNum'];*/?>
                                </span>
                            </p>
                            <p>税务登记证扫描件
                                <span class="padl40">
                                    <a href="<?/*=imageView2($bidderInfo['taxRegistrationUrl'])*/?>" class="blue" target="_blank">查看</a>
                                </span>
                            </p>-->
                            <?php endif;?>
                        </div>
                    </div>

                    <div class="tit6">投标人资质证书</div>
                    <div class="yaoqiu">
                        <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                        <?php
                            $item = current($requirementList);
                            $i = 0;
                            while($item):
                        ?>
                            <div class="clear txt2 <?=($i%2 == 0) ? '' : 'bordb2'?>">
                                <div class="li"><?=$item['certificationName']?></div>
                            <?php
                                $item = next($requirementList);
                                if(!empty($item)):
                            ?>
                                <div class="li"><?=$item['certificationName']?></div>
                            <?php
                                $item = next($requirementList);
                                endif;
                            ?>
                            </div>
                        <?php
                            $i++;
                            endwhile;
                        ?>
                    </div>
                    <p class="tips2">请根据招标要求填写或选择相应资质</p>
                    <div class="zhengshu checklist">
                        <ul class="clear">
                            <?php foreach($bidderList as $item):?>
                            <li>
                                <i class="ico i-check"></i>
                                <input class="hide" type="checkbox" name="bidderCertList[]" value="<?=$item['certificateId']?>"/>
                                <?=$item['certificationName']?>
                            </li>
                            <?php endforeach;?>
                        </ul>
                        <?php if(!empty($missingList)):?>
                        <p class="tips2">
                            对不起，您当前证书不满足投标要求，缺少证书：
                            <?php foreach($missingList as $item):?>
                                《<?=$item['certificationName']?>》
                            <?php endforeach;?>
                        </p>
                        <?php endif;?>
                    </div>
                    <?php if(!empty($safetyInfo)):?>
                    <div class="tit6">投标人安全生产证明</div>
                    <div class="yaoqiu">
                        <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                        <div class="clear txt2 ">
                        <?php foreach($safetyInfo as $key=>$item):?>
                            <?php if($item == 'YES'):?>
                            <div class="li"><?=$cert_name_list[$key]?></div>
                            <?php endif;?>
                        <?php endforeach;?>
                        </div>
                    </div>
                    <p class="tips2">请根据招标要求填写或选择相应资质</p>
                    <ul class="clear">
                        <?php if($safetyInfo['needSafetyPermit'] == 'YES'):?>
                        <li>
                            <div class="cell lab">
                                安全生产许可证明
                            </div>
                            <div class="cell padl20">
                                <input type="text" class="input1 " placeholder="编号" name="needSafetyPermitNo" value="<?=isset($bidSafetyInfo) ? $bidSafetyInfo['safetyPermitNo'] : ''?>"/>
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needSafetyPermitEndDate" value="<?=isset($bidSafetyInfo) ? $bidSafetyInfo['safetyPermitEndDate'] : ''?>"/>
                            </div>
                            <div class="cell padr40">
                                <a class="btn-file2" href="javascript:">
                                    <input type="file" class="file-upload" name="file"> 上传附件
                                    <input type="hidden" name="safetyPermitUrl" value="<?=isset($bidSafetyInfo) ? $bidSafetyInfo['safetyPermitEndDate'] : ''?>">
                                </a>
                            </div>
                        </li>
                        <?php endif;?>
                        <?php if($safetyInfo['needPmSafetyCertification'] == 'YES'):?>
                        <li>
                            <div class="cell lab">
                                项目经理安全生产<br>考核合格证明
                            </div>
                            <div class="cell padl20">
                                <input type="text" class="input1" placeholder="编号" name="needPmSafetyCertificationNo" value="<?=isset($bidSafetyInfo) ? $bidSafetyInfo['pmSafetyCertificationNo'] : ''?>"/>
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needPmSafetyCertificationEndDate" value="<?=isset($bidSafetyInfo) ? $bidSafetyInfo['pmSafetyCertificationEndDate'] : ''?>"/>
                            </div>
                            <div class="cell padr40">
                                <a class="btn-file2" href="javascript:">
                                    <input type="file" class="file-upload" name="file"> 上传附件
                                    <input type="hidden" name="pmSafetyCertificationUrl" value="<?=isset($bidSafetyInfo) ? $bidSafetyInfo['pmSafetyCertificationUrl'] : ''?>">
                                </a>
                            </div>
                        </li>
                        <?php endif;?>
                    </ul>
                    <?php endif;?>

                    <?php if(!empty($peopleRequirement)):?>
                    <div class="tit6">投标人主要人员资质</div>
                    <div class="yaoqiu">
                        <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                        <div class="clear txt2 ">
                            <?php foreach($peopleRequirement as $key=>$item):?>
                                <?php if($item == 'YES'):?>
                                    <div class="li"><?=$cert_name_list[$key]?></div>
                                <?php endif;?>
                            <?php endforeach;?>
                        </div>
                    </div>
                    <p class="tips2">请根据招标要求填写或选择相应资质</p>
                    <ul class="clear">
                        <li>
                            <div class="cell lab">
                                项目经理证
                            </div>
                            <div class="cell padl20">
                                <input type="text" class="input1 " placeholder="编号" name="needPmCertificationNo" value="<?=isset($bidPeopleRequirement) ? $bidPeopleRequirement['pmCertificationNo'] : ''?>">
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needPmCertificationEndDate" value="<?=isset($bidPeopleRequirement) ? $bidPeopleRequirement['pmCertificationEndDate'] : ''?>">
                            </div>
                            <div class="cell padr40">
                                <a class="btn-file2" href="javascript:">
                                    <input type="file" class="file-upload" name="file"> 上传附件
                                    <input type="hidden" name="pmCertificationUrl" value="<?=isset($bidPeopleRequirement) ? $bidPeopleRequirement['pmCertificationUrl'] : ''?>">
                                </a>
                            </div>
                        </li>
                        <li>
                            <div class="cell lab">
                               注册建造师证
                            </div>
                            <div class="cell padl20">
                                <input type="text" class="input1" placeholder="编号" name="needConstructorCertificationNo" value="<?=isset($bidPeopleRequirement) ? $bidPeopleRequirement['constructorCertificationNo'] : ''?>">
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needConstructorCertificationEndDate" value="<?=isset($bidPeopleRequirement) ? $bidPeopleRequirement['constructorCertificationEndDate'] : ''?>">
                            </div>
                            <div class="cell padr40">
                                <a class="btn-file2" href="javascript:">
                                    <input type="file" class="file-upload" name="file"> 上传附件
                                    <input type="hidden" name="constructorCertificationUrl" value="<?=isset($bidPeopleRequirement) ? $bidPeopleRequirement['constructorCertificationUrl'] : ''?>">
                                </a>
                            </div>
                        </li>
                    </ul>
                    <?php endif;?>

                    <div class="tit6">投标保函</div>
                    <div class="zhengshu2 checklist">
                        <ul class="clear">
                            <li>
                                <div class="cell lab">
                                    投标保函金额
                                </div>
                                <div class="cell ">
                                    <span class="yuanbox ">
                                        <input type="text" class="input1 price_format" placeholder="" name="bankGuaranteeAmount" value="<?=isset($bankGuarantee) ? price_format($bankGuarantee['bankGuaranteeAmount']) : ''?>">
                                        <span class="yuan">元</span>
                                    </span>
                                    <span class="padm50 " >
                                        保函凭证扫描件
                                        <a href="javascript:" class="btn-file2" >
                                            <input class="file-upload" type="file" name="file">
                                            <input type="hidden" name="bankGuaranteeUrl" value="<?=isset($bankGuarantee) ? $bankGuarantee['bankGuaranteeUrl'] : ''?>">
                                            上传附件
                                        </a>
                                    </span>
                                </div>
                            </li>
                            <li>

                                <div class="cell lab">
                                    保函凭证编号
                                </div>
                                <div class="cell">
                                    <input type="text" class="input1" placeholder="" name="bankGuaranteeNo" value="<?=isset($bankGuarantee) ? $bankGuarantee['bankGuaranteeNo'] : ''?>">
                                </div>
                            </li>

                        </ul>
                    </div>

                    <?php if(!empty($missingList)):?>
                    <p class="tips2">
                        对不起，您当前证书不满足投标要求，缺少证书：
                        <?php foreach($missingList as $item):?>
                            《<?=$item['certificationName']?>》
                        <?php endforeach;?>
                    </p>
                    <?php endif;?>

                    <div class="text-center padv30">
                        <button <?php if(empty($missingList)):?> type="submit" class="btn-green2" <?php else :?> type="button" class="btn-green2 bg-grey" <?php endif;?>>保存并继续</button>
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
<script src="/js/jquery.datetimepicker.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="/js/upload/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/js/upload/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="/js/upload/jquery.fileupload.js"></script>
<script>
$(function(){
    $("#side_menu_ul li:eq(0)").addClass('on');

    $("#side_menu_ul li").click(function () {
        var $this = $(this);
        var wrap = $($this.children('a').attr('href'));
        if(wrap.length > 0){
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


function save_success(form,resp) {
    var next_step = form.attr('next_step');
    var wrap = $("#"+next_step);
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

    var data = {step: next_step,objectId:resp.objectId,bidId:resp.bidId};
    var loading = layer.load();
    //开始加载下一个页面
    $.post('<?=U('/member/bid/step')?>', data, function (rs) {
        if(rs.status != '0'){
            layer.alert(rs.msg,{icon:2});
            return false;
        }

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
        var integrity = ((resp.step/5)*100).toFixed(0);
        $("#progress-info").text(integrity+'%');
        $("#progress-bar").animate({width:integrity+'%'},"slow");

    }, 'json').always(function () {
        layer.close(loading);
    });
}

function step_toggle(step){
    if(step == 1){
        $("#step-box li:eq(0)").addClass('active');
        $("#step-box li:gt(0)").removeClass('active');
    }else if(step ==2){
        $("#step-box li:eq(1)").addClass('active');
        $("#step-box li:gt(1)").removeClass('active');
    }else if(step ==3){
        $("#step-box li:eq(2)").addClass('active');
        $("#step-box li:gt(2)").removeClass('active');
    }else if(step == 4){
        $("#step-box li:eq(3)").addClass('active');
    }
}

$(".file-upload").fileupload({
    url:'<?=U('/member/upload/picture')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
    dataType: 'json',
    done:function(e,data){
        //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
        //返回的数据在data.result中，假设我们服务器返回了一个json对象
        if(data.result.status == '0'){
            $(this).next().val(data.result.url);
        }else{
            layer.alert(data.result.msg,{icon:2});
        }
    }
})
</script>

</block>