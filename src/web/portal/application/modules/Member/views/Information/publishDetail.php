<div class=" main">
    <div class="miancont ">
        <div class="tit2">发布信息详情</div>
        <div class="fanganInfo padb30">
            <table>
                <tr class="tr-bg1">
                    <td class="lab">地区</td>
                    <td class="value"><?=isset($result)?$result['district']:''?></td>
                </tr>
                <tr>
                    <td class="lab">项目名称</td>
                    <td class="value"><?=isset($result)?$result['objectName']:''?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">地址</td>
                    <td class="value"><?=isset($result)?$result['address']:''?></td>
                </tr>
                <tr>
                    <td class="lab">工期</td>
                    <td class="value"><?=isset($result)?$result['projectPeriod']:''?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">造价</td>
                    <td class="value"><?=isset($result)?$result['objectAmount']:''?></td>
                </tr>
                <tr>
                    <td class="lab">阶段</td>
                    <td class="value"><?=isset($result)?$result['phase']:''?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">类别</td>
                    <td class="value"><?=isset($result)?$result['objectType']:''?></td>
                </tr>
                <tr>
                    <td class="lab">概况</td>
                    <td class="value"><?=isset($result)?$result['projectSituation']:''?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">甲方</td>
                    <td class="value"><?=isset($result)?$result['employer']:''?></td>
                </tr>
                <tr>
                    <td class="lab">评论</td>
                    <td class="value">
                        <table>
                            <?php foreach($result['comments'] as $item):  ?>
                                <tr>

                                    <td class="text-left"><?=$item['replierName']?>

                                        <br> <?= date('Y-m-d', strtotime($item['replyTime'])) ?></td>
                                    <td class="value"><?=$item['replyContent']?></td>
                                </tr>
                            <?php endforeach; ?>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <!--list-->
</div>
<block>
    <link href="/css/jquery.datetimepicker.css" rel="stylesheet" type="text/css" />
</block>
<block name="script">
    <script>
        $(function(){

        })

    </script>

</block>