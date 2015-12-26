<div class=" main">
    <!--标的信息-->
    <div class="biaodi_info">
        <div class="tit3">标的信息</div>
        <div class="clear padt10">
            <div class="left txtcont">
                <div class="txt1"><?=$survey['objectName']?></div>
                <div class="txt2">已有 <span class="orange fz64"><?=$survey['bidderNum']?></span>家公司参与投标</div>
            </div>
            <div class="left txtcont">
                <div class="txt3">最高投标价格 <span class="padl30"><?=price_format($survey['maxBidAmount'])?>元</span></div>
                <div class="txt3">最低投标价格 <span class="padl30"><?=price_format($survey['minBidAmount'])?>元</span></div>
            </div>
            <span class="right">
                <img src="/images/pingbiao.png" alt="">
            </span>
        </div>
    </div>

    <div class="box pad0 mart20" id="bidderid">
        <div class="tit3">
            <a href="javascript:;" class="right btn-orange " data-toggle="modal" data-target="#xzzb">选择中标人</a>
            投标人列表
        </div>
        <div class="table   mart20">
            <table>
                <tbody>
                    <tr class="bg2 thead">
                        <td class="wid160 padl20 text-left">投标公司</td>
                        <td class="wid110 text-right">投标金额 </td>
                        <td class="wid150 padm10">资质</td>
                        <td class="wid100">开工日期</td>
                        <td class="wid100">工期</td>
                        <td class="wid100">投标时间</td>
                        <td class="wid100">投标文件 </td>
                        <td>查看 </td>
                    </tr>
                    <?php foreach($list as $v):?>
                    <tr>
                        <td class="padl20 text-left"><?=$v['bidderCompanyName']?></td>
                        <td class="text-right"><span><?=price_format($v['bidAmount'])?></span>元</td>
                        <td class="blue"><i class="ico i-ok4"></i><br><?=$v['certificationList'][0]['certificationName']?></td>
                        <td><?=$v['projectExpectStartDate']?></td>
                        <td><?=$v['projectExpectPeriod']?>天</td>
                        <td><?=$v['bidTime']?></td>
                        <td><a href="<?=get_qiniu_file_durl($v['fileUrl'])?>" class="blue">下载</a></td>
                        <td><a target="_blank" href="<?=U('/company/index',['company_id'=>$v['bidderId'],'type'=>'BER'])?>" ><i class="ico i-eye3"></i></a></td>
                    </tr>
                    <?php endforeach;?>
                </tbody>
            </table>
        </div>
    </div>
    <div class="box_tips hide">
        <i class="ico i-tips"></i> 您已选择了
        <span class="blue" id="names"></span>
        为中标人，请选择付款方式~
        <button class="btn-green right" id="re-choose" type="button">重新选择</button>
    </div>

    <div class="box pad0 mart30">
        <div class="tit3">付款方式</div>
        <div class="pad20">
            <div class="tab_box2">
                <div class="hd tab2_tit clear">
                    <ul>
                        <li class="on" data-type="PID">分期付款</li>
                        <li data-type="MON">按月付款</li>
                        <li data-type="ONE">一次性付清</li>
                        <li data-type="CUM">自定义付款</li>
                    </ul>
                </div>
                <form action="<?=U('survey')?>" method="post" class="ajax-form" >
                    <div class="bd pay_form ">
                        <div class="pay_way">
                            <ul class="clear">
                                <li>
                                    <div class="cell">
                                        <span class="left lab">首款</span>
                                        <input type="text" name="paySum_pid[]" class="input1 left price_format">
                                        <span class="left">元</span>
                                    </div>
                                    <div class="cell">
                                        <span class="left lab">付款时间</span>
                                        <input type="text" name="payDate_pid[]" class="input1 left datepicker" readonly>
                                        <input type="hidden" name="period_pid[]" value="1">
                                    </div>
                                </li>
                            </ul>
                            <div class="box_add">
                                <a href="javascript:;" class="btnAdd" data-num="1" data-show="1" data-type="pid" >
                                    添加期数
                                    <i class="ico i-add"></i>
                                </a>
                            </div>
                            <div class="box_totle">
                                共 <span class="fz36 qi">1</span> 期
                                <span class="blue fz36 marl100 rmb">0</span>元
                            </div>
                        </div>
                        <!--按月-->
                        <div class="pay_way hide">
                            <ul class="clear">
                                <li>
                                    <div class="cell">
                                        <span class="left lab">第1个月</span>
                                        <input type="text" class="input1 left price_format" name="paySum_mon[1]">
                                        <span class="left">元</span>
                                    </div>
                                    <div class="cell">
                                        <span class="left lab">付款时间</span>
                                        <input type="text" class="input1 left datepicker" name="payDate_mon[1]" readonly>
                                        <input type="hidden" name="period_mon[1]" value="1">
                                    </div>
                                </li>
                            </ul>
                            <div class="box_add">
                                <a href="javascript:;" class="btnAdd" data-num="1" data-show="1" data-type="mon" >添加期数 <i class="ico i-add" ></i></a>
                            </div>
                            <div class="box_totle">
                                共 <span class="fz36 yue">1</span> 月
                                <span class="blue fz36 rmb marl100">0</span>元
                            </div>

                        </div>
                        <!--一次性付清-->
                        <div class="pay_way hide">
                            <div class="txt1 text-center">付款总金额<span class="fz36 blue rmb">0</span>元</div>
                            <div class="text-center padt20">
                                <span class=" lab">付款时间</span>
                                <input type="text" class="input1  datepicker" name="payDate_one" readonly>
                            </div>
                        </div>
                        <!--自定义付款-->
                        <div class="pay_way hide" >
                            <ul class="clear">
                                <li>
                                    <div class="cell">
                                        <span class="left "><input type="text" placeholder="首款/第一期" class="input1 wid90"></span>
                                        <input type="text" class="input1 left wid180 price_format" name="paySum_cum[1]">
                                        <input type="hidden" name="period_cum[1]" value="1">
                                        <span class="left">元</span>
                                    </div>
                                    <div class="cell">
                                        <span class="left lab">付款时间</span>
                                        <input type="text" class="input1 left datepicker" name="payDate_cum[1]" readonly>
                                    </div>
                                </li>
                            </ul>
                            <div class="box_add">
                                <a href="javascript:;" class="btnAdd" data-num="1" data-show="1" data-type="cum">添加期数 <i class="ico i-add" ></i></a>
                            </div>
                            <div class="box_totle">
                                共 <span class="fz36 qi">1</span> 期             <span class="blue fz36 rmb marl100">0</span>元
                            </div>

                        </div>
                    </div>
                    <div class="text-center " style="margin-top:8px;">
                        <input type="hidden" name="winBidId" id="winBidId" value="">
                        <input type="hidden" name="objectId" id="objectId" value="<?=$objectId?>">
                        <input type="hidden" value="" name="payPeriod_cum" id="payPeriod_cum">
                        <input type="hidden" value="" name="payPeriod_pid" id="payPeriod_pid">
                        <input type="hidden" value="" name="payPeriod_mon" id="payPeriod_mon">
                        <input type="hidden" value="PID" name="payType" id="payType">
                        <input type="submit" value="提&nbsp;&nbsp;交" class="btn-green">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--list-->
</div>

<div class="modal xzzb hide" id="xzzb">
    <div class="modal-cont">
        <div class="txt1">请选择中标人</div>
        <div class="table">
            <table>
                <tbody><tr class="bg2 thead">
                    <td class="wid160 padl20 text-left">投标公司  </td>
                    <td class="wid140 text-right">投标金额 </td>
                    <td class="wid120">竣工日期</td>
                    <td>中标 </td>
                </tr>
                <?php foreach($list as $v){?>
                    <tr class="">
                        <td class="padl20 text-left"><?=$v['bidderCompanyName']?></td>
                        <td class="text-right"><span><?=price_format($v['bidAmount'])?></span>元</td>
                        <td><?=$v['projectExpectStartDate']?></td>
                        <td><a href="javascript:;"><i class="ico i-ok5" data-id="<?=$v['bidId']?>"></i></a></td>
                    </tr>
                <?php } ?>
                </tbody>
            </table>
            <div class="text-center padv30">
                <a href="javascript:;" class="btn-green" data-miss="modal" id="ok">确定</a>
                <a href="javascript:;" class="btn-green" data-miss="modal" style=" margin-left: 6px; ">取消</a>
            </div>
        </div>
    </div>
</div>

<div class="temp-li0 hide">
    <ul>
        <li>
            <div class="cell">
                <span class="left lab">第<span class="num"></span>期</span>
                <input type="text" class="input1 left price_format" id="paySum_pid">
                <span class="left">元</span>
            </div>
            <div class="cell">
                <span class="left lab">付款时间</span>
                <input type="text" class="input1 left datepicker after_time" before="select_date_before" alert_text="前一期的日期" id="payDate_pid" readonly>
                <input type="hidden" id="period_pid" value="">
            </div>
        </li>
    </ul>
</div>
<div class="temp-li1 hide">
    <ul>
        <li>
            <div class="cell">
                <span class="left lab">第<span class="num"></span>个月</span>
                <input type="text" class="input1 left price_format" id="paySum_mon">
                <span class="left">元</span>
            </div>
            <div class="cell">
                <span class="left lab">付款时间</span>
                <input type="text" class="input1 left datepicker after_time" before="select_date_before" alert_text="前一月的日期" id="payDate_mon" readonly>
                <input type="hidden" id="period_mon" value="">
            </div>
        </li>
    </ul>
</div>
<div class="temp-li3 hide">
    <ul>
        <li>
            <div class="cell">
                <span class="left ">
                    <input type="text" placeholder="首款/第一期" class="input1 wid90">
                </span>
                <input type="text" class="input1 left wid180 price_format" id="paySum_cum">
                <span class="left">元</span>
            </div>
            <div class="cell">
                <span class="left lab">付款时间</span>
                <input type="text" class="input1 left datepicker after_time" before="select_date_before" alert_text="前一期的日期" id="payDate_cum" readonly>
                <input type="hidden" id="period_cum" value="">
            </div>
        </li>
    </ul>
</div>
<block name="script">
    <script type="text/javascript">
        $(function(){
            $(".tab_box2").slide({mainCell:".bd ",effect:"fade",trigger:"click"});
            $('.i-ok5').click(function(event) {
                $(".i-ok5").removeClass('on');
                $(this).addClass('on');
                $('#winBidId').val($(this).data('id'));
                var tmp = $(this).parent().parent(). siblings().eq(0).html()
                $('#names').html(tmp);
                var tmp = $(this).parent().parent(). siblings().eq(1).find('span').eq(0).html()
                $('.rmb').html(tmp);
            });

            $("#ok").click(function (){
                if($(".i-ok5.on").length==0)
                {
                    return;
                }
                $(".box_tips").show();
                $("#bidderid").hide();
            });

            $("#re-choose").click(function(){
                $(".box_tips").hide();
                $("#bidderid").fadeIn();
            });

            $(".tab2_tit").find('li').click(function (){
                $("#payType").val($(this).data('type'));
            });

            $(".btnAdd").click(function() {
                var i = $(this).attr("data-show")
                i++;
                num = i;
                $(this).attr("data-num",num)
                $(this).attr("data-show",i)
                var ind = $(this).parents(".pay_way").index();
                var type= $(this).data("type");
                $(".temp-li"+ind).find(".num").html(num)
                $(".temp-li"+ind).find('input').each(function (index,e){
                    e.name= e.id+'[]';
                    if(e.id=='period_cum'||e.id=='period_pid'||e.id=='period_mon'){
                        e.value=i;
                    }
                });
                var html = $(".temp-li"+ind).find("ul").html();
                $("#payPeriod_"+type).val(i);
                $(this).parents(".pay_way").find('ul').append(html);
                $(this).parents(".pay_way").find('span.qi').html(i);
            });
        });

        var my_97_custom_settings = {minDate:'<?=date('Y-m-d')?>'};
        function select_date_before(obj){
            var prev_picker = obj.closest('li').prev().find('.datepicker');
            var prev_val = null;
            if(prev_picker.length > 0){
                prev_val = prev_picker.val();
            }
            return prev_val;
        }
    </script>
    <script src="/js/My97DatePicker/WdatePicker.js"></script>
</block>