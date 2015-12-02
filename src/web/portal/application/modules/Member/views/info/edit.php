<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3"><a href="<?=U('/member/info/index')?>" class="right btn">取消修改</a>基本信息</div>
            <div class="clear base_info">
                <a href="javascript:;" data-toggle="modal" data-target="#uploadBox">
                    <img id="avatar" src="<?=empty($user['headImageUrl']) ? '/uploads/avtar.png' : imageView2($user['headImageUrl'],200,200)?>" class="avtar " >
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
            <form id="file-upload" action="<?=U('/member/upload/picture')?>" method="POST" enctype="multipart/form-data">
                <div class="upload_cont">
                    <div class="table">
                        <div class="cell"><input id="pic_name" type="text" class="input2"></div>
                        <div class="cell wid110"><label class="btn-file">选择文件 <input name="file" type="file" value="选择文件" class=""></label></div>
                    </div>
                    <div class="upload_tips">你可以上传JPG、GIF或PNG文件上传图片最大4M</div>
                    <div class="text-right modal-footer">
                        <a id="upload-btn" href="javascript:" class="btn-blue">上传</a>
                        <a href="javascript:" class="btn-grey" data-miss="modal">取消</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<block name="script">
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="/js/upload/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/js/upload/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="/js/upload/jquery.fileupload.js"></script>

<script>
$(function(){
    $("#left-menu .submenu:eq(0),#left-menu .submenu:eq(0) a:eq(0)").addClass('active');

    $(".btn-file input").on("change",function(){
        var val = $(this).val();
        $("#pic_name").val(val)
    });
    $("#upload-btn").click(function() {
        //没有选择文件
        if($("#file-upload").data('data') == null){
            layer.alert('请选择图片！',{icon:2});
            return false;
        }

        $("#file-upload").data('data').submit();
    });
    $("#file-upload").fileupload({
        url:this.action,//文件上传地址，当然也可以直接写在input的data-url属性内
        formData:{},//如果需要额外添加参数可以在这里添加
//        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
        add: function (e, data) {
            if (e.isDefaultPrevented()) {
                return false;
            }
            $(this).data('data',data);
//            data.context = $('<p/>').text('Uploading...').appendTo(document.body);
//            data.submit();
        },
        done:function(e,data){
            //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
            //返回的数据在data.result中，假设我们服务器返回了一个json对象
            if(data.result.status == '0'){
                $.post('<?=U('/member/info/updateAvatar')?>',{headImageUrl:data.result.url},function(resp){
                    if(resp.status == '0'){
                        $("#avatar").attr('src',data.result.src);
                        $("#uploadBox").fadeOut();
                        $(this).data('data',null);
                        $("#pic_name").val('');
                    }else{
                        layer.alert(data.result.msg,{icon:2});
                    }
                })
            }else{
                layer.alert(data.result.msg,{icon:2});
            }
        }
    })
})
</script>
</block>