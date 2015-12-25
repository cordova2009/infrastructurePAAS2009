<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
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
            <?php include(APP_PATH . 'views/common/page.php'); ?>
        </div>
    </div>
</div>
<block name="script">
        <script type="text/javascript">
		$(function(){
            $("#left-menu .submenu:eq(5),#left-menu .submenu:eq(5) a:eq(0)").addClass('active');
			$(".info .more").click(function(event) {
				$(this).parents(".info").find('p').attr('style', 'height: 30px; line-height: 30px;');
				$(this).hide();
			});
		})
	</script>
</block>