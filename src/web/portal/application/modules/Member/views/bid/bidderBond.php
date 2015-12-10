<?php
//if(check_resp($resp)){
//    $info = $resp['technicalStandardInfo'];
//}
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
                        <a class="btn-file2 wid110" href="javascript:">
                            <input type="file" class="file-upload" name="file"> 上传附件
                            <input type="hidden" name="bidFile" value="">
                        </a>
                    </div>
                </div>

            </div>

            <div class="text-center padv30">
                <button type="submit" class="btn-green2">提交投标申请</button>
            </div>
        </form>
    </div>
</div>
<script>
$(".file-upload").fileupload({
    url:'<?=U('/member/upload/file')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
    dataType: 'json',
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