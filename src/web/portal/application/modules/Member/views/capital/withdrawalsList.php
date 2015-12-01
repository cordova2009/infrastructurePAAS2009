<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3">提现记录</div>
            <div class="table charge_table getout_table">
                <table>
                    <tr class="bg2 thead">
                        <td class="wid90 ">提现申请日期</td>
                        <td class="wid90 text-right">申请提现金额</td>
                        <td class="wid90 text-right">提现手续费</td>
                        <td class="wid90 ">状态</td>
                        <td class="wid90 text-left">转账日期</td>
                        <td class="wid90">转账凭证号</td>
                        <td>备注</td>
                    </tr>

                    <tr>
                        <td>2016-5-9</td>
                        <td class="text-right">50,000元</td>
                        <td class="text-right">50元</td>
                        <td class="">已通过审核<br>未转账</td>
                        <td class="text-left">2016-5-6</td>
                        <td>102302456</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2016-5-9</td>
                        <td class="text-right">50,000元</td>
                        <td class="text-right">50元</td>
                        <td class="">申请中待确认</td>
                        <td class="text-left">2016-5-6</td>
                        <td>102302456</td>
                        <td></td>
                    </tr>

                </table>
            </div>
            <div class="page">
                <a class="disabled">上一页</a>
                <a href="#" class="active">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">下一页</a>
            </div>
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(3),#left-menu .submenu:eq(3) a:eq(4)").addClass('active');
})
</script>
</block>