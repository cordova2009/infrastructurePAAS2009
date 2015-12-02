<?php
if(check_resp($resp)){
    $info = $resp['bidFileTypeInfo'];
}
?>
<div class="auto  box pad0">
    <div class="h2">招投标文件要求</div>
    <div class="padm30">
        <form action="<?=U('/member/tender/saveBidFileTypeInfo')?>" method="post" class="ajax-form" success="save_success" next_step="answerMethodInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="shangwubiao">
            <div class="tit6"><span class="red">*</span>请上传招标文件</div>
            <div class="item mart0">
                <div class="lab">招标文件</div>
                <div class="value">
                    <label class="btn-file2 padm20" ><input type="file">上传附件</label>
                </div>
            </div>
            <div class="tit6"><span class="red">*</span>请选择投标方需要提交的电子标书</div>

            <div class="item ">
                <div class="lab"></div>
                <div class="value">
                    <p class="checklist">
                        <i class="ico i-check verm <?php if(isset($info) && $info['needBusinessStandard'] == 'YES') echo 'on'?>""></i>
                        <input type="checkbox" name="needBusinessStandard" value="1" class="hide" <?php if(isset($info) && $info['needBusinessStandard'] == 'YES') echo 'checked'?>>
                        资格审查文件电子标书1份
                    </p>
                    <p class="checklist">
                        <i class="ico i-check verm <?php if(isset($info) && $info['needTechnicalStandard'] == 'YES') echo 'on'?>""></i>
                        <input type="checkbox" name="needTechnicalStandard" value="1" class="hide" <?php if(isset($info) && $info['needTechnicalStandard'] == 'YES') echo 'checked'?>>
                        商务标部分电子标书1份
                    </p>
                    <p class="checklist">
                        <i class="ico i-check verm <?php if(isset($info) && $info['needCertificationCheckupFile'] == 'YES') echo 'on'?>""></i>
                        <input type="checkbox" name="needCertificationCheckupFile" value="1" class="hide" <?php if(isset($info) && $info['needCertificationCheckupFile'] == 'YES') echo 'checked'?>>
                        技术标部分电子标书1份
                    </p>
                </div>
            </div>
        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>