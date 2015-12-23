<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tab_box">
                <div class="hd tab_tit clear">
                    <ul>
                        <li class="on">投标人开户行信息</li>
                        <li >招标人开户行信息</li>
                    </ul>
                </div>
                <div class="bd">
                    <div class="tab_cont card_info">
                        <?php
                        if(!empty($info['BerbankInfo'])):
                            foreach($info['BerbankInfo'] as $item):
                                ?>
                                <span class="left leftimg"><img src="/images/card.jpg"></span>
                                <div class="auto">
                                    <div class="item">
                                        <span class="lab">账户名</span>
                                        <div class="auto value">
                                            <?=$item['accountName']?>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="lab">账户</span>
                                        <div class="auto value">
                                            <?=$item['accountId']?>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="lab">开户行</span>
                                        <div class="auto value">
                                            <?=$item['bank']?>
                                        </div>
                                    </div>
                                </div>
                            <?php
                            endforeach;
                        else:
                            ?>
                            您还没有认证招标人！
                        <?php endif;?>
                    </div>

                    <div class="tab_cont card_info">
                        <?php
                        if(!empty($info['BeebankInfo'])):
                            foreach($info['BeebankInfo'] as $item):
                                ?>
                                <span class="left leftimg"><img src="/images/card.jpg"></span>
                                <div class="auto">
                                    <div class="item">
                                        <span class="lab">账户名</span>
                                        <div class="auto value">
                                            <?=$item['accountName']?>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="lab">账户</span>
                                        <div class="auto value">
                                            <?=$item['accountId']?>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <span class="lab">开户行</span>
                                        <div class="auto value">
                                            <?=$item['bank']?>
                                        </div>
                                    </div>
                                </div>
                            <?php
                            endforeach;
                        else:
                            ?>
                            您还没有认证招标人！
                        <?php endif;?>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<block name="script">
    <script>
        $(function(){
            $("#left-menu .submenu:eq(0),#left-menu .submenu:eq(0) a:eq(2)").addClass('active');
        })
    </script>
</block>