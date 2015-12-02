<?php
if(check_resp($resp)){
    $info = $resp['requirementInfo'];
}
?>
<div class="auto  box pad0" id="requirementInfo">
    <div class="h2">工期要求</div>
    <div class="padm30">
        <form action="<?=U('/member/tender/saveRequirementInfo')?>" method="post" class="ajax-form" success="save_success" next_step="certificationInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="shangwubiao gqyq">

            <div class="item ">
                <div class="lab"><span class="red">*</span>计划开工日期</div>
                <div class="value">
                    <input type="text" class="input1 datepicker" placeholder="" name="projectExpectStartDate" value="<?=isset($info)?$info['projectExpectStartDate']:''?>">
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>标准工期</div>
                <div class="value">
                    <span class="yuanbox">
                        <span class="yuan">日历日</span>
                        <input type="text" class="input1 width330" placeholder="" name="projectExpectPeriod" value="<?=isset($info)?$info['projectExpectPeriod']:''?>">
                    </span>
                </div>
            </div>

        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>