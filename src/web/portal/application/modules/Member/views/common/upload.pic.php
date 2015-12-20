<script>
    $(function(){

        $(".file-upload").fileupload({
            url:'<?=U('/member/upload/picture')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
            dataType: 'json',
            add: function (e, data) {
                if (e.isDefaultPrevented()) {
                    return false;
                }
                $(this)
                    .prev()
                    .text('上传中..')
                    .parent()
                    .css('background','#bebebe');
                data.submit();
            },
            done:function(e,data){
                //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
                //返回的数据在data.result中，假设我们服务器返回了一个json对象
                var $this = $(this);
                var parent =$this
                    .prev().text('上传附件')
                    .parent().css('background','#8ab46e');

                if(data.result.status == '0'){
                    var obj = parent.hide().next('.uploaded');
                    //为隐藏标签赋值
                    $this.next().val(data.result.url);
                    if(obj.length > 0){
                        obj.removeClass('hide').show()
                            .find('.view').attr('href',data.result.src);
                    }else{
                        $this.closest('.upload_wrap')
                            .next('.uploaded').removeClass('hide2').show()
                            .find('.view').attr('href',data.result.src);
                    }
                }else{
                    layer.alert(data.result.msg,{icon:2});
                }
            },
            fail: function () {
                $(this)
                    .prev()
                    .text('上传附件')
                    .parent()
                    .css('background','#8ab46e');
                layer.alert('上传失败，请重新再试',{icon:2});
            }
        });

        $(".delete-pic-btn").click(function () {
            $(this)
                .closest('.uploaded').hide()
                .prev().show()
                .find('.btn-file2').removeClass('hide').show()
                .find('.hidden-url').val('');
        });
    });
</script>