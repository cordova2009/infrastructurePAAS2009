<?php
if(check_resp($resp)){
    $info = $resp['bondInfo'];
}
?>
<div class="auto  box pad0" id="bondInfo">
    <div class="h2">保证金</div>
    <div class="padm30">
        <form action="<?=U('/member/tender/saveBondInfo')?>" method="post" class="ajax-form" success="save_success" next_step="methodInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="shangwubiao">

            <div class="item padv30">
                <div class="lab"><span class="red">*</span>投标担保金额</div>
                <div class="value">
                    <span class="yuanbox">
                        <span class="yuan">元</span>
                        <input type="text" class="input1 wid220 price_format" placeholder="" name="bidBondAmount" value="<?=isset($info)?price_format($info['bidBondAmount']):''?>">
                    </span>
                </div>
            </div>

        </div>

        <div class="charge_tips2">
            <p><i class="ico i-tips"></i> 温馨提示</p>
            <p>1.投标保证金是指在招标投标活动中，投标人随投标文件一同递交给招标人的一定形式、<br>
                一定金额的投标责任担保。
            </p>
            <p>2.投标人在递交投标文件后不得撤销投标文件，中标后不得无正当理由不与招标人订立合同，<br>
                在签订合同时不得向招标人提出附加条件、或者不按照招标文件要求提交履约保证金，<br>
                否则，招标人有权不予返还其递交的投标保证金。
            </p>
        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>