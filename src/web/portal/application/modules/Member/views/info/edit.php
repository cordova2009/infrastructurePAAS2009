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
<div class="modal" id="uploadBox">
    <div class="modal-bg"></div>
    <div class="modal-body">
        <div class="modal-header clear">
            <span class="left">上传头像</span>
            <a href="javascript:;" class="right" data-miss="modal">×</a>
        </div>
        <div class="modal-cont">
            <div class="upload_cont">
                <div class="table">
                    <div class="cell"><input type="text" class="input2"></div>
                    <div class="cell wid110"><label class="btn-file">选择文件 <input type="file" value="选择文件" class=""></label></div>
                </div>
                <div class="upload_tips">你可以上传JPG、GIF或PNG文件上传图片最大4M</div>
                <div class="text-right modal-footer">
                    <a href="#" class="btn-blue">上传</a>
                    <a href="#" class="btn-grey" data-miss="modal">取消</a>
                </div>
            </div>

        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(0),#left-menu .submenu:eq(0) a:eq(0)").addClass('active');
    $(".upload_avtar").click(function(event) {
        $(".modal").show();
    });
    $(".btn-file input").on("change",function(){
        var val = $(this).val();
        $(this).parents(".table").find(".input2").val(val)
    })
    $(".upload_avtar").click(function() {

    });
})
</script>
</block>