<?php
if(check_resp($resp)){
    $info = $resp['bidFileTypeInfo'];
}
?>
<div class="auto box pad0" id="bidFileTypeInfo">
    <div class="h2">招投标文件要求</div>
    <div class="padm30">
        <form action="<?=U('/member/tender/saveBidFileTypeInfo')?>" method="post" class="ajax-form" success="save_success" next_step="answerMethodInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="shangwubiao fz16">
            <div class="tit6"><span class="red">*</span>请上传招标文件</div>
            <div class="item mart0 text-center">
                <div class=" <?=(empty($info['tenderFile']) ? '' : 'hide')?>" id="upload-tender-file">
                    <span>招标文件</span>
                    <label class="btn-file2 padm20" >
                        <span>上传附件</span>
                        <input class="file-upload" type="file" name="file">
                        <input type="hidden" name="tenderFile" value="<?=isset($info)?$info['tenderFile']:''?>">
                    </label>
                </div>
                <div class="<?=(empty($info['tenderFile']) ? 'hide' : '')?>" id="uploaded">
                    <input type="text" value="<?=isset($info)?$info['tenderFile']:''?>" class="input1 wid220">
                    <a id="download-tender-file" class="btn-file2 padm20" href="<?=isset($info)?get_qiniu_file_durl($info['tenderFile']):''?>" target="_blank">下载</a>
                    <a class="btn-file2 padm20 bg-grey" id="delete-tender-file">删除</a>
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
<script>
    $(".file-upload").fileupload({
        url:'<?=U('/member/upload/file')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
        dataType: 'json',
        add: function (e, data) {
            if (e.isDefaultPrevented()) {
                return false;
            }
            $(this)
                .prev()
                .text('上传中..')
                .parent()
                .css('background','#bebebe');
            data.submit();
        },
        done:function(e,data){
            //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
            //返回的数据在data.result中，假设我们服务器返回了一个json对象
            $(this).prev()
                .text('上传附件')
                .parent()
                .css('background','#8ab46e');
            if(data.result.status == '0'){
                $(this).next().val(data.result.url);
                $("#uploaded").removeClass('hide').prev().addClass('hide');
                $("#download-tender-file").attr('href',data.result.src).prev().val(data.result.url);
            }else{
                layer.alert(data.result.msg,{icon:2});
            }
        },
        fail: function () {
            $(this).parent().css('background','#8ab46e');
            layer.alert('上传失败，请重新再试',{icon:2});
        }
    })
    $("#delete-tender-file").click(function () {
        $("#uploaded").addClass('hide');
        $("input[name=tenderFile]").val('');
        $("#upload-tender-file").removeClass('hide');
    })
</script>