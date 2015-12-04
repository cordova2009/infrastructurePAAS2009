<div class="main">
    <div class="clear">
        <div class="left sidemenu">
            <a href="#">公司简介</a>
            <a href="#">安全保障</a>
            <a href="#">媒体报道</a>
            <a href="#">社会责任</a>
            <a href="#">招贤纳士</a>
            <a href="/notice/list.html">网站公告</a>
            <a href="#">帮助中心</a>
            <a href="javascript:void(0)" class="active">消息通知</a>
            <a href="#">联系我们</a>
        </div>
        <div class="content auto">
            <div class="tit3">我的消息</div>
            <!--list-->
            <div class="list2">
                <ul>
                    <?php foreach($list as $v): ?>
                    <li>
                        <img src="<?= $v['msgIcon'] ?>" class="left thumbnail">
                        <div class="auto">
                            <div class="tit"><?= $v['msgTitle'] ?></div>
                            <div class="time"><?= $v['createTime'] ?></div>
                            <div class="info">
                                <p style="white-space: nowrap; width: 550px;height: 30px; line-height: 30px;overflow: hidden;text-overflow: ellipsis">
                                    <?= $v['msgContent'] ?>
                                </p>
                                <a href="javascript:;" class="blue more">展开 <i class="ico i-down"></i></a>
                            </div>
                        </div>
                    </li>
                    <?php endforeach; ?>
                </ul>
            </div>
            <!--page-->
            <?php include(dirname(dirname(__FILE__)).'/common/page.php'); ?>
        </div>
    </div>
</div>
<block name="script">
        <script type="text/javascript">
		$(function(){
			$(".info .more").click(function(event) {
				$(this).parents(".info").find('p').attr('style', 'height: 30px; line-height: 30px;');
				$(this).hide();
			});
		})
	</script>
</block>