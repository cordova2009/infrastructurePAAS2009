<?php
if(check_resp($resp)){
    $info = $resp['certificationInfo'];
}
?>
<div class="auto  box pad0">
    <div class="h2">资质要求</div>
    <div class="padm40">
        <form action="<?=U('/member/tender/saveCertificationInfo')?>" method="post" class="ajax-form" success="save_success" next_step="bondInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="clear padv40 tit9">
            <div class="left">
                <span class="red marr10">*</span> 投标人资质等级最低要求
            </div>
            <div class="right">
                <a href="#" class="btn">添加</a>
                <a href="#" class="btn-grey marl10">删除</a>
            </div>
        </div>

        <div class="table charge_table  ">
            <table>
                <tr class="bg2 thead">
                    <td class="wid70 "></td>
                    <td class="wid150">工程类别</td>
                    <td>资质名称</td>
                </tr>
                <?php
                foreach($certificateList as $industry):
                    foreach($industry['certificateList'] as $item):
                ?>

                <tr>
                    <td class="checklist">
                        <i class="ico i-check"></i>
                        <input type="checkbox" name="industry[]" value="<?=$industry['industryId']?>" class="">
                        <input type="checkbox" name="certificate[]" value="<?=$item['certificateId']?>" class="">
                    </td>
                    <td class=""><?=$industry['industryName']?></td>
                    <td class=""><?=$item['certificateName']?></td>
                </tr>
                <?php
                    endforeach;
                endforeach;
                ?>
            </table>
        </div>

        <div class="text-center padv20">
            <a href="#" class="btn">确  定</a>
        </div>

        <div class="tit10"><span>请选择投标方需要提供的资料</span></div>

        <div class="zhengshu checklist ziliao">
            <p class="txt">投标人主要人员资质</p>
            <ul class="clear">
                <li>
                    <i class="ico i-check"></i>
                    <input type="checkbox" name="needPmCertification" value="YES" class="">
                    需要投标人项目经理证
                </li>
                <li>
                    <i class="ico i-check"></i>
                    <input type="checkbox" name="needConstructorCertification" value="YES" class="">
                    需要投标人建造师证
                </li>
            </ul>
            <p class="txt">投标人安全生产证明</p>
            <ul class="clear">
                <li>
                    <i class="ico i-check"></i>
                    <input type="checkbox" name="needSafetyPermit" value="YES" class="">
                    需要安全生产许可证明
                </li>
                <li>
                    <i class="ico i-check"></i>
                    <input type="checkbox" name="needPmSafetyCertification" value="YES" class="">
                    需要项目经理安全生产考核合格证明
                </li>
            </ul>
        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>