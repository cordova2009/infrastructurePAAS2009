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
                <tr>
                    <td >张某某</td>
                    <td>浙江省杭州市</td>
                    <td><span class="tag2">A</span></td>
                    <td><a href="#" class="blue">查看</a></td>
                </tr>
                <tr class="bg1">
                    <td >张某某</td>
                    <td>浙江省杭州市</td>
                    <td><span class="tag2 bg-pink">AA</span></td>
                    <td><a href="#" class="blue">查看</a></td>
                </tr>
            </table>
        </div>
        <?php include(dirname(dirname(__FILE__)).'/common/page.php'); ?>
    </div>
</div>
