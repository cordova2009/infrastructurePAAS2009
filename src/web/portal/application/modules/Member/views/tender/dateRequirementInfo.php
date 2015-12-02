<?php
if(check_resp($resp)){
    $info = $resp['dateRequirementInfo'];
}
?>
<div class="auto  box pad0" id="dateRequirementInfo">
    <div class="h2">招标时间要求</div>
    <div class="padm30">

        <form action="<?=U('/member/tender/saveDateRequirementInfo')?>" method="post" class="ajax-form" success="save_success" next_step="bidEvaluationTypeInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="shangwubiao gqyq">

            <div class="item ">
                <div class="lab"><span class="red">*</span>公告时间</div>
                <div class="value">
                    <input type="text" class="input1 datepicker wid160" placeholder="" name="announcementBeginTime" value="<?=isset($info)?$info['announcementBeginTime']:''?>"> 到
                    <input type="text" class="input1 datepicker wid160" placeholder="" name="announcementEndTime" value="<?=isset($info)?$info['announcementEndTime']:''?>">
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>投标截止时间</div>
                <div class="value">
                    <input type="text" class="input1 datepicker" placeholder="" name="biddingEndTime" value="<?=isset($info)?$info['biddingEndTime']:''?>">
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>开标时间</div>
                <div class="value">
                    <input type="text" class="input1 datepicker" placeholder="" name="bidOpenDate" value="<?=isset($info)?$info['bidOpenDate']:''?>">
                </div>
            </div>

        </div>

        <div class="charge_tips2">
            <p><i class="ico i-tips"></i> 温馨提示</p>
            <p>1.公告时间：自招标文件或者资格预审文件发出之日起至停止发出之日止，最短不得少于五日；</p>
            <p>2.公告时间表示招标信息的展示时间，投标截止时间应不早于信息公告截止时间，且不晚于开标时间。 </p>
        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>