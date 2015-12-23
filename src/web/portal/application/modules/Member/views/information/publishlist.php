<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3">已发布信息</div>
            <div class="table charge_table">
                <table>
                    <tr class="bg2 thead">
                        <td class="wid90 ">项目名称</td>
                        <td class="wid90 text-right">工程阶段</td>
                        <td class="wid90 text-left">工程类别</td>
                        <td class="wid90 text-left">地区</td>
                        <td class="wid90">参与数</td>
                        <td>详情</td>
                    </tr>
                    <?php foreach($list as $item): ?>
                    <tr>
                       <!-- {
                            "status":"OK#",
                            "informationId":1,
                            "objectAmount":"3000万",
                            "district":"广州市",
                            "objectName":"项目名称",
                            "objectType":"项目类别",
                            "employer":"甲方xxxxxx",
                            "phase":"招标阶段",
                            "projectPeriod":"半年",
                            "projectSituation":"本项目主要是xxxx",
                            "address":"xx路666号",
                            "userName":"用户名",
                            "partNumber":20
                        }-->
                        <td><?=$item['objectName']?></td>
                        <td class="text-right"><?=$item['phase']?></td>
                        <td class="text-left"><?=objectType?></td>
                        <td class="text-left"><?=district?></td>
                        <td><?=$item['partNumber']?></td>
                        <td class="info"><a href="<?=U('/member/Information/publishDetail',['informationId'=>$item['informationId']])?>"><i class="ico i-eye"></i></a></td>
                    </tr>
                    <?php endforeach; ?>
                    <?php if(empty($list)):?>
                    <tr><td colspan="6">暂无数据</td></tr>
                    <?php endif;?>
                </table>
            </div>
            <?php include(APP_PATH . 'views/common/page.php'); ?>
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(4),#left-menu .submenu:eq(4) a:eq(1)").addClass('active');
})
</script>
</block>