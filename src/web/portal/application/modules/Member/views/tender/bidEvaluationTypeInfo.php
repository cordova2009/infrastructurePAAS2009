<?php
if(check_resp($resp)){
    $info = $resp['bidEvaluationTypeInfo'];
}
?>
<div class="auto box pad0" id="bidEvaluationTypeInfo">
    <div class="h2">评标方式</div>
    <div class="padm30">

        <form action="<?=U('/member/tender/saveBidEvaluationTypeInfo')?>" method="post" class="ajax-form" success="save_success" next_step="last">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class=" pbfs padt20">

            <div class="item ">
                <div class="lab"><span class="red">*</span>评标方法及标准</div>
                <div class="value">
                    <div class="checkBtn2">
                        <a href="javascript:;" class="active">
                            定性评审法
                            <input name="bidEvaluationType" type="radio" class="hide" value="QLT" checked>
                        </a>
                        <a href="javascript:;" >
                            信用商户评审法
                            <input name="bidEvaluationType" type="radio" class="hide" value="CRE">
                        </a>
                        <a href="javascript:;" >
                            综合评估法
                            <input name="bidEvaluationType" type="radio" class="hide" value="OVE">
                        </a>
                    </div>
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>技术标评标地点</div>
                <div class="value">
                    <input type="text" class="input1 " placeholder="深圳市福田区竹子林求是大厦西座20开标大厅" name="bidEvaluationSite" value="<?=isset($info)?$info['bidEvaluationSite']:''?>">
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>中标人的确定方法</div>
                <div class="value">
                    <div class="checkBtn2">
                        <a href="javascript:;" >
                            直接票决定标
                            <input name="bidWinnerDetermineWay" type="radio" class="hide" value="ORV">
                        </a>
                        <a href="javascript:;" class="active">
                            逐轮票决定标
                            <input name="bidWinnerDetermineWay" type="radio" class="hide" value="MRV" checked>
                        </a>
                        <a href="javascript:;" >
                            票决筹钱定标
                            <input name="bidWinnerDetermineWay" type="radio" class="hide" value="VDM">
                        </a>
                    </div>
                </div>
            </div>
            <div class="item ">
                <div class="lab"><span class="red">*</span>票决方式</div>
                <div class="value">
                    <div class="checkBtn2">
                        <a href="javascript:;" >
                            简单铎书法
                            <input name="voteWinWay" type="radio" class="hide" value="SMP">
                        </a>
                        <a href="javascript:;" class="active">
                            对比胜出法
                            <input name="voteWinWay" type="radio" class="hide" value="CPN" checked>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">提交招标申请</button>
        </div>

        </form>

    </div>
</div>

<script>
    $(function(){

    <?php
    if(isset($info)):
        if(!empty($info['bidEvaluationType'])):
        ?>
        $("input[name=bidEvaluationType]").each(function(){

            if(this.value == '<?=$info['bidEvaluationType']?>'){
                this.checked = true;
                return false;
            }
        })
    <?php
        endif;
        if(!empty($info['bidWinnerDetermineWay'])):
    ?>
        $("input[name=bidWinnerDetermineWay]").each(function(){

            if(this.value == '<?=$info['bidWinnerDetermineWay']?>'){
                this.checked = true;
                return false;
            }
        })
    <?php
        endif;
        if(!empty($info['voteWinWay'])):
    ?>
        $("input[name=voteWinWay]").each(function(){

            if(this.value == '<?=$info['voteWinWay']?>'){
                this.checked = true;
                return false;
            }
        })
    <?php
        endif;
    endif;
    ?>
    })
</script>