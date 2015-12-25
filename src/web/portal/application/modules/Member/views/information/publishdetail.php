<div class=" main">
    <div class="miancont ">
        <div class="tit2 clear">
            <span class="left txt2">发布信息详情</span>

        </div>
        <div class="fanganInfo padb30">
            <table>
                <tr class="tr-bg1">
                    <td class="lab">地区</td>
                    <td class="value"><?=isset($result['district'])?$result['district']:'未填写'?></td>
                </tr>
                <tr>
                    <td class="lab">项目名称</td>
                    <td class="value"><?=isset($result['objectName'])?$result['objectName']:'未填写'?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">地址</td>
                    <td class="value"><?=isset($result['address'])?$result['address']:'未填写'?></td>
                </tr>
                <tr>
                    <td class="lab">工期</td>
                    <td class="value"><?=isset($result['projectPeriod'])?$result['projectPeriod']:'未填写'?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">造价</td>
                    <td class="value"><?=isset($result['objectAmount'])?$result['objectAmount']:'未填写'?></td>
                </tr>
                <tr>
                    <td class="lab">阶段</td>
                    <td class="value"><?=isset($result['phase'])?$result['phase']:'未填写'?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">类别</td>
                    <td class="value"><?=isset($result['objectType'])?$result['objectType']:'未填写'?></td>
                </tr>
                <tr>
                    <td class="lab">概况</td>
                    <td class="value"><?=isset($result['projectSituation'])?$result['projectSituation']:'未填写'?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">甲方</td>
                    <td class="value"><?=isset($result['employer'])?$result['employer']:'未填写'?></td>
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
                <tr>
                    <td class="lab"></td>
                    <td class="value">
                        <div class="left clear">
                            <?=$user['nickname']?>
                            <br>
                            <span >
                            <?= date('Y-m-d',time()) ?>
                            </span>
                        </div>
                        <div class="left">
                            <form action="<?=U('/member/Information/publishDetail')?>" method="post" class="ajax-form">
                            <input type="hidden" name="informationId" value="<?=$result['informationId']?>">
                            <textarea id="" name="replyContent" class="textarea"></textarea>
                            <br >
                            <span class="right">
                                <button type="submit" class="down" >发表评论</button>
                            </span>
                            </form>
                        </div>
                        <div class="right" style="width: 200px;">
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