<div class=" main">
    <!--list-->
    <div class="error bgf">
        <div class="errorCont clear">
            <div class="success">
                <i class="ico i-ok"></i>
                <?=$message?>
            </div>
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