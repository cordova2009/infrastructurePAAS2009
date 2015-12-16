<div class=" main" xmlns="http://www.w3.org/1999/html">
    <div class="miancont ">
        <form action="<?=U('/member/vip/buyBidVip',['productId'=>$birMember['productId']])?>" method="post" class="ajax-form">

        <div class="payBOx">
            <div class="txt1">投标人会员服务价格<?=$birMember['productPrice'] ?>元/年</div>
            <div class="txt2">请选择支付方式</div>
            <div class="clear pay_select">
                <a class="left " href="javascript:;">
                    <i class="ico i-pay1 "></i>
                    <input type="checkbox" checked name="payWay" value="AAC" class="hide" >
                    资金账户
                </a>
                <a class="right active"  href="javascript:;">
                    <i class="ico i-pay2"></i>
                    <input type="checkbox" checked name="payWay" value="ALI" class="hide" >
                    支付宝
                </a>
            </div>
            <div class="clear btnCont">

                <button  class="button left cancle">取消</button>
                <button  class="button right sure">确认</button>
            </div>
        </div>
        </form>
    </div>
</div>
<block>
    <link href="/css/jquery.datetimepicker.css" rel="stylesheet" type="text/css" />
</block>
<block name="script">

    <script src="/js/jquery.datetimepicker.js"></script>
</block>
