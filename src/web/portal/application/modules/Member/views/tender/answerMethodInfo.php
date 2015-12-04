<?php
if(check_resp($resp)){
    $info = $resp['answerQuestion'];
}
?>
<div class="auto box pad0" id="answerMethodInfo">
    <div class="h2">答疑方式</div>
    <div class="padm30">
        <form action="<?=U('/member/tender/saveAnswerQuestion')?>" method="post" class="ajax-form" success="save_success" next_step="dateRequirementInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="dayi ">
            <div class="item ">
                <div class="lab"><span class="red">*</span>答疑时间</div>
                <div class="value">
                    <input type="text" class="input1 datepicker wid160" placeholder="" name="startTime" value="<?=isset($info)?$info['startTime']:''?>"> 到
                    <input type="text" class="input1 datepicker wid160" placeholder="" name="endTime" value="<?=isset($info)?$info['endTime']:''?>">
                </div>
            </div>
            <div class="txt1"><span class="red">*</span>答疑方式 <span class="fz14 color5">（必填一种）</span></div>

            <div class="table">
                <div class="cell checklist">
                    <i class="ico i-check <?php if(isset($info) && !empty($info['qq'])) echo 'on'?>""></i>
                    <input type="checkbox" class="hide" <?php if(isset($info) && !empty($info['qq'])) echo 'checked'?>>
                </div>
                <div class="cell icoCont">
                    <i class="ico i-qq"></i>
                </div>
                <div class="cell">
                    <p class="txt">QQ群方式</p>
                    <input type="text" class="wid70 input2" name="QQ" value="<?=isset($info)?$info['qq']:''?>">
                    加入QQ群口令 <input type="text" class="wid70 input2" name="QQtoken" value="<?=isset($info)?$info['qqtoken']:''?>">
                    <p>加入后可在QQ群里提问，我们将在线答疑。</p>
                </div>
            </div>

            <div class="table">
                <div class="cell checklist">
                    <i class="ico i-check <?php if(isset($info) && !empty($info['email'])) echo 'on'?>""></i>
                    <input type="checkbox" class="hide" <?php if(isset($info) && !empty($info['email'])) echo 'checked'?>>
                </div>
                <div class="cell icoCont">
                    <i class="ico i-mail"></i>
                </div>
                <div class="cell">
                    <p class="txt">邮件方式</p>
                    请发邮件到 <input type="text" class="input2 wid110" name="email" value="<?=isset($info)?$info['email']:''?>">
                    <p>我们将在48小时内回复。</p>
                </div>
            </div>

            <div class="table">
                <div class="cell checklist">
                    <i class="ico i-check <?php if(isset($info) && !empty($info['telephone'])) echo 'on'?>""></i>
                    <input type="checkbox" class="hide" <?php if(isset($info) && !empty($info['telephone'])) echo 'checked'?>>
                </div>
                <div class="cell icoCont">
                    <i class="ico i-tel"></i>
                </div>
                <div class="cell">
                    <p class="txt">电话方式</p>
                    请在上班时间拨打 <input type="text" class="wid130 input2" name="telephone" value="<?=isset($info)?$info['telephone']:''?>"> 答疑
                </div>
            </div>

            <div class="table">
                <div class="cell checklist">
                    <i class="ico i-check <?php if(isset($info) && !empty($info['address'])) echo 'on'?>""></i>
                    <input type="checkbox" class="hide" <?php if(isset($info) && !empty($info['address'])) echo 'checked'?>>
                </div>
                <div class="cell icoCont">
                    <i class="ico i-xc"></i>
                </div>
                <div class="cell">
                    <p class="txt">现场方式</p>
                    <div>地点
                        <input type="text" class="wid240 input2" name="address" value="<?=isset($info)?$info['address']:''?>">
                    </div>
                    <div class="padt10">时间
                        <input type="text" class="input2 wid110 datepicker" name="addressAnswerDate" value="<?=isset($info)?$info['addressAnswerDate']:''?>">
                        <input type="text" placeholder ="14:00-16:30" class="input2 wid100" name="addressAnswerTime" value="<?=isset($info)?$info['addressAnswerTime']:''?>">
                    </div>
                </div>
            </div>

        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>