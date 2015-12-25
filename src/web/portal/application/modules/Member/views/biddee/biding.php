<table>
    <tbody><tr class="bg2 thead">
        <td class="wid90">工程类别</td>
        <td class="wid170">项目名称</td>
        <td class="wid120">估价</td>
        <td class="wid100">计划开工时间</td>
        <td class="wid100">工期</td>
        <td class="wid100">投标截止时间</td>
        <td class="">操作</td>
    </tr>
    <?php  if(!empty($biding)){ foreach($biding as $v){?>
        <tr class="">
            <td class=""><span class="tag"><?=isset($industry[$v['industryId']])?$industry[$v['industryId']]['industryIcon']:''?></span></td>
            <td class="blue  "><a class="blue" href="<?=U('/project/detail',['objectId'=>$v['objectId']])?>"><?=$v['objectName']?><br>(<?=$v['objectId']?>)</a></td>
            <td class=""><?=price_format($v['evaluationAmount'])?></td>
            <td class=""><?=$v['projectExpectStartDate']?></td>
            <td class=""><?=$v['projectExpectPeriod']?>天</td>
            <td class=""><?=str_replace('00:00:00.0','',$v['biddingEndTime'])?></td>
            <td class="">
                <?php if($v['objectStatus'] == 'REV'):?>
                <a href="<?=U('survey',['id'=>$v['objectId']])?>" class="btn-green">评标</a>
                <?php else:?>
                <button type="button" disabled class="btn-green">评标</button>
                <?php endif;?>
            </td>
        </tr>
    <?php }}else{?>
        <tr><td colspan="7">暂无数据</td></tr>
    <?php }?>
    </tbody></table>
<?php include(APP_PATH.'views/common/page.php'); ?>
