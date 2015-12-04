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
                        <a href="<?=U('/member/capital/rechargeApply')?>" class="btn btn-blue">充值</a>
                        <a href="<?=U('/member/capital/withdrawalsApply')?>" class="btn btn-green">提现</a>
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
                        <?php foreach($list as $item):
                           /* SBZ收 "退还保证金"(解冻)，
                            JBZ交纳保证金(冻结)，
                            CHZ冲正,
                            TX#提现,CZ#充值,FRZ 冻结,UFZ 解冻,SXF 交手续费,TSX 退手续费',*/
                        if($item['type']=='SBZ'){
                            $status="退还撮合担保金";
                        }else if($item['type']=='JBZ'){
                            $status="交纳撮合担保金";
                        }else if($item['type']=='CHZ'){
                            $status="冲正";
                        }else if($item['type']=='TX#'){
                            $status="提现";
                        }else if($item['type']=='CZ#'){
                            $status="充值";
                        }else if($item['type']=='FRZ'){
                            $status="冻结";
                        }else if($item['type']=='UFZ'){
                            $status="解冻";
                        }else if($item['type']=='SXF'){
                            $status="交手续费";
                        }else if($item['type']=='TSX'){
                            $status="退手续费";
                        }
                        ?>
                        <tr  class="bg1">
                            <td><?= date('Y-m-d', strtotime($item['time']))?></td>
                            <td class="text-left"><?=$status?></td>
                            <td class="text-right"><?=$item['income']?>元</td>
                            <td class="text-right"><?=$item['outlay']?>元</td>
                            <td class="text-right"><?=$item['balance']?>元</td>
                            <td><?=$item['remark']?></td>
                        </tr>
                        <?php endforeach; ?>
                    </table>
                </div>
                <?php include(APP_PATH . 'views/common/page.php'); ?>
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