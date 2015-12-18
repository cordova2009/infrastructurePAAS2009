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
        <div class="tit1">招标项目列表</div>
        <div class="table">
            <table>
                <tr class="bg1 thead">
                    <td class="td1 text-center">项目标题</td>
                    <td class="td2">招标人</td>
                    <td class="td3">招标人信用</td>
                    <td class="td4">评估金额</td>
                    <td class="td5">工程计划开始时间</td>
                    <td class="td6">工期要求</td>
                    <td>详情</td>
                </tr>
                <?php foreach($object_list as $item):?>
                    <tr>
                        <td class="td1"><?=$item['objectName']?></td>
                        <td class="td2"><?=$item['companyShortName']?></td>
                        <td class="td3"><span class="tag2"><?=$item['creditRating']?></span></td>
                        <td class="td4"><?=price_format($item['evaluationAmount'])?> <span class="fz12">元</span></td>
                        <td class="td5"><?=$item['objectPredictStartTime']?></td>
                        <td class="td6"><?=$item['projectExpectPeriod']?>天</td>
                        <td class="info"><a href="<?=U('/project/detail',['objectId'=>$item['objectId']])?>"><i class="ico i-eye"></i></a></td>
                    </tr>
                <?php endforeach;?>
            </table>
        </div>
        
        <?php include(dirname(dirname(__FILE__)).'/common/page.php'); ?>
        
    </div>
</div>
