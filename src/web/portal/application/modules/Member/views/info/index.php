<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3"><a href="<?=U('/member/info/edit')?>" class="right btn">修改信息</a>基本信息</div>
            <div class="clear base_info">
                <img src="<?=empty($user['headImageUrl']) ? '/uploads/avtar.png' :imageView2($user['headImageUrl'],200,200)?>" class="avtar" >
                <div class="auto">
                    <div class="item">
                        <span class="lab">昵称</span>
                        <div class="auto value"><?=$user['nickname']?></div>
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
                            <span class="left"><?=$user['email']?>&nbsp;</span>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab">联系地址</span>
                        <div class="auto value">
                            <span class="left"><?=$user['address']?>&nbsp;</span>
                        </div>
                    </div>
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