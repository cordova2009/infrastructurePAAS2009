<?php
extract($certificationInfo);
if(is_array($bidRequirementInfo)){
    extract($bidRequirementInfo);

    if(isset($bidSafetyInfo) && isset($bidPeopleRequirement)){
        $queryNeedCertList = array_merge($bidSafetyInfo,$bidPeopleRequirement);
        unset($bidSafetyInfo);
        unset($bidPeopleRequirement);
    }
    unset($bidRequirementInfo);
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
                    <input name="bidId" value="<?=isset($bidId) ? $bidId : ''?>" type="hidden" />
                    <div class="tit6">投标人营业执照</div>
                    <div class="zhizhao_info">
                        <div class="text-center checkBtn">
                            <a href="javascript:;" <?php if($bidderInfo['businessLicenseType'] == 'NEW') echo 'class="active"'?>>统一社会信用代码</a>
                            <a href="javascript:;" <?php if($bidderInfo['businessLicenseType'] == 'OLD') echo 'class="active"'?>>非统一社会信用代码</a>
                        </div>
                        <div class="zhizhao">
                            <p>
                                <span class="wid180 left">营业执照公司名称</span>
                                <span class="padl40 "><?=$bidderInfo['companyName']?></span>
                            </p>
                            <?php if($bidderInfo['businessLicenseType'] == 'NEW'):?>
                            <p>
                                <span class="wid180 left">统一社会信用代码</span>
                                <span class="padl40 ">
                                    <?=$bidderInfo['newBusinessLicenseNum'];?>
                                </span>
                            </p>
                            <p>
                                <span class="wid180 left">统一社会信用代码扫描件</span>
                                <span class="padl40 ">
                                    <a href="<?=imageView2($bidderInfo['newBusinessLicenseUrl'])?>" class="blue" target="_blank">查看</a>
                                </span>
                            </p>
                            <?php else:?>
                            <p>
                                <span class="wid180 left">营业执照编号</span>
                                <span class="padl40 ">
                                    <?=$bidderInfo['businessLicenseNum'];?>
                                </span>
                            </p>
                            <p>
                                <span class="wid180 left">营业执照扫描件</span>
                                <span class="padl40 ">
                                    <a href="<?=imageView2($bidderInfo['businessLicenseUrl'])?>" class="blue" target="_blank">查看</a>
                                </span>
                            </p>
                            <?php endif;?>
                        </div>
                    </div>

                    <div class="tit6">投标人资质证书</div>
                    <div class="yaoqiu">
                        <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                        <?php
                            $item = current($requirementList);
                            $i = 0;
                            $need_array = [];
                            while($item):
                                $need_array[] = $item['certificateId'];
                        ?>
                            <div class="clear txt2 <?=($i%2 == 0) ? '' : 'bordb2'?>">
                                <div class="li"><?=$item['certificationName']?></div>
                            <?php
                                $item = next($requirementList);
                                if(!empty($item)):
                                    $need_array[] = $item['certificateId'];
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
                            <?php
                                foreach($bidderList as $item):
                                    //判断所拥有的证书是否在要求证书列表中
                                    $checked = '';
                                    $class = '';
                                    if(in_array($item['certificateId'],$need_array)){
                                        $checked = 'checked';
                                        $class= 'on';
                                    }
                            ?>
                            <li>
                                <i class="ico i-check <?=$class?>"></i>
                                <input class="hide" type="checkbox" <?=$checked?> name="bidderCertList[]" value="<?=$item['certificateId']?>"/>
                                <?=$item['certificationName']?>
                            </li>
                            <?php endforeach;?>
                        </ul>
                        <?php if(empty($missingList)):?>
                        <p class="tips2 red">
                            对不起，您当前证书不满足投标要求，缺少证书：
                            <?php foreach($missingList as $item):?>
                                《<?=$item['certificationName']?>》
                            <?php endforeach;?>
                        </p>
                        <?php endif;?>
                    </div>

                    <?php
                        foreach($needCertList as $title=>$certList):
                            if(empty($certList)){
                                continue;
                            }
                    ?>
                        <div class="tit6"><?=$title?></div>
                        <div class="yaoqiu">
                            <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                            <div class="clear txt2 ">
                                <?=implode('',$certList)?>
                            </div>
                        </div>
                        <p class="tips2">请根据招标要求填写或选择相应资质</p>
                        <ul class="clear">
                        <?php foreach($certList as $key=>$val):?>
                            <li class="upload_wrap">
                                <div class="cell lab">
                                    <?=$cert_name_list[$key]?>
                                </div>

                                <div class="cell padl20">
                                    <input type="text" class="input1 " placeholder="编号" name="<?=$key?>No" value="<?=isset($queryNeedCertList) ? $queryNeedCertList[$key.'No'] : ''?>">
                                    <input type="text" class="input1 datepicker" placeholder="有效期" name="<?=$key?>EndDate" value="<?=isset($queryNeedCertList) ? $queryNeedCertList[$key.'EndDate'] : ''?>">
                                </div>
                                <div class="cell padr40">
                                    <a class="btn-file2" href="javascript:">
                                        <span>上传附件</span>
                                        <input type="file" class="file-upload" name="file">
                                        <input type="hidden" class="hidden-url" name="<?=$key?>Url" value="<?=isset($queryNeedCertList) ? $queryNeedCertList[$key.'Url'] : ''?>">
                                    </a>
                                </div>
                            </li>

                            <li class="uploaded mart10 <?php if(!isset($queryNeedCertList) || empty($queryNeedCertList[$key.'Url'])) echo 'hide2'?>">
                                <div class="cell lab">
                                </div>
                                <div class="value padl20">
                                    <a target="_blank" href="<?=isset($queryNeedCertList)?imageView2($queryNeedCertList[$key.'Url']):''?>" class="btn-file2 view">查看</a>
                                    <a class="btn-file2 bg-grey delete-pic-btn">删除</a>
                                </div>
                            </li>
                        <?php endforeach;?>
                        </ul>
                    <?php endforeach;?>

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
                                    <span class="padm50">
                                        保函凭证扫描件
                                        <a href="javascript:" class="btn-file2 <?php if(isset($bankGuarantee) && !empty($bankGuarantee['bankGuaranteeUrl'])) echo 'hide'?>" >
                                            <span>上传附件</span>
                                            <input class="file-upload" type="file" name="file">
                                            <input type="hidden" class="hidden-url" name="bankGuaranteeUrl" value="<?=isset($bankGuarantee) ? $bankGuarantee['bankGuaranteeUrl'] : ''?>">
                                        </a>
                                        <span class="uploaded <?php if(!isset($bankGuarantee) || empty($bankGuarantee['bankGuaranteeUrl'])) echo 'hide'?>">
                                            <a target="_blank" href="<?=isset($bankGuarantee)?imageView2($bankGuarantee['bankGuaranteeUrl']):''?>" class="btn-file2 view" style="width: 50px;">查看</a>
                                            <a class="btn-file2 bg-grey delete-pic-btn" style="width: 50px;">删除</a>
                                        </span>
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
                    <p class="tips2 red">
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
    $("#step-box li").removeClass('active').eq(step).addClass('active');
}
</script>
<?php require_once __DIR__.'/../common/upload.js.php';?>
<?php require_once __DIR__.'/../common/upload.pic.php';?>
</block>