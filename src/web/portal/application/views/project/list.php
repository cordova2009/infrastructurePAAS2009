<div class=" main">
    <!--search-->
    <div class="list-search-cont table">
        <form action="<?=U('/project/list')?>" method="get">
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
        <div class="table2">
            <table>
                <tr class="thead bg1">
                    <td class="td1 text-center wid180">项目标题</td>
                    <td class="td2">招标人</td>
                    <td class="td3">招标人信用</td>
                    <td class="td4">评估金额</td>
                    <td>开工日期</td>
                    <td>标准工期</td>
                    <td>详情</td>
                </tr>
                <?php foreach($list as $k => $v): ?>
                    <tr <?php if(!($k % 2 == 0)) echo 'class="bg1"' ?>>
                        <td class="td1">
                            <span class="tag"><?=$industry_list[]?></span><?= $v['objectName'] ?>
                        </td>
                        <td class="td2"><?= $v['biddee'] ?></td>
                        <td class="td3"><span class="tag2"><?= $v['creditRating'] ?></span></td>
                        <td class="td4"><?=price_format($v['evaluationAmount'])?> <span class="fz12">元</span></td>
                        <td><?= $v['projectExpectStartDate'] ?></td>
                        <td><?=$v['projectExpectPeriod']?>天</td>
                        <td class="info">
                            <a href="<?=U('/project/detail',['objectId'=>$v['objectId']])?>">
                                <i class="ico i-eye"></i>
                            </a>
                        </td>
                    </tr>
                <?php endforeach; ?>
                <?php if(empty($list)):?>
                    <tr><td colspan="7" class="text-center">暂无数据</td></tr>
                <?php endif;?>
            </table>
        </div>
        <?php require_once APP_PATH.'views/common/page.php'?>
    </div>
</div>