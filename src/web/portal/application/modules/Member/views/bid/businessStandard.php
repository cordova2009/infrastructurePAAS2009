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
                    <div class="lab">项目报价</div>
                    <div class="value">
                        <span class="yuanbox">
                        <span class="yuan">元</span>
                        <input type="text" class="input1 price_format" placeholder="" name="bidAmount" value="<?=isset($info)?price_format($info['bidAmount']):''?>">
                        </span>
                    </div>
                </div>

                <div class="item">
                    <div class="lab">项目报价表</div>
                    <div class="value">
                        <a class="btn-file2 wid110" href="javascript:">
                            <input type="file" class="file-upload" name="file"> 上传附件
                            <input type="hidden" name="projectQuotationUrl" value="<?=isset($info) ? $info['projectQuotationUrl'] : ''?>">
                        </a>
                    </div>
                </div>

                <div class="item">
                    <div class="lab">施工日期</div>
                    <div class="value">
                        <input type="text" class="input1 datepicker" placeholder="" name="constructionStartDate" value="<?=isset($info)?$info['constructionStartDate']:''?>">
                        到
                        <input type="text" class="input1 datepicker" placeholder="" name="constructionEndDate" value="<?=isset($info)?$info['constructionEndDate']:''?>">
                    </div>
                </div>

                <div class="item">
                    <div class="lab">商务标书</div>
                    <div class="value">
                        <a class="btn-file2 wid110" href="javascript:">
                            <input type="file" class="file-upload" name="file"> 上传附件
                            <input type="hidden" name="constructionCommitmentUrl" value="<?=isset($info) ? $info['constructionCommitmentUrl'] : ''?>">
                        </a>
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
<script>
$(".file-upload").fileupload({
    url:'<?=U('/member/upload/file')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
    done:function(e,data){
        //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
        //返回的数据在data.result中，假设我们服务器返回了一个json对象
        if(data.result.status == '0'){
            $(this).next().val(data.result.url);
        }else{
            layer.alert(data.result.msg,{icon:2});
        }
    }
})
</script>