<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3">充值记录</div>
            <div class="table charge_table">
                <table>
                    <tr class="bg2 thead">
                        <td class="wid90 ">充值申请日期</td>
                        <td class="wid90 text-right">充值金额</td>
                        <td class="wid90 text-left">状态</td>
                        <td class="wid90 text-left">转账日期</td>
                        <td class="wid90">转账凭证号</td>
                        <td>备注</td>
                    </tr>
                    <?php foreach($list as $item):
                        if($item['status']=='CRT'){
                            $status="申请中待确认";
                        }else if($item['status']=='OK#'){
                            $status="充值成功！";
                        }else if($item['status']=='FLS'){
                            $status="充值失败！";
                        }
                        ?>
                    <tr>
                        <td><?=$item['createTime']?></td>
                        <td class="text-right"><?=price_format($item['amount'])?>元</td>
                        <td class="text-left"><?=$status?></td>
                        <td class="text-left"><?= date('Y-m-d', strtotime($item['rechargeTime'])) ?></td>
                        <td><?=$item['voucherNo']?></td>
                        <td><?=$item['remark']?></td>
                    </tr>
                    <?php endforeach; ?>
                </table>
            </div>
            <!--<div class="page">
                <a class="disabled">上一页</a>
                <a href="#" class="active">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">下一页</a>
            </div>-->
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(3),#left-menu .submenu:eq(3) a:eq(2)").addClass('active');
})
</script>
</block>