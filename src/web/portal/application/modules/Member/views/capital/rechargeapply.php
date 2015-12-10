<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3">充值</div>
            <div class="padm30 chargeBox">
                <div class="charge_txt1">请按照以下目标账户信息转账</div>
                <div class="bordb">
                    <div class="item">
                        <span class="lab">账户名称</span>
                        <div class="auto value">
                            <?=isset($bankInfo)?$bankInfo['accountName']:''?>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab">账号</span>
                        <div class="auto value">
                            <?=isset($bankInfo)?$bankInfo['accountId']:''?>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab">开户行名称</span>
                        <div class="auto value">
                            <?=isset($bankInfo)?$bankInfo['bankName']:''?>
                        </div>
                    </div>
                </div>

                <div class="padv40 charge_form">
                    <form action="<?=U('/member/capital/rechargeApply')?>" method="post" class="ajax-form">
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 充值金额</span>
                        <div class="auto value " >
                            <span class="yuanbox">
                                <span class="yuan">元</span>
                                <input type="text" class="input1 " id="amount" name="amount">
                            </span>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 充值时间</span>
                        <div class="auto value " >
                            <input type="text" class="input1 datepicker date2" id="transferTime" name="transferTime" >
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 转账银行名称</span>
                        <div class="auto value " >
                            <input type="text" class="input1 " placeholder="示例：中国银行梅林支行" id="bankName" name="bankName">
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 银行转账凭证编号</span>
                        <div class="auto value " >
                            <input type="text" class="input1 " placeholder="示例：20151028032800564" id="voucherNo" name="voucherNo">
                            <span class="color9 fz14">转账时银行返回的“电子回单号”或“流水号”</span>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 银行转账凭证扫描件</span>
                        <div class="auto value">
                            <label class="btn-file2 wid110 ">
                                上传文件
                                <input type="file" class="file-upload" name="file">
                                <input type="hidden" name="voucherFileUrl"  >
                            </label>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"></span>
                        <div class="auto value">
                            <input type="submit" value="提交充值" class="btn2 wid110">
                        </div>
                    </div>
                    </form>
                </div>

                <div class="charge_tips2">
                    <p><i class="ico i-tips"></i> 温馨提示</p>
                    <p>1、为了您的资金安全，请在充值前检查目标充值账户和银行名称是否正确。</p>
                    <p>2、您的充值资金将通过银行转账到目标账户。</p>
                    <p>3、转账完成后，需要在这里提交转账凭证，目标账户收到后，将会您的资金账户上增加充值金额。</p>
                    <p>4、请注意您的银行账户的充值限制，以免造成不便。</p>
                    <p>5、禁止洗钱、信用卡套现、虚假交易等行为，一经发现并确认，将终止该账户的使用。</p>
                    <p>6、如果充值金额在48小时候没有到账，请联系客服：400-xxx-xxxx</p>
                </div>
            </div>
        </div>
    </div>
</div>
<block>
    <link href="/css/jquery.datetimepicker.css" rel="stylesheet" type="text/css" />
</block>
<block name="script">
    <!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
    <script src="/js/upload/vendor/jquery.ui.widget.js"></script>
    <!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
    <script src="/js/upload/jquery.iframe-transport.js"></script>
    <!-- The basic File Upload plugin -->
    <script src="/js/upload/jquery.fileupload.js"></script>
<script>
$(function(){
    $("#left-menu .submenu:eq(3),#left-menu .submenu:eq(3) a:eq(1)").addClass('active');
})

$(".file-upload").fileupload({
    url:'<?=U('/member/upload/picture')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
    done:function(e,data){
        //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
        //返回的数据在data.result中，假设我们服务器返回了一个json对象
        if(data.result.status == '0'){
            $(this).next().val(data.result.url);
        }else{
            layer.alert(data.result.msg,{icon:2});
        }
    }
})
</script>
<script src="/js/jquery.datetimepicker.js"></script>
</block>
