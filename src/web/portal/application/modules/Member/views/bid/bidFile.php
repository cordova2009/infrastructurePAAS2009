<?php
if(check_resp($resp)){
    $info = $resp['result'];
}
?>
<div class="auto  box pad0" id="bidderBond">
    <div class="h2">投标文件</div>
    <div class="padm30">
        <form action="<?=U('/member/bid/submitBid')?>" method="post" class="ajax-form" success="save_success" next_step="last">
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
                    <div class="lab">投标文件</div>
                    <div class="value">
                        <a class="btn-file2 wid110 <?php if(isset($info) && !empty($info['bidFile'])) echo 'hide'?>" href="javascript:">
                            <span>上传附件</span>
                            <input type="file" class="file-upload" name="file">
                            <input type="hidden" name="bidFile" value="">
                        </a>
                        <div class="uploaded <?php if(!isset($info) || empty($info['bidFile'])) echo 'hide'?>">
                            <a target="_blank" href="<?=isset($info)?get_qiniu_file_durl($info['bidFile']):''?>" class="btn-file2 view">下载</a>
                            <a class="btn-file2 bg-grey delete-pic-btn">删除</a>
                        </div>
                    </div>
                </div>

            </div>

            <div class="text-center padv30">
                <button type="submit" class="btn-green2">提交投标申请</button>
                <!--
                &nbsp;
                <button type="button" class="btn-green2">保存并且提交</button>
                -->
            </div>
        </form>
    </div>
</div>
<?php require_once __DIR__.'/../common/upload.file.php';?>