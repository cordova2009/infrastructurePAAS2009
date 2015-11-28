<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3"><a href="<?=U('/member/info/index')?>" class="right btn">取消修改</a>基本信息</div>
            <div class="clear base_info">
                <a href="javascript:;" data-toggle="modal" data-target="#uploadBox">
                    <img src="<?=empty($user['headImageUrl']) ? '/uploads/avtar.png' : $user['/uploads/avtar.png']?>" class="avtar " >
                </a>
                <div class="auto">
                    <form action="<?=U('/member/info/edit')?>" method="post" class="ajax-form">
                        <div class="item">
                            <span class="lab">昵称</span>
                            <div class="auto value"><input id="nickname" name="nickname" type="text" class="input1 wid220" value="<?=$user['nickname']?>"></div>
                        </div>
                        <div class="item">
                            <span class="lab">姓名</span>
                            <div class="auto value">
                                <span class="left"><?=$user['realName']?></span>
                                <span class="right colora"><i class="ico i-ok3"></i> 已认证</span>
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab">身份证号</span>
                            <div class="auto value">
                                <span class="left"><?=substr_replace($user['cardID'],'**********',4,12)?></span>
                                <span class="right colora"><i class="ico i-ok3"></i> 已认证</span>
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab">手机号 </span>
                            <div class="auto value">
                                <span class="left"><?=substr_replace($user['mobileNum'],'*****',3,5)?></span>
                                <span class="right colora"><i class="ico i-ok3"></i> 已认证</span>
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab">邮箱地址</span>
                            <div class="auto value">
                                <span class="left"><input id="email" name="email" type="text" class="input1 wid220" value="<?=$user['email']?>"></span>
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab">联系地址</span>
                            <div class="auto value">
                                <span class="left"><input id="address" name="address" type="text" class="input1 wid220" value="<?=$user['address']?>"></span>
                            </div>
                        </div>

                        <div class="item padt60">
                            <span class="lab"></span>
                            <div class="auto value">
                                <span class="left"><input type="submit" class="btn " value="保 存"></span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(0),#left-menu .submenu:eq(0) a:eq(0)").addClass('active');
})
</script>
</block>