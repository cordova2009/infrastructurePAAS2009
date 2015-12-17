<?php
if(check_resp($resp)){
    $info = $resp['projectInfo'];
}
?>
<div class="auto  box pad0" id="projectInfo">
    <div class="h2">工程基本信息</div>
    <div class="padm30">
        <form action="<?=U('/member/tender/saveProjectInfo')?>" method="post" class="ajax-form" success="save_success" next_step="constructionInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />

        <div class="gcjbxx">

            <div class="item ">
                <div class="lab">工程类别</div>
                <div class="value">
                    <div class="select">
                        <select name="industryId">
                            <?php foreach($industryList as $item):?>
                                <option value="<?=$item['industryId']?>" <?php if(isset($info) && $info['industryId'] == $item['industryId']) echo 'selected'?>><?=$item['industryName']?></option>
                            <?php endforeach;?>
                        </select>
                    </div>
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>工程名称</div>
                <div class="value">
                    <input type="text" class="input1" placeholder="" name="projectName" value="<?=isset($info)?$info['projectName']:''?>">
                    <i class="ico tip-qus"></i>
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>工程地点</div>
                <div class="value">
                    <input type="text" class="input1 " placeholder="详细地址" name="projectSite" value="<?=isset($info)?$info['projectSite']:''?>">
                </div>
            </div>

            <div class="item ">
                <div class="lab"><span class="red">*</span>工程规模及特征</div>
                <div class="value">
                    <textarea name="projectScale" id="" class="textarea2" placeholder=""><?=isset($info)?$info['projectScale']:''?></textarea>
                </div>
            </div>

            <div class="item ">
                <div class="lab">建设单位</div>
                <div class="value">
                    <input type="text" class="input1 " placeholder="" name="employer" value="<?=isset($info)?$info['employer']:''?>">
                </div>
            </div>

            <div class="item ">
                <div class="lab">建设单位经办人</div>
                <div class="value">
                    <input type="text" class="input1 " placeholder="" name="employerPrincipal" value="<?=isset($info)?$info['employerPrincipal']:''?>">
                </div>
            </div>

            <div class="item ">
                <div class="lab">建设单位办公电话</div>
                <div class="value">
                    <input type="text" class="input1 " placeholder="" name="employerTelephone" value="<?=isset($info)?$info['employerTelephone']:''?>">
                </div>
            </div>

        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>