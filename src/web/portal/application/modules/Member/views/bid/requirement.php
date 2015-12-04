<div class=" main">
    <?php require_once 'step.php'?>
    <div class="clear mart30" id="right-content">

        <?php require_once 'nav.php'?>
        <div class="auto box pad0" id="requirement">
            <div class="h2">资格审查</div>
            <div class="padm60">
                <div class="tit6">投标人营业执照</div>
                <div class="zhizhao_info">
                    <div class="text-center checkBtn">
                        <a href="javascript:;" <?php if($bidderInfo['businessLicenseType'] == 'NEW') echo 'class="active"'?>>统一社会信用代码</a>
                        <a href="javascript:;" <?php if($bidderInfo['businessLicenseType'] == 'OLD') echo 'class="active"'?>>非统一社会信用代码</a>
                    </div>
                    <div class="zhizhao">
                        <p>营业执照公司名称 <span class="padl40"><?=$bidderInfo['companyName']?></span></p>
                        <p>营业执照编号 <span class="padl40">
                                <?=($bidderInfo['businessLicenseType'] == 'NEW')? $bidderInfo['newBusinessLicenseNum']: $bidderInfo['businessLicenseNum'];?>
                            </span></p>
                        <p>营业执照扫描件 <span class="padl40"><a href="<?=($bidderInfo['businessLicenseType'] == 'NEW')? $bidderInfo['newBusinessLicenseUrl']: $bidderInfo['businessLicenseUrl'];?>" class="blue">查看</a></span></p>
                    </div>
                </div>
                <div class="tit6">投标人资质证书</div>
                <div class="yaoqiu">
                    <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                    <?php for($num=0;$num<$bidderInfo['requirementList'].size();$num=$num+2): ?>
                    <div class="clear txt2  <?=(($num+2)>=$bidderInfo['requirementList'].size())?  : bordb2; ?>">
                        <div class="li">$bidderInfo['requirementList'][$num]['certificationName']</div>
                        <div class="li">$bidderInfo['requirementList'][$num+1]['certificationName']</div>
                    </div>
                    <?php endfor; ?>
                </div>
                <p class="tips2">请根据招标要求填写或选择相应资质</p>
                <div class="zhengshu checklist">
                    <ul class="clear">
                        <?php foreach($bidderInfo['bidderList'] as $item): ?>
                        <li>
                            <?php if(in_array($item['bidderCertificateId'], $bidRequirementInfo['certificationList'])){ ?>
                                <i class="ico i-check on" ></i>
                                <input type="checkbox" checked name="certificationList" value="<?=$item['bidderCertificateId']?>" class="hide" >
                                <?=$item['certificationName']?>
                            <?php } else { ?>
                                <i class="ico i-check" ></i>
                                <input type="checkbox" name="certificationList" value="<?=$item['bidderCertificateId']?>" class="hide" >
                                <?=$item['certificationName']?>
                            <?php } ?>
                        </li>
                        <?php endforeach; ?>
                    </ul>
                </div>
                <div class="tit6">投标人安全生产证明</div>
                <div class="yaoqiu">
                    <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                    <div class="clear txt2 ">
                        <div class="li"><?=($bidSafetyInfo['needSafetyPermit'] == 'NO#')? :安全生产许可证明 ;?></div>
                        <div class="li"><?=($bidSafetyInfo['needSafetyPermit'] == 'NO#')? :项目经理安全生产考核合格证明 ;?></div>
                    </div>
                </div>
                <p class="tips2">请根据招标要求填写或选择相应资质</p>
                <div class="zhengshu2 checklist">
                    <ul class="clear">
                        <li>
                            <div class="cell lab">
                                <i class="ico i-check"></i> 安全生产许可证明
                            </div>
                            <div class="cell">
                                <input type="text" class="input1 " placeholder="编号" name="needSafetyPermitNo" value="<?=$bidRequirementInfo['bidSafetyInfo']['safetyPermitNo'] ?>"/>
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needSafetyPermitEndDate" value="<?=$bidRequirementInfo['safetyPermitEndDate']['safetyPermitEndDate'] ?>"/>
                               <!-- <label class="btn-file2 padm20" ><input type="file" name="needSafetyPermitUrl" value="<?/*=$bidRequirementInfo['safetyPermitEndDate']['safetyPermitUrl'] */?>">上传附件</label>-->
                            </div>
                        </li>
                        <li>
                            <div class="cell lab">
                                <i class="ico i-check"></i> 项目经理安全生产<br>考核合格证明
                            </div>
                            <div class="cell">
                                <input type="text" class="input1" placeholder="编号" name="needPmSafetyCertificationNo" value="<?=$bidRequirementInfo['safetyPermitEndDate']['pmSafetyCertificationNo'] ?>"/>
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needPmSafetyCertificationEndDate" value="<?=$bidRequirementInfo['safetyPermitEndDate']['pmSafetyCertificationEndDate'] ?>"/>
                                <!--<label class="btn-file2 padm20" ><input type="file" name="needPmSafetyCertificationUrl" value="<?/*=$bidRequirementInfo['safetyPermitEndDate']['pmSafetyCertificationUrl'] */?>">上传附件</label>-->
                            </div>
                        </li>

                    </ul>
                </div>
                <div class="tit6">投标人主要人员资质</div>
                <div class="yaoqiu">
                    <div class="txt1"><i class="ico i-paper"></i> 招标要求</div>
                    <div class="clear txt2 ">
                        <div class="li"><?=($bidPeopleRequirement['needPmCertification'] == 'NO#')? :项目经理证 ;?></div>
                        <div class="li"><?=($bidPeopleRequirement['needConstructorCertification'] == 'NO#')? :注册建造师证 ;?></div>
                    </div>
                </div>
                <p class="tips2">请根据招标要求填写或选择相应资质</p>
                <div class="zhengshu2 checklist">
                    <ul class="clear">
                        <li>
                            <div class="cell lab">
                                <i class="ico i-check"></i> 项目经理证
                            </div>
                            <div class="cell">
                                <input type="text" class="input1 " placeholder="编号" name="needPmCertificationNo" value="<?=$bidRequirementInfo['bidPeopleRequirement']['pmCertificationNo'] ?>">
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needPmCertificationEndDate" value="<?=$bidRequirementInfo['bidPeopleRequirement']['pmCertificationEndDate'] ?>">
                                <!--<label class="btn-file2 padm20" ><input type="file" name="needPmCertificationUrl" value="<?/*=$bidRequirementInfo['bidPeopleRequirement']['pmCertificationUrl'] */?>">上传附件</label>-->
                            </div>
                        </li>
                        <li>
                            <div class="cell lab">
                                <i class="ico i-check"></i> 注册建造师证
                            </div>
                            <div class="cell">
                                <input type="text" class="input1" placeholder="编号" name="needConstructorCertificationNo" value="<?=$bidRequirementInfo['bidPeopleRequirement']['constructorCertificationNo'] ?>">
                                <input type="text" class="input1 datepicker" placeholder="有效期" name="needConstructorCertificationEndDate" value="<?=$bidRequirementInfo['bidPeopleRequirement']['constructorCertificationEndDate'] ?>">
                                <!--<label class="btn-file2 padm20" ><input type="file" name="needConstructorCertificationUrl" value="<?/*=$bidRequirementInfo['bidPeopleRequirement']['constructorCertificationUrl'] */?>">上传附件</label>-->
                            </div>
                        </li>

                    </ul>
                </div>
                <div class="tit6">投标保函</div>
                <div class="zhengshu2 checklist">
                    <ul class="clear">
                        <li>

                            <div class="cell ">
                                <span class="yuanbox ">
                                    <span class="yuan">元</span>
                                    <input type="text" class="input1 " placeholder="" name="bankGuaranteeAmount" value="<?=$bidRequirementInfo['bidPeopleRequirement']['bankGuaranteeAmount'] ?>">
                                </span>
                                <!--<span class="padm50 " >
                                    保函凭证扫描件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <label class="btn-file2 padm20" ><input type="file" name="bankGuaranteeUrl" value="<?/*=$bidRequirementInfo['bidPeopleRequirement']['bankGuaranteeUrl'] */?>">上传附件</label>
                                </span>-->
                            </div>
                        </li>
                        <li>

                            <div class="cell">
                                <input type="text" class="input1" placeholder="" name="bankGuaranteeNo" value="<?=$bidRequirementInfo['bidPeopleRequirement']['bankGuaranteeNo'] ?>">
                            </div>
                        </li>

                    </ul>
                </div>
                <div class="text-center padv30">
                    <a href="#" class="btn-green2">保存并继续</a>
                </div>

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


        function save_success(resp,form) {
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

            var data = {step: next_step,objectId:resp.objectId};
            var loading = layer.load();
            //开始加载下一个页面
            $.post('<?=U('/member/bid/step')?>', data, function (rs) {
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
    </script>

    <script src="/js/jquery.datetimepicker.js"></script>
</block>