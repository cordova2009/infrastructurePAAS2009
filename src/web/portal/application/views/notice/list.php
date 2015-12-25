<div class="main">
    <div class="clear">
        <div class="left sidemenu">
            <a href="#">公司简介</a>
            <a href="#">安全保障</a>
            <a href="#">媒体报道</a>
            <a href="#">社会责任</a>
            <a href="#">招贤纳士</a>
            <a href="javascript:void(0)" class="active">网站公告</a>
            <a href="#">帮助中心</a>
            <a href="#">联系我们</a>
        </div>
        <div class="content auto">
            <div class="tit1 blue">公告</div>
            <!--list-->
            <div class="list1">
                <ul>
                    <?php foreach ($list as $v): ?>
                    <li>
                        <a href="/notice/detail/id/<?= $v['id'] ?>.html">
                            <p class="left"><?= $v['title']; ?></p>
                            <span class="right"><?= date('Y-m-d', strtotime($v['insertTime'])) ?></span>
                        </a>
                    </li>
                    <?php endforeach; ?>
                </ul>
            </div>
            <!--page-->
            <?php include(dirname(dirname(__FILE__)).'/common/page.php'); ?>
        </div>
    </div>
</div>