<?php
if(check_resp($resp)){
    $info = $resp['technicalStandardInfo'];
}
?>
<div class="auto  box pad0" id="technicalStandard">
    <div class="h2">技术标</div>
    <div class="padm30">
        <form action="<?=U('/member/bid/saveTechnicalStandard')?>" method="post" class="ajax-form" success="save_success" next_step="makeMatchBidderBond">
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
                        <a class="btn-file2 wid110 <?php if(isset($info) && !empty($info['technicalStandardUrl'])) echo 'hide'?>" href="javascript:">
                            <span>上传附件</span>
                            <input type="file" class="file-upload" name="file">
                            <input type="hidden" name="technicalStandardUrl" value="<?=isset($info) ? $info['technicalStandardUrl'] : ''?>">
                        </a>
                        <div class="uploaded <?php if(!isset($info) || empty($info['technicalStandardUrl'])) echo 'hide'?>">
                            <a target="_blank" href="<?=isset($info)?imageView2($info['technicalStandardUrl']):''?>" class="btn-file2 view">查看</a>
                            <a class="btn-file2 bg-grey delete-pic-btn">删除</a>
                        </div>
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
                <button type="submit" class="btn-green2">保存并继续</button>
            </div>
        </form>
    </div>
</div>
<?php require_once __DIR__.'/../common/upload.pic.php';?>