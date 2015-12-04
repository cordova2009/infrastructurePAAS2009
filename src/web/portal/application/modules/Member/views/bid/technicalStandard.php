<?php
if(check_resp($resp)){
    $info = $resp['technicalStandardInfo'];
}
?>
<div class="auto  box pad0">
    <div class="h2">商务标</div>
    <div class="padm30">
        <form action="<?=U('/member/bid/saveTechnicalStandard')?>" method="post" class="ajax-form" success="save_success" next_step="dateRequirementInfo">
            <input name="objectId" value="<?=$objectId?>" type="hidden" />
            <input name="bidId" value="<?=$bidId?>" type="hidden" />
        <div class="shangwubiao">
            <div class="clear">
                <i class="ico i-info left marr10"></i>
                <div class="auto orange">
                    技术标附件包括技术方案、产品技术资料、施工方案、施工计划、施工质量保证措施等等，具体请下载招标文件，严格按照招标文件要求完成技术标。
                </div>
            </div>

            <div class="item">
                <div class="lab">技术标书</div>
                <div class="value">
                    <label class="btn-file2 wid110 "> 上传附件<input type="file" name="technicalStandardUrl"></label>
                </div>
            </div>

        </div>

        <div class="charge_tips2">
            <p><i class="ico i-tips"></i> 温馨提示</p>
            <p>1.上传的技术标文件，我们严格保证文件的安全，提交后，在开标前将禁止任何人访问和获取。</p>
            <p>2.只有在招标人开标的时候才能被招标人打开，确保评标的公正和公平。 </p>
            <p>3.技术标正式提交后，就不能再次修改，对于保存的技术标可以随时进行修改。</p>
            <p>4.投标信息必须在投标截止日期前正式提交，逾期后无法提交。</p>
        </div>

        <div class="text-center padv30">
            <a href="#" class="btn-green2 ">保存并继续</a>
        </div>
        </form>
    </div>
</div>