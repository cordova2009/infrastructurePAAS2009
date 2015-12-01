<div class=" main">
    <!--search-->
    <div class="list-search-cont table ">
        <form action="" method="get">
            <div class="cell search-box">
                <input type="text" class="search" name="keyword" value="<?php echo I('keyword'); ?>">
            </div>
            <div class="cell search-btn">
                <input type="submit" value="搜索投标人" class="sub1 ">
            </div>
        </form>
    </div>

    <!--list-->
    <div class="result-list bgf mart25">
        <div class="tit1">搜索结果</div>
        <div class="table">
            <table>
                <tr class="bg1 thead">
                    <td>投标人</td>
                    <td>地区</td>
                    <td >信用等级</td>
                    <td>详情</td>
                </tr>
                <?php foreach($list as $v): ?>
                <tr>
                    <td ><?= $v['shortName'] ?></td>
                    <td><?= $v['area'] ?></td>
                    <td><span class="tag2"><?= $v['eq'] ?></span></td>
                    <td><a href="/bidder/detail/id/<?= $v['bidderId'] ?>.html" class="blue">查看</a></td>
                </tr>
                <?php endforeach; ?>
            </table>
        </div>
        <?php include(dirname(dirname(__FILE__)).'/common/page.php'); ?>
    </div>
</div>
