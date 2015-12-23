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
                            <div class="txt1 orange"><span class="fz36"><?=price_format($myCapitalInfo['balance'])?></span> <span class="fz16">元</span></div>
                            <div class="txt2">账户余额</div>
                        </div>
                        <div class="cell">
                            <div class="txt1"><span><?=price_format($myCapitalInfo['freezeAmount'])?></span> <span class="fz16">元</span></div>
                            <div class="txt2 color8">冻结金额</div>
                        </div>
                        <div class="cell">
                            <div class="txt1"><span><?=price_format($myCapitalInfo['income'])?></span> <span class="fz16">元</span></div>
                            <div class="txt2 color8">收入</div>
                        </div>
                        <div class="cell">
                            <div class="txt1"><span><?=price_format($myCapitalInfo['outlay'])?></span> <span class="fz16">元</span></div>
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
                        <?php
                        $status_list = [
                            'SBZ'=>'退还撮合担保金',
                            'JBZ'=>'冻结撮合担保金',
                            'PBJ'=>'交纳撮合担保金',
                            'CHZ'=>'冲正',
                            'TX#'=>'提现',
                            'CZ#'=>'充值',
                            'FRZ'=>'冻结',
                            'UFZ'=>'解冻',
                            'SXF'=>'交手续费',
                            'TSX'=>'退手续费',
                        ];
                        ?>
                        <?php foreach($list as $item):?>
                        <tr  class="bg1">
                            <td><?= date('Y-m-d', strtotime($item['time']))?></td>
                            <td class="text-left"><?=(isset($status_list[$item['type']])? $status_list[$item['type']] :'')?></td>
                            <td class="text-right"><?=price_format($item['income'])?>元</td>
                            <td class="text-right"><?=price_format($item['outlay'])?>元</td>
                            <td class="text-right"><?=price_format($item['balance'])?>元</td>
                            <td><?=$item['remark']?></td>
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
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(3),#left-menu .submenu:eq(3) a:eq(0)").addClass('active');
})
</script>
</block>