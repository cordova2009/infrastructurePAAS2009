<!--ban-->
<div class="ban">
    <div class="search-cont">
        <form id="myform" method="GET" class="left search-box">
            <input type="text" name="keyword" value="" placeholder="输入搜索信息" class="searchInput">
            <input type="button" class="searchBtn">
        </form>
        <a href="javascript:void(0)" class="btn1" id="bidder">找投标人</a>
        <a href="javascript:void(0)"  class="btn1" id="project">找工程</a>
    </div>

    <div class="bd">
        <ul>
            <li><img src="uploads/ban1.jpg"></li>
            <li><img src="uploads/ban1.jpg"></li>
        </ul>
    </div>
    <div class="hd">
        <ul>
        </ul>
    </div>
</div>
<div class="bgf">
    <div class="cent">
        <div class="ind-box1 clear">
            <ul>
                <li>
                    <a href="#">
                        <div class="pic"><img src="images/in-p2.jpg" ></div>
                        <div class="txt1">安全保障</div>
                        <p class="txt2">大力99理财华丽升级，全面开启，新品牌为您打造始终如一的专业理财服务。</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pic"><img src="images/in-p1.jpg" ></div>
                        <div class="txt1">中间担保交易</div>
                        <p class="txt2">大力99理财华丽升级，全面开启，新品牌为您打造始终如一的专业理财服务。</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pic"><img src="images/in-p3.jpg" ></div>
                        <div class="txt1">严格资质审核</div>
                        <p class="txt2">大力99理财华丽升级，全面开启，新品牌为您打造始终如一的专业理财服务。</p>
                    </a>
                </li>
            </ul>
        </div>
        <div class="tips-cont clear">
            <div class="tips left">
                <div class="bd">
                    <ul>
                        <li>
                            <p class="left"><a href="/notice/detail/id/<?=$site_notice['id'] ?>.html"><?= $site_notice['title'] ?></a></p>
                            <span class="right"><?= date('Y-m-d', strtotime($site_notice['insertTime'])) ?></span>
                        </li>
                    </ul>
                </div>
            </div>
            <a href="/notice/list.html" class="more right">更多公告</a>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!--gonggao-->
<div class="tips-box2">
    <div class="cent ">
        <div class="in-tit1">招标项目公告</div>
        <div class="clear tips-txtcont">
            <div class="left txt2">
                <span class="left tag-txt">项目<br>数量</span>
                <div class="left num">
                    <span class="fz100"><?=$object_info['objectNum']?></span><span class="left dw">个</span>
                </div>
            </div>
            <div class="left txt2">
                <span class="left tag-txt">交易<br>金额</span>
                <div class="left num">
                    <span class="fz100"><?=price_dispose($object_info['objectNum'],10000)?></span><span class="fz87">万</span><span class="left dw">元</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!---->
<div class="bgf zbxm">
    <div class="cent padb20">
        <div class="in-tit1">招标项目列表</div>
        <div class="table2 table-bord">
            <table>
                <tr class="thead">
                    <td class="td1">项目标题</td>
                    <td class="td2">招标人</td>
                    <td class="td3">招标人信用</td>
                    <td class="td4">评估金额</td>
                    <td class="td5">工程计划开始时间</td>
                    <td class="td6">工期要求</td>
                    <td></td>
                </tr>
                <?php foreach($object_list as $item):?>
                <tr>
                    <td class="td1"><?=$item['objectName']?></td>
                    <td class="td2"><?=$item['companyShortName']?></td>
                    <td class="td3"><span class="tag2"><?=$item['creditRating']?></span></td>
                    <td class="td4"><?=price_format($item['evaluationAmount'])?> <span class="fz12">元</span></td>
                    <td class="td5"><?=$item['objectPredictStartTime']?></td>
                    <td class="td6"><?=$item['projectExpectPeriod']?>天</td>
                    <td><a href="<?=U('/project/detail',['objectId'=>$item['objectId']])?>" class="toubiao">投标</a></td>
                </tr>
                <?php endforeach;?>
            </table>
            <?php if(empty($object_list)):?>
            <div class="list-more">暂无数据</div>
            <?php endif;?>
            <div class="list-more"><a href="<?=U('/project/list')?>">查看更多招标项目</a></div>
        </div>
    </div>
</div>
<!---->
<div class="tips-box2 zhongbiao">
    <div class="cent">
        <div class="in-tit1">中标结果公告</div>
        <div class="clear tips-txtcont">
            <div class="left txt2">
                <span class="left tag-txt2 padt30">公告中标数</span>
                <div class="left num">
                    <span class="fz100"><?=$bid_info['bidNum']?></span><span class="left dw">个</span>
                </div>
            </div>
            <div class="left txt2">
                <span class="left tag-txt2">中标<br>累计金额</span>
                <div class="left num">
                    <span class="fz100"><?=price_dispose($bid_info['bidNum'],10000)?></span><span class="fz87">万</span><span class="left dw">元</span>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="bgf zhongbiao-result">
    <div class="cent padb20">
        <div class="in-tit1">中标结果列表</div>
        <div class="table table-bord">
            <table>
                <tr class=" thead">
                    <td class="name">招标项目名称</td>
                    <td class="tenderee">招标人</td>
                    <td class="tenderee">中标人</td>
                    <td  class="price">评估金额</td>
                    <td class="info">详情</td>
                </tr>
                <?php foreach($bid_list as $item):?>
                <tr>
                    <td  class="name"><span class="tag">土</span><?= $item['objectName'] ?></td>
                    <td class="tende$bid_listree" class="tenderee"><?= $item['bidderName'] ?></td>
                    <td class="tenderee"><?= $item['biddeeName'] ?></td>
                    <td class="price"><?= $item['winBidAmount']>0 ? $item['winBidAmount'] : 0 ?> <span class="fz12">元</span></td>
                    <td class="info"><a href="#"><i class="ico i-eye"></i></a></td>
                </tr>
                <?php endforeach;?>
            </table>
            <?php if(empty($bid_list)):?>
            <div class="list-more">暂无数据</div>
            <?php endif;?>
            <div class="list-more"><a href="/project/bidlist.html">查看更多中标结果</a></div>
        </div>
    </div>
</div>

<!---->
<div class="tips-box2 toubiaoren">
    <div class="cent ">
        <div class="in-tit1">投标人</div>
        <div class="clear tips-txtcont">
            <div class="left txt2">
                <span class="left tag-txt2 padt30">一级资质</span>
                <div class="left num">
                    <span class="fz100"><?=$bidder_info['stairBiderNum']?></span><span class="left dw">家</span>
                </div>
            </div>
            <div class="left txt2">
                <span class="left tag-txt2 padt30">二级资质</span>
                <div class="left num">
                    <span class="fz100"><?=$bidder_info['secondBiderNum']?></span><span class="left dw">家</span>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="bgf best-toubiao">
    <div class="cent  padb20">
        <div class="in-tit1">优质投标人</div>
        <ul class="clear">
            <?php foreach($bidder_list as $item):?>
            <li><a href="#"><img src="<?=imageView2($item['companyLogo'],87,50)?>"></a></li>
            <?php endforeach;?>
        </ul>
        <div class="list-more"><a href="/bidder/list.html">查看更多投标人</a></div>
    </div>
</div>
<block name="script">
<script type="text/javascript">
    $(function(){
        $(".ban").slide({mainCell:".bd ul",autoPlay:true,effect:"leftLoop",autoPage:true,titCell:".hd ul"})
//        $(".tips").slide({mainCell:".bd ul",autoPlay:true,effect:"topLoop"});

        $(".searchInput").focus(function(event) {
            $(this).parents(".search-box").addClass('focus')
        });
        $(".searchInput").blur(function(event) {
            $(this).parents(".search-box").removeClass('focus')
        });
        
        $("#bidder").click(function(){
            $("#myform").attr('action', "/bidder/list.html");
            $("#myform").submit();
        });
        
        $("#project").click(function(){
            $("#myform").attr('action', "/project/list.html");
            $("#myform").submit();
        });

    })
</script>
</block>