<?php
if(check_resp($resp)){
    $info = $resp['businessStandardInfo'];
}
?>
<div class="auto  box pad0">
    <div class="h2">商务标</div>
    <div class="padm30">
        <form action="<?=U('/member/bid/saveBusinessStandard')?>" method="post" class="ajax-form" success="save_success" next_step="dateRequirementInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <input name="bidId" value="<?=$bidId?>" type="hidden" />
        <div class="shangwubiao">
            <div class="clear">
                <i class="ico i-info left marr10"></i>
                <div class="auto orange">
                    商务标标附件包括法定代表人身份证明、法人授权委托书、投标函、报价表、企业营业执照、
                    资质证书，以及安全生产证明等，具体请下载招标文件，严格按照招标文件要求完成商务标。
                </div>
            </div>

            <div class="item">
                <div class="lab">项目报价</div>
                <div class="value">
					<span class="yuanbox">
					<span class="yuan">元</span>
					<input type="text" class="input1 " placeholder="" name="bidAmount" value="<?=isset($info)?price_format($info['bidAmount']):''?>">
					</span>
                </div>
            </div>

            <div class="item">
                <div class="lab">施工日期</div>
                <div class="value">
                    <input type="text" class="input1 datepicker" placeholder="" name="constructionStartDate" vaule="<?=isset($info)?$info['constructionStartDate']:''?>">
                    到
                    <input type="text" class="input1 datepicker" placeholder="" name="constructionEndDate" value="<?=isset($info)?$info['constructionEndDate']:''?>">
                </div>
            </div>

            <div class="item">
                <div class="lab">商务标书</div>
                <div class="value">
                    <label class="btn-file2 wid110 "> 上传文件<input type="file" name="constructionCommitmentUrl"  ></label>
                </div>
            </div>

        </div>

        <div class="charge_tips2">
            <p><i class="ico i-tips"></i> 温馨提示</p>
            <p>1.上传的商务标文件，我们严格保证文件的安全，提交后，在开标前将禁止任何人访问和获取。</p>
            <p>2.只有在招标人开标的时候才能被招标人打开，确保评标的公正和公平。 </p>
            <p>3.商务标正式提交后，就不能再次修改，对于保存的商务标可以随时进行修改。</p>
            <p>4.投标信息必须在投标截止日期前正式提交，逾期后无法提交。</p>
        </div>

        <div class="text-center padv30">
            <a href="#" class="btn-green2">保存并继续</a>
        </div>
        </form>
    </div>
</div>