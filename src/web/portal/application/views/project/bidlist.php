<div class=" main">
    <!--search-->
    <div class="list-search-cont table ">
        <form action="/search/project.html" method="get">
            <div class="cell search-box">
                <input type="text" name="keyword" class="search" value="">
            </div>
            <div class="cell search-btn">
                <input type="submit" value="搜索工程项目" class="sub1 ">
            </div>
        </form>
    </div>

    <!--pub-time-->
    <div class="pub-time">
        选择工程项目发布时间段 <a href="#">近一周发布的标的</a> <a href="#" class="active">近一个月发布的标的</a> <a href="#">近两个月发布的标的</a> <a href="#">发布两个月以上的标的</a>
    </div>
    <!--list-->
    <div class="result-list bgf">
        <div class="tit1">更多中标结果</div>
        <div class="table">
            <table>
                <tr class="bg1 thead">
                    <td class="name">项目名称</td>
                    <td class="tenderee">招标人</td>
                    <td class="tenderee">中标人</td>
                    <td  class="price">评估金额</td>
                    <td class="info">详情</td>
                </tr>
                <?php foreach($list as $v): ?>
                <tr>
                    <td  class="name"><span class="tag">土</span><?= $v['objectName'] ?></td>
                    <td class="tenderee" class="tenderee"><?= $v['biderName'] ?></td>
                    <td class="tenderee"><?= $v['bideeName'] ?></td>
                    <td class="price"><?= $v['winBidAmount'] ?> <span class="fz12">元</span></td>
                    <td class="info"><a href="#"><i class="ico i-eye"></i></a></td>
                </tr>
                <?php endforeach; ?>
            </table>
        </div>
        
        <?php include(dirname(dirname(__FILE__)).'/common/page.php'); ?>
        
    </div>
</div>
