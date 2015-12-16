<div class=" main">
    <!--list-->
    <div class="error bgf">
        <div class="errorCont clear">
            <span class="left"><img src="/images/error.jpg" height="107" width="107" alt=""></span>
            <div class="auto">
                <p class="errorTxt1">SORRY <br>ANERROR HAS OCCURED</p>
                <p class="errorTxt2">对不起</p>
                <p class="errorTxt3">
                    <?=$message?>
                </p>
            </div>
        </div>

        <div class="errorLink">
            <a href="javascript:window.location=window.location">返回刷新</a>
            <a href="#">联系我们</a>
            <a href="/">返回首页</a>
        </div>

    </div>
</div>
<?php if(!empty($jumpUrl)):?>
<block name="script">
<script>
    setTimeout(function(){
        window.location = '<?=$jumpUrl?>';
    },<?=$waitSecond*1000?>);
</script>
</block>
<?php endif;?>