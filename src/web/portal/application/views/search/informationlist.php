<div class=" main">
    <!--search-->
    <div class="list-search-cont table ">
        <form action="/search/informationlist.html" method="get">
            <div class="cell search-box">
                <input type="text" name="keyword" class="search" value="">
            </div>
            <div class="cell search-btn">
                <input type="submit" value="搜索项目信息" class="sub1 ">
            </div>
        </form>
    </div>

    <!--pub-time-->
   <div class="pub-time">
        选择工程项目发布时间段 <a href="#">近一周发布的信息</a> <a href="#" class="active">近一个月发布的信息</a> <a href="#">近两个月发布的标的</a> <a href="#">发布两个月以上的标的</a>
    </div>
    <!--list-->
    <div class="result-list bgf">
        <div class="tit1">项目信息列表</div>
        <div class="table">
            <table>
                <tr class="bg1 thead">
                    <td class="name">项目名称</td>
                    <td class="tenderee">工程阶段</td>
                    <td class="tenderee">工程类别</td>
                    <td  class="price">地区</td>
                    <td class="info">详情</td>
                </tr>
                <?php  if(!empty($list)){
                    foreach($list as $item){?>
                        <tr>
                            <td  class="name"><?= $item['objectName'] ?></td>
                            <td class="tende$bid_listree" class="tenderee"><?= $item['phase'] ?></td>
                            <td class="tenderee"><?= $item['objectType'] ?></td>
                            <td class="price"><?= $item['district'] ?> </td>
                            <td class="info"><a href="<?=U('/member/Information/publishDetail',['informationId'=>$item['informationId']])?>"><i class="ico i-eye"></i></a></td>
                        </tr>
                    <?php }
                }else{?>
                    <tr><td colspan="8">搜索"<?=$keyword?>",找到0条结果</td></tr>
                <?php }?>
            </table>
        </div>
        <?php include(APP_PATH . 'views/common/page.php'); ?>
        
    </div>
</div>
