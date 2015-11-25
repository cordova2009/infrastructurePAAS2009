<!--ban-->
<div class="ban">
    <div class="search-cont">
        <form class="left search-box">
            <input type="text" placeholder="输入搜索信息" class="searchInput">
            <input type="button" class="searchBtn" value="">
        </form>
        <a href="#" class="btn1">找投标人</a>
        <a href="#"  class="btn1">找工程</a>
    </div>

    <div class="bd">
        <ul>
            <li><img src="uploads/ban1.jpg"></li>
            <li><img src="uploads/ban2.jpg"></li>
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
                        <p class="txt2">人人贷理财华丽升级，全面开启WE理财时代（www.we.com），新品牌为您打造始终如一的专业理财服务。</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pic"><img src="images/in-p1.jpg" ></div>
                        <div class="txt1">中间担保交易</div>
                        <p class="txt2">人人贷理财华丽升级，全面开启WE理财时代（www.we.com），新品牌为您打造始终如一的专业理财服务。</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="pic"><img src="images/in-p3.jpg" ></div>
                        <div class="txt1">严格资质审核</div>
                        <p class="txt2">人人贷理财华丽升级，全面开启WE理财时代（www.we.com），新品牌为您打造始终如一的专业理财服务。</p>
                    </a>
                </li>
            </ul>
        </div>
        <div class="tips-cont clear">
            <div class="tips left">
                <div class="bd">
                    <ul>
                        <li>
                            <p class="left"><a href="#">XXXXX      公告11</a></p>
                            <span class="right">2015-12-30</span>
                        </li>
                    </ul>
                </div>
            </div>
            <a href="#" class="more right">更多公告</a>
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
                    <td class="td1 text-center">项目标题</td>
                    <td class="td2">招标人</td>
                    <td class="td3">招标人信用</td>
                    <td class="td4">评估金额</td>
                    <td class="td5">工程计划开始时间</td>
                    <td class="td6">工期要求</td>
                    <td></td>
                </tr>
                <?php foreach($object_list as $item):?>
                <tr>
                    <td class="td1">XXXXXXXXXXX工程</td>
                    <td class="td2">公司简称</td>
                    <td class="td3"><span class="tag2">A</span></td>
                    <td class="td4">1500,000 <span class="fz12">元</span></td>
                    <td class="td5">2015-12-1</td>
                    <td class="td6">180天</td>
                    <td><a href="#" class="toubiao">投标</a></td>
                </tr>
                <?php endforeach;?>
            </table>
            <div class="list-more"><a href="#">查看更多招标项目</a></div>
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
                    <span class="fz100">10</span><span class="left dw">个</span>
                </div>
            </div>
            <div class="left txt2">
                <span class="left tag-txt2">中标<br>累计金额</span>
                <div class="left num">
                    <span class="fz100">8080</span><span class="fz87">万</span><span class="left dw">元</span>
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
                <tr>
                    <td  class="name"><span class="tag">土</span>XXXXXXXXXXX工程</td>
                    <td class="tenderee" class="tenderee">张翠山</td>
                    <td class="tenderee">张翠山</td>
                    <td class="price">1500,000 <span class="fz12">元</span></td>
                    <td class="info"><a href="#"><i class="ico i-eye"></i></a></td>
                </tr>
                <tr>
                    <td  class="name"><span class="tag">土</span>XXXXXXXXXXX工程</td>
                    <td class="tenderee">张翠山</td>
                    <td class="tenderee">张翠山</td>
                    <td class="price">1500,000 <span class="fz12">元</span></td>
                    <td class="info"><a href="#"><i class="ico i-eye"></i></a></td>
                </tr>
                <tr>
                    <td  class="name"><span class="tag">土</span>XXXXXXXXXXX工程</td>
                    <td class="tenderee">张翠山</td>
                    <td class="tenderee">张翠山</td>
                    <td class="price">1500,000 <span class="fz12">元</span></td>
                    <td class="info"><a href="#"><i class="ico i-eye"></i></a></td>
                </tr>
                <tr>
                    <td  class="name"><span class="tag">土</span>XXXXXXXXXXX工程</td>
                    <td class="tenderee">张翠山</td>
                    <td class="tenderee">张翠山</td>
                    <td class="price">1500,000 <span class="fz12">元</span></td>
                    <td class="info"><a href="#"><i class="ico i-eye"></i></a></td>
                </tr>
            </table>
            <div class="list-more"><a href="#">查看更多中标结果</a></div>
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
                    <span class="fz100">888</span><span class="left dw">家</span>
                </div>
            </div>
            <div class="left txt2">
                <span class="left tag-txt2 padt30">二级资质</span>
                <div class="left num">
                    <span class="fz100">999</span><span class="left dw">家</span>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="bgf best-toubiao">
    <div class="cent  padb20">
        <div class="in-tit1">优质投标人</div>
        <ul class="clear">
            <li><a href="#"><img src="images/tb1.jpg"></a></li>
            <li><a href="#"><img src="images/tb2.jpg"></a></li>
            <li><a href="#"><img src="images/tb3.jpg"></a></li>
            <li><a href="#"><img src="images/tb4.jpg"></a></li>
            <li><a href="#"><img src="images/tb5.jpg"></a></li>
            <li><a href="#"><img src="images/tb6.jpg"></a></li>
            <li><a href="#"><img src="images/tb7.jpg"></a></li>
            <li><a href="#"><img src="images/tb8.jpg"></a></li>
            <li><a href="#"><img src="images/tb9.jpg"></a></li>
            <li><a href="#"><img src="images/tb10.jpg"></a></li>
            <li><a href="#"><img src="images/tb11.jpg"></a></li>
            <li><a href="#"><img src="images/tb12.jpg"></a></li>
            <li><a href="#"><img src="images/tb13.jpg"></a></li>
            <li><a href="#"><img src="images/tb14.jpg"></a></li>
        </ul>
        <div class="list-more"><a href="#">查看更多投标人</a></div>
    </div>
</div>
<block>
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

    })
</script>
</block>