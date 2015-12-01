<div class=" main">
    <!--search-->
    <div class="list-search-cont table">
        <form action="" method="get">
            <div class="cell search-box">
                <input type="text" class="search" name="keyword" value="<?php echo I('keyword'); ?>">
            </div>
            <div class="cell search-btn">
                <input type="submit" value="搜索工程项目" class="sub1 ">
            </div>
        </form>
    </div>

    <!--pub-time-->
    <div class="pub-time">
        选择工程项目发布时间段 
        <a href="#">近一周发布的标的</a> 
        <a href="#" class="active">近一个月发布的标的</a> 
        <a href="#">近两个月发布的标的</a> 
        <a href="#">发布两个月以上的标的</a>
    </div>
    <!--list-->
    <div class="result-list bgf">
        <div class="tit1">搜索结果</div>
        <div class="padm40">
            <div class="table2">
                <table>
                    <tr class="thead">
                        <td class="td1 text-center wid180">项目标题</td>
                        <td class="td2">招标人</td>
                        <td class="td3">招标人信用</td>
                        <td class="td4">评估金额</td>
                        <td>工程期限</td>
                    </tr>
                    <?php foreach($list as $v): ?>
                    <tr>
                        <td class="td1"><span class="tag">土</span><?= $v['objectName'] ?></td>
                        <td class="td2"><?= $v['biddee'] ?></td>
                        <td class="td3"><span class="tag2"><?= $v['creditRating'] ?></span></td>
                        <td class="td4"><?= $v['evaluationAmount'] ?> <span class="fz12">元</span></td>
                        <td><?= $v['projectExpectStartDate'] ?>到 <?php date('Y-m-d', strtotime($v['projectExpectStartDate']) + $v['projectExpectPeriod']*24*3600) ?></td>
                    </tr>
                    <?php endforeach; ?>
                </table>
            </div>
        </div>
        <?php include(dirname(dirname(__FILE__)).'/common/page.php'); ?>
    </div>
</div>