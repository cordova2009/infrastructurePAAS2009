<div class="main">
    <div class="miancont ">
        <form id="pay-form" action="<?=U('/member/vip/pay')?>" method="post" target="_blank">
            <input type="hidden" name="type" value="<?=$type?>">
            <input type="hidden" name="orderId" value="<?=$orderId?>">
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
<div id="ask-wrap" class="hide">
    <div class="layui-layer-dialog wid350">
        <div class="layui-layer-content layui-layer-padding">
            <i class="layui-layer-ico layui-layer-ico0"></i>
            <div class="fz18 padb5">请在新打开的页面上完成付款</div>
            <span class="fz14">付款完成前请不要关闭窗口</span>

            <div class="mart20">
                <a href="<?=U('/payment/callback',['out_trade_no'=>$orderId])?>" class="btn-blue radiu5 marr30">已完成付款</a>
                <a href="javascript:" class="blue">付款遇到问题</a>
            </div>

            <div class="mart20">
                <a href="javascript:" class="green close">返回选择其他付款方式>></a>
            </div>
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
   $("#pay-form").submit(function(){
       var index = layer.open({
           type: 1,
           title:'提示',
           shadeClose: true, //开启遮罩关闭
           content: $("#ask-wrap").html()
       });

       $(".close").click(function(){
           layer.close(index);
       });
   });

});
</script>
</block>
