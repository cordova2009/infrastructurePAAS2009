<?php
if(check_resp($resp)){
    $info = $resp['ConstructionInfo'];
}
?>
<div class="auto box pad0" id="constructionInfo">
    <div class="h2">工程施工证明 <span class="fz16 color9">(1、2、3任选一种)</span></div>

    <div class="zhengming">
        <form action="<?=U('/member/tender/saveConstructionInfo')?>" method="post" class="ajax-form" success="save_success" next_step="requirementInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="tit7 mart30 ">
            <span class="blue">1</span>
            <span class="checklist">
                <i class="ico i-check radio <?php if(isset($info) && $info['constructionProveType'] == 'ZCB') echo 'on'?>"></i>
                <input name="constructionProveType" type="radio" class="hide" value="ZCB" <?php if(isset($info) && $info['constructionProveType'] == 'ZCB') echo 'checked'?>>
            </span> (建议承包商选择)
        </div>
        <ul class="clear">
            <li>
                <div class="cell lab">
                    <span class="red">*</span> 国有土地使用证
                </div>
                <div class="cell padl20">
                    <input type="text" class="input1 " placeholder="编号" name="landUseCertificateNo[ZCB]" value="<?=isset($info)?$info['landUseCertificateNo']:''?>">
                    <input type="text" class="input1 datepicker" placeholder="有效期" name="landUseCertificateEndDate[ZCB]" value="<?=isset($info)?$info['landUseCertificateEndDate']:''?>">
                </div>
                <div class="cell padr40">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="landUseCertificateUrl[ZCB]" value="<?=isset($info)?$info['letterOfAcceptanceUrl']:''?>">
                    </a>
                </div>
            </li>
            <li>
                <div class="cell lab">
                    <span class="blue">a</span> 建设用地规划许可证
                </div>
                <div class="cell padl20">
                    <input type="text" class="input1 " placeholder="编号" name="constructionLandUsePermitNo[ZCB]" value="<?=isset($info)?$info['constructionLandUsePermitNo']:''?>">
                    <input type="text" class="input1 datepicker" placeholder="有效期" name="constructionLandUsePermitEndDate[ZCB]" value="<?=isset($info)?$info['constructionLandUsePermitEndDate']:''?>">
                </div>
                <div class="cell padr40">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="constructionLandUsePermitUrl[ZCB]" value="<?=isset($info)?$info['constructionLandUsePermitUrl']:''?>">
                    </a>
                </div>
            </li>
            <li>
                <div class="cell lab">
                    <span class="blue">b</span> 建设工程规划许可证
                </div>
                <div class="cell padl20">
                    <input type="text" class="input1 " placeholder="编号" name="buildingPermitNo[ZCB]" value="<?=isset($info)?$info['buildingPermitNo']:''?>">
                    <input type="text" class="input1 datepicker" placeholder="有效期" name="buildingPermitEndDate[ZCB]" value="<?=isset($info)?$info['buildingPermitEndDate']:''?>">
                </div>
                <div class="cell padr40">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="buildingPermitUrl[ZCB]" value="<?=isset($info)?$info['buildingPermitUrl']:''?>">
                    </a>
                </div>
            </li>
            <li>
                <div class="cell lab"></div>
                <div class="cell orange">
                    <span class="red">*</span> <span class="padl10">a / b，选填一项</span>
                </div>
            </li>
            <li>
                <div class="cell lab padr20">
                    <span class="red">*</span> 中标通知书
                </div>
                <div class="cell ">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="letterOfAcceptanceUrl" value="<?=isset($info)?$info['letterOfAcceptanceUrl']:''?>">
                    </a>
                </div>
                <div class="cell ">
                    <p class="red">
                        如果国有土地使用证中使用单位与招标人不一致，<br>
                        请务必提交中标通知书，保证招标可信度。<br>
                        如果不一致，导致投诉，我们保留追究招标人的法律权利。
                    </p>
                </div>
            </li>
        </ul>

        <div class="tit7 mart30 ">
            <span class="blue">2</span>
            <span class="checklist">
                <i class="ico i-check radio <?php if(isset($info) && $info['constructionProveType'] == 'KFS') echo 'on'?>"></i>
                <input name="constructionProveType" type="radio" class="hide" value="KFS" <?php if(isset($info) && $info['constructionProveType'] == 'KFS') echo 'checked'?>>
            </span> (建议开发商选择)
        </div>
        <ul class="clear">
            <li>
                <div class="cell lab">
                    <span class="red">*</span> 国有土地使用证
                </div>
                <div class="cell padl20">
                    <input type="text" class="input1 " placeholder="编号" name="landUseCertificateNo[KFS]" value="<?=isset($info)?$info['landUseCertificateNo']:''?>">
                    <input type="text" class="input1 datepicker" placeholder="有效期" name="landUseCertificateEndDate[KFS]" value="<?=isset($info)?$info['landUseCertificateEndDate']:''?>">
                </div>
                <div class="cell padr40">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="landUseCertificateUrl[KFS]" value="<?=isset($info)?$info['landUseCertificateUrl']:''?>">
                    </a>
                </div>
            </li>
            <li>
                <div class="cell lab">
                    <span class="blue">a</span> 建设用地规划许可证
                </div>
                <div class="cell padl20">
                    <input type="text" class="input1 " placeholder="编号" name="constructionLandUsePermitNo[KFS]" value="<?=isset($info)?$info['constructionLandUsePermitNo']:''?>">
                    <input type="text" class="input1 datepicker" placeholder="有效期" name="constructionLandUsePermitEndDate[KFS]" value="<?=isset($info)?$info['constructionLandUsePermitEndDate']:''?>">
                </div>
                <div class="cell padr40">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="constructionLandUsePermitUrl[KFS]" value="<?=isset($info)?$info['constructionLandUsePermitUrl']:''?>">
                    </a>
                </div>
            </li>
            <li>
                <div class="cell lab">
                    <span class="blue">b</span> 建设工程规划许可证
                </div>
                <div class="cell padl20">
                    <input type="text" class="input1 " placeholder="编号" name="buildingPermitNo[KFS]" value="<?=isset($info)?$info['buildingPermitNo']:''?>">
                    <input type="text" class="input1 datepicker" placeholder="有效期" name="buildingPermitEndDate[KFS]" value="<?=isset($info)?$info['buildingPermitEndDate']:''?>">
                </div>
                <div class="cell padr40">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="buildingPermitUrl[KFS]" value="<?=isset($info)?$info['buildingPermitUrl']:''?>">
                    </a>
                </div>
            </li>
            <li>
                <div class="cell lab"></div>
                <div class="cell orange">
                    <span class="red">*</span> <span class="padl10">a / b，选填一项</span>
                </div>
            </li>
        </ul>

        <div class="tit7 mart30 ">
            <span class="blue">3</span>
            <span class="checklist">
                <i class="ico i-check radio <?php if(isset($info) && $info['constructionProveType'] == 'BCP') echo 'on'?>"></i>
                <input name="constructionProveType" type="radio" class="hide" value="BCP" <?php if(isset($info) && $info['constructionProveType'] == 'BCP') echo 'checked'?>>
            </span> (建议承包商选择)
        </div>
        <ul class="clear">
            <li>
                <div class="cell lab">
                    <span class="red">*</span> 建设工程施工许可证
                </div>
                <div class="cell padl20">
                    <input type="text" class="input1 " placeholder="编号" name="buildingConstructPermitNo" value="<?=isset($info)?$info['buildingConstructPermitNo']:''?>">
                    <input type="text" class="input1 datepicker" placeholder="有效期" name="buildingConstructPermitEndDate" value="<?=isset($info)?$info['buildingConstructPermitEndDate']:''?>">
                </div>
                <div class="cell padr40">
                    <a href="javascript:" class="btn-file2">
                        <input type="file" name="file" class="file-upload"> 上传附件
                        <input type="hidden" name="buildingConstructPermitUrl" value="<?=isset($info)?$info['buildingConstructPermitUrl']:''?>">
                    </a>
                </div>
            </li>

        </ul>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>
    </div>
</div>
<script>
$(".file-upload").fileupload({
    url:'<?=U('/member/upload/picture')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
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