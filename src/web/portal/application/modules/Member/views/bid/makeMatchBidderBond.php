<?php
if(check_resp($resp)){
    $info = $resp['bond'];
}
?>
<div class="auto  box pad0" id="makeMatchBidderBond">
    <div class="h2">撮合交易保证金</div>
    <div class="padm30">
        <form action="<?=U('/member/bid/saveMakeMatchBidderBond')?>" method="post" class="ajax-form" success="save_success" next_step="bidderBond">
            <input name="objectId" value="<?=$objectId?>" type="hidden" />
            <input name="bidId" value="<?=$bidId?>" type="hidden" />
            <div class="text-center chongzhi">
                <span class="orange "><?=isset($info)?price_format($info['makeMatchBidderBondAmount']):''?>元</span>
                <?php if($account['remainingSum'] < $info['makeMatchBidderBondAmount']): ?>
                    <a href="<?=U('/member/capital/rechargeApply')?>" class="btn-chongzhi bg-green2">充值</a>
                <?php endif;?>
                <span style="font-size:13px;">（账户余额：<?=price_format($account['remainingSum'])?>元）</span>
            </div>

            <div class="text-center checklist fz16">
                <i class="ico i-check on"></i>
                <input id="i-tongyi" checked type="checkbox" class="hide">
                我已阅读并同意《xxxxx协议》
            </div>

            <div class="charge_tips2">
                <p><i class="ico i-tips"></i> 温馨提示</p>
                <p>1.为了招投标的有效性，我们将收取中标金额的0.5%作为撮合交易手续费，最高人民币50万元封顶。</p>
                <p>2.如果您未中标，我们将在24小时内将撮合交易担保金返还到您在我们平台上的资金账户。 </p>
                <p>3.如果您中标，我们将收取中标金额的0.5%作为撮合交易手续费，最高人民币50万元封顶。</p>
                <p>4.如果在招投标过程，有舞弊、虚假交易等行为，一经发现并确认，将扣除撮合交易保证金。</p>
                <p>5.如果24小时内应返还的撮合交易担保金未到您资金账户，请联系客服：400-xxx-xxxx</p>
            </div>

            <div class="text-center padv30">
                <?php if($account['remainingSum'] < $info['makeMatchBidderBondAmount']): ?>
                    <button type="button" class="btn-green2 bg-grey">余额不足，请先充值</button>
                <?php else:?>
                <button type="submit" class="btn-green2">保存并继续</button>
                <?php endif;?>
            </div>

        </form>
    </div>
</div>