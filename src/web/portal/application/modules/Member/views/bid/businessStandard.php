<?php
if(check_resp($resp)){
    $info = $resp['businessStandardInfo'];
}
?>
<div class="auto  box pad0" id="businessStandard">
    <div class="h2">商务标</div>
    <div class="padm30">
        <form action="<?=U('/member/bid/saveBusinessStandard')?>" method="post" class="ajax-form" success="save_success" next_step="technicalStandard">
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
                    <div class="lab"><span class="red">*</span> 项目报价</div>
                    <div class="value">
                        <span class="yuanbox">
                        <span class="yuan">元</span>
                        <input type="text" class="input1 price_format" placeholder="" name="bidAmount" value="<?=isset($info)?price_convert($info['bidAmount']):''?>">
                        </span>
                    </div>
                </div>

                <div class="item">
                    <div class="lab"><span class="red">*</span> 项目报价表</div>
                    <div class="value">
                        <a class="btn-file2 wid110 <?php if(isset($info) && !empty($info['projectQuotationUrl'])) echo 'hide'?>" href="javascript:">
                            <span>上传附件</span>
                            <input type="file" class="file-upload" name="file">
                            <input type="hidden" name="projectQuotationUrl" value="<?=isset($info) ? $info['projectQuotationUrl'] : ''?>">
                        </a>

                        <div class="uploaded <?php if(!isset($info) || empty($info['projectQuotationUrl'])) echo 'hide'?>">
                            <a target="_blank" href="<?=isset($info)?get_qiniu_file_durl($info['projectQuotationUrl']):''?>" class="btn-file2 view">下载</a>
                            <a class="btn-file2 bg-grey delete-pic-btn">删除</a>
                        </div>
                    </div>
                </div>

                <div class="item">
                    <div class="lab"><span class="red">*</span> 施工日期</div>
                    <div class="value">
                        <input type="text" class="input1 datepicker" placeholder="" name="constructionStartDate" value="<?=isset($info)?$info['constructionStartDate']:''?>">
                        到
                        <input type="text" class="input1 datepicker" placeholder="" name="constructionEndDate" value="<?=isset($info)?$info['constructionEndDate']:''?>">
                    </div>
                </div>

                <div class="item">
                    <div class="lab"><span class="red">*</span> 商务标书</div>
                    <div class="value">
                        <a class="btn-file2 wid110 <?php if(isset($info) && !empty($info['constructionCommitmentUrl'])) echo 'hide'?>" href="javascript:">
                            <span>上传附件</span>
                            <input type="file" class="file-upload" name="file">
                            <input type="hidden" name="constructionCommitmentUrl" value="<?=isset($info) ? $info['constructionCommitmentUrl'] : ''?>">
                        </a>
                        <div class="uploaded <?php if(!isset($info) || empty($info['constructionCommitmentUrl'])) echo 'hide'?>">
                            <a target="_blank" href="<?=isset($info)?get_qiniu_file_durl($info['constructionCommitmentUrl']):''?>" class="btn-file2 view">下载</a>
                            <a class="btn-file2 bg-grey delete-pic-btn">删除</a>
                        </div>
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
                <button type="submit" class="btn-green2">保存并继续</button>
            </div>
        </form>
    </div>
</div>
<?php require_once __DIR__.'/../common/upload.file.php';?>