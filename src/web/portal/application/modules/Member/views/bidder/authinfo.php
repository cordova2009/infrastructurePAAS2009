<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class=" auto">
            <div class="box">
                <div class="table text-center">
                    <div class="cell">
                        信用等级
                        <span class="tag2 marl20">
                            <?=$overall['creditRating']?>
                        </span>
                    </div>
                    <div class="cell">
                        信用积分
                        <span class="fz26 marl20">
                            <?=intval($overall['creditScore']);?>
                        </span>
                    </div>
                </div>
            </div>
            <div class="box mart30 pad0">
                <div class="table3 pad20">
                    <table>
                        <tbody><tr class="bordb">
                            <td class="wid120"></td>
                            <td>项目</td>
                            <td class="wid90">状态</td>
                            <td class="wid60 ">信用分数</td>
                        </tr>
                        <tr class="bordb">
                            <td>基本信息</td>
                            <td>个人详细信息，工作信息</td>
                            <td>
                                <?=$detail['baseInof']['personalInfo']['status']?>
                            </td>
                            <td class="padl20">
                                <?=$detail['baseInof']['personalInfo']['creditScore']?>分
                            </td>
                        </tr>
                        <tr class="bordb">
                            <td>企业信息</td>
                            <td colspan="2">
                                <p class="bordb">
                                    <span class="right wid90">
                                        <?=$detail['myBidderInfo']['baseInfo']['status'];?>
                                    </span>
                                    基本信息
                                </p>
                                <p class="bordb">
                                    <span class="right wid90">
                                        <?=$detail['myBidderInfo']['legalPersonInfo']['status']?>
                                    </span>
                                    法人信息
                                </p>
                                <p class="bordb">
                                    <span class="right wid90">
                                        <?=$detail['myBidderInfo']['companyRegisteredInfo']['status']?>
                                    </span>
                                    公司注册信息
                                </p>
                                <p>
                                    <span class="right wid90">
                                        <?=$detail['myBidderInfo']['bankInfo']['status']?>
                                    </span>
                                    银行开户信息
                                </p>
                            </td>
                            <td></td>
                        </tr>
                        <tr class="bordb">
                            <td>资质信息</td>
                            <td colspan="2">
                                <?php foreach($zizhi as $v){?>
                                    <p class="bordb"><span class="right wid90"><?$v['status']?></span><?=$v['status']?>></p>
                                <?php }?>
                            </td>
                            <td class="padl20">
                                <?php foreach($zizhi as $v){?>
                                    <p><?=$v['status']?>分 </p>
                                <?php }?>
                            </td>
                        </tr>
                        <tr>
                            <td>交易记录</td>
                            <td colspan="2">
                                <p class="bordb">
                                    <span class="right wid90">
                                        <?=$detail['tradeInfo']['winNum']['status']?>
                                    </span>中标的次数
                                </p>
                                <p>
                                    <span class="right wid90">
                                        <?=price_format($detail['tradeInfo']['tradeAmount']['status'])?>
                                    </span>交易金额
                                </p>
                            </td>
                            <td class="padl20">
                                <p>
                                    <?=$detail['tradeInfo']['winNum']['creditScore']?>分
                                </p>
                                <p>
                                    <?=$detail['tradeInfo']['tradeAmount']['creditScore']?>分
                                </p>
                            </td>
                        </tr>
                        </tbody></table>
                </div>
                <div class="padm20 ">
                    <div class="charge_tips2 mart40">
                        <p><i class="ico i-tips"></i> 温馨提示： 为了投标更快一步，建议您立即<a href="<?=U('/member/bidder/applyfor');?>" class="blue">申请投标人认证</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<block name="script">
    <script>
        $(function(){
            $("#left-menu .submenu:eq(2),#left-menu .submenu:eq(2) a:eq(0)").addClass('active');
        })
    </script>
</block>
