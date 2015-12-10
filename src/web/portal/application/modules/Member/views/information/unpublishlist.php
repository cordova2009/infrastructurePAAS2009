<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3">待发布信息</div>
            <div class="table charge_table">
                <table>
                    <tr class="bg2 thead">
                        <td class="wid100 text-center">项目名称</td>
                        <td class="wid70 text-center">工程阶段</td>
                        <td class="wid70 text-center">工程类别</td>
                        <td class="wid70 text-center">地区</td>
                        <td class="wid70 text-center">参与数</td>
                        <td>详情</td>
                        <td>操作</td>
                    </tr>
                    <?php foreach($list as $item): ?>
                    <tr>
                        <td class="text-center"><?=isset($item['objectName'])?$item['objectName']:'无'?></td>
                        <td class="text-center"><?=isset($item['phase'])?$item['phase']:'无'?></td>
                        <td class="text-center"><?=isset($item['objectType'])?$item['objectType']:'无'?></td>
                        <td class="text-center"><?=isset($item['district'])?$item['district']:'无'?></td>
                        <td class="text-center"><?=isset($item['partNumber'])?$item['partNumber']:'0'?></td>
                        <td class="text-center"><a href="<?=U('/member/Information/publishDetail',['informationId'=>$item['informationId']])?>"><i class="ico i-eye"></i></a></td>
                        <td><a href="<?=U('/member/Information/index',['informationId'=>$item['informationId']])?>" class="toubiao">修改</a></td>
                    </tr>
                    <?php endforeach; ?>
                </table>
            </div>
            <?php include(APP_PATH . 'views/common/page.php'); ?>
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(4),#left-menu .submenu:eq(4) a:eq(2)").addClass('active');
})
</script>
</block>