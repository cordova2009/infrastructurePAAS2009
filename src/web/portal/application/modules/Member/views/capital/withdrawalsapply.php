<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="content auto">
            <div class="tit3">提现</div>
            <div class="padm30 chargeBox">
                <div class="padv40 charge_form">
                    <form action="<?=U('/member/capital/withdrawalsApply')?>" method="post" class="ajax-form">
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 提现到</span>
                        <div class="auto value radio selectBank" >
                            <a href="#" class="active"> 投标人开户行</a>
                            <a href="#">招标人开户行</a>
                            <div class="color9 " ><?=$BerbankInfo?></div>
                            <div class="color9 hide"><?=$BeebankInfo?></div>
                            <input type="hidden" name="bankId" id="bankId" value="<?= $BerbankId ?>" />
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab">可用余额</span>
                        <div class="auto value " >
                            <span class="orange"><?=$account['remainingSum']?></span>元
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 提现金额</span>
                        <div class="auto value " >
                            <span class="yuanbox">
                                <span class="yuan">元</span>
                                <input type="text" class="input1 " id="amount" name="amount">
                            </span>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 提现费用</span>
                        <div class="auto value " >
                            <span class="orange">0.00</span>元 <a href="#" class="blue padl30 fz14">提现费用说明</a>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab">预计到账日期</span>
                        <div class="auto value " >
                            <span class="color9 fz14"><?=$withdrewalsTime?> <span class="padl40"> 1~2个工作日（双休日和法定节假日除外）之内到账</span></span>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 交易密码</span>
                        <div class="auto value">
                            <input type="password" class="input1 " placeholder="" id="tradePassword" name="tradePassword"> <a href="#" class="blue fz14">忘记密码</a>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"></span>
                        <div class="auto value">
                            <input type="submit" value="申请提现" class="btn2 wid110">
                        </div>
                    </div>
                    </form>
                </div>

                <div class="charge_tips2">
                    <p><i class="ico i-tips"></i> 温馨提示</p>
                    <p>1.请确保您输入的提现金额，以及选择的银行账号准确无误。</p>
                    <p>2.如果您填写的提现信息不正确可能会导致提现失败，由此产生的提现费用将不予返还。</p>
                    <p>3.在双休日和法定节假日期间，用户可以申请提现，大力99会在下一个工作日进行处理。由此造成的不便，请多
                        多谅解！
                    </p>
                    <p>4.平台禁止洗钱、信用卡套现、虚假交易等行为，一经发现并确认，将终止该账户的使用。</p>
                </div>
            </div>
        </div>
    </div>
</div>
<block name="script">
<script>
    var BerbankId= "<?= $BerbankId ?>";
    var BeebankId= "<?= $BeebankId ?>";
$(function(){
    $(".radio a").click(function() {
        var ind = $(this).index();
        if(ind){
            $("#bankId").val(BeebankId);
        }else{
            $("#bankId").val(BerbankId);
        }
        $(".selectBank").find(".color9").addClass('hide');
        $(".radio a").removeClass('active');
        $(this).addClass('active');
        $(".selectBank").find(".color9").eq(ind).removeClass('hide');
    });
    $("#left-menu .submenu:eq(3),#left-menu .submenu:eq(3) a:eq(3)").addClass('active');
})
</script>
</block>
