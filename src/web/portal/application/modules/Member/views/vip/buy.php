<div class="main">
    <div class="miancont ">
        <form action="<?=U('/member/vip/pay')?>" method="post" target="_blank">
            <input type="hidden" name="type" value="<?=$type?>">
            <div class="payBOx">
                <div class="txt1"><?=$product['productName']?>服务价格<?=$product['productPrice']?><?=price_format($product['productPrice'])?>元/年</div>
                <div class="txt2">请选择支付方式</div>
                <div class="clear pay_select">
                    <a class="left radio" href="javascript:;">
                        <i class="ico i-pay1 "></i>
                        <input type="radio" name="payWay" value="AAC" class="hide" >
                        资金账户
                    </a>
                    <a class="right radio active"  href="javascript:;">
                        <i class="ico i-pay2"></i>
                        <input type="radio" checked name="payWay" value="ALI" class="hide" >
                        支付宝
                    </a>
                </div>
                <div class="clear btnCont">
                    <a href="javascript:history.back()" class="button left cancle">取消</a>
                    <button type="submit" class="button right sure">确认</button>
                </div>
            </div>
        </form>
    </div>
</div>