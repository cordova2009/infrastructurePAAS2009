<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class=" auto ">
            <div class="content">
                <div class="charge_info">
                    <div class="table">
                        <div class="cell">
                            <div class="txt1 orange fz36"><?=$myCapitalInfo['balance']?>	<span class="fz16">元</span></div>
                            <div class="txt2">账户余额</div>
                        </div>
                        <div class="cell">
                            <div class="txt1"><?=$myCapitalInfo['freezeAmount']?>	<span class="fz16">元</span></div>
                            <div class="txt2 color8">冻结金额</div>
                        </div>
                        <div class="cell">
                            <div class="txt1"><?=$myCapitalInfo['income']?>	 <span class="fz16">元</span></div>
                            <div class="txt2 color8">收入</div>
                        </div>
                        <div class="cell">
                            <div class="txt1"><?=$myCapitalInfo['outlay']?>	 <span class="fz16">元</span></div>
                            <div class="txt2 color8">支出</div>
                        </div>
                    </div>
                    <div class="text-center padt30">
                        <a href="#" class="btn btn-blue">充值</a>
                        <a href="#" class="btn btn-green">提现</a>
                    </div>
                </div>
            </div>
            <div class="content mart20">
                <div class="table charge_table  ">
                    <table>
                        <tr class="bg2 thead">
                            <td class="wid90 ">时间</td>
                            <td class="wid90 text-left">类型明细</td>
                            <td class="wid90 text-right">收入（元）</td>
                            <td class="wid90 text-right">支出（元）</td>
                            <td class="wid90 text-right">结余（元）</td>
                            <td>备注</td>
                        </tr>
                        <tr>
                            <td>2016-5-9</td>
                            <td class="text-left">冻结保证金</td>
                            <td class="text-right">500,000</td>
                            <td class="text-right"></td>
                            <td class="text-right">200,000</td>
                            <td></td>
                        </tr>
                        <tr  class="bg1">
                            <td>2016-5-9</td>
                            <td class="text-left">冻结保证金</td>
                            <td class="text-right">500,000</td>
                            <td class="text-right"></td>
                            <td class="text-right">200,000</td>
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
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(3),#left-menu .submenu:eq(3) a:eq(0)").addClass('active');
})
</script>
</block>