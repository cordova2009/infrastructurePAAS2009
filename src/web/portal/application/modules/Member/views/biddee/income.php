<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class=" auto">
            <div class="content xmManage clear">
                <div class="left panel">
                    <div class="txt1">已付款</div>
                    <div class="txt2"><?=price_format($income['paidAmount'])?><span class="color2 fz16">元</span></div>
                    <div class="txt1">下期应付款</div>
                    <div class="txt2"><?=price_format($income['nextPeriodPayAmount'])?> <span class="color2 fz16">元</span></div>
                </div>
                <div class="left panel">
                    <div class="txt1">应付款</div>
                    <div class="txt2"><?=price_format($income['willPayAmount'])?> <span class="color2 fz16">元</span></div>
                </div>
                <div class="right panel bg-orange">
                    <div class="txt1">项目总数</div>
                    <div class="txt2 orange"><?=$income['objectNum']?></div>
                    <div class="txt1">项目总金额</div>
                    <div class="txt2 orange"><?=price_format($income['allAmount'])?> <span class="color2 fz16">元</span></div>
                </div>
            </div>
            <div class="content mart20">
                <div class="tit4">工程付款列表</div>
                <div class="table  ">
                    <table>
                        <tbody>
                        <tr class="bg2 thead">
                            <td class="wid170 ">工程<br>标的</td>
                            <td class="wid110">合同<br>金额</td>
                            <td class="wid110">已付款<br>金额</td>
                            <td class="wid110">应付款<br>金额</td>
                            <td>下期应付款<br>金额</td>
                            <td class="wid110">下期付款<br>时间</td>
                            <td>操作</td>
                        </tr>
                        <?php foreach($list as $v):?>
                            <tr>
                                <td><?=$v['objectName']?></td>
                                <td><?=price_format($v['winBidAmount'])?>元</td>
                                <td class=""><a href="<?=U('received',['id'=>$v['objectId']])?>" ><span class="blue"><?=price_format($v['paidAmount'])?>元</span></a></td>
                                <td ><a href="<?=U('willreceive',['id'=>$v['objectId']])?>" ><span class="blue"><?=price_format($v['willPayAmount'])?>元</span></a></td>
                                <td><?=price_format($v['nextPeriodPayAmount'])?>元</td>
                                <td><?php echo empty($v['nextPeriodPayTime'])?'':str_replace('08:00:00','',$v['nextPeriodPayTime']) ;?></td>
                                <td>
                                    <?php if($v['status']!='CRT'){?>
                                        <a href="<?=U('payment',['id'=>$v['objectId'],'nextPeriod'=>$v['nextPeriod'],'objectName'=>$v['objectName']])?>" class="btn-blue bg-orange2">付款</a>
                                    <?php }else{?>
                                        <a href="#" class="btn-blue bg-grey">待审核</a>
                                    <?php }?>
                                </td>
                            </tr>
                        <?php endforeach;?>
                        <?php if(empty($list)):?>
                            <tr><td colspan="5">暂无数据</td></tr>
                        <?php endif;?>
                        </tbody></table>
                </div>
                <?php include(APP_PATH.'views/common/page.php'); ?>

            </div>
        </div>
    </div>
</div>
<block name="script">
    <script>
        $(function(){
            $("#left-menu .submenu:eq(1),#left-menu .submenu:eq(1) a:eq(2)").addClass('active');
            $(".tblistTbale tr:odd").addClass('bg1');
        })
    </script>
</block>
