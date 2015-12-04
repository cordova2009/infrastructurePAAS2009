<div class=" main">
    <!--company-->
    <div class="company-pro ">
        <div class="table">
            <div class="cell com-logo"><img src="<?= $info['survey']['logoUrl'] ?>"></div>
            <div class="cell">
                <p class="com-name"><?= $info['survey']['companyName'] ?> <i class="ico i-grade"></i></p>
                <div class="padt5">
                    <span class="">信用等级 <span class="tag2 bg-pink" ><?= $info['survey']['creditRating'] ?></span></span>
                    <span class="padl30">信用积分<span class="padl30"><?= $info['survey']['creditScore'] ?>分</span></span>
                </div>
            </div>
            <div class="cell color8">
                <p>好评度 
                    <?php for($i=1; $i <=5; $i++): ?>
                        <i class="ico i-star <?php if($i > $info['survey']['evaluationRating']) echo 'i-star2' ?>"></i>
                    <?php endfor; ?>
                </p>
                <p>综合得分<span class="padl30"><?= $info['survey']['evaluationScore'] ?>分</span></p>
            </div>
        </div>
    </div>

    <div class="company-info">
        <div class="txt1">公司信息</div>
        <div class="comInfo-tit">基本信息</div>
        <div class="comInfo-table">
            <table>
                <tr>
                    <td class="lab">公司全称</td>
                    <td class="value"><?= $info['baseInfo']['companyName'] ?></td>
                    <td class="lab">联系人</td>
                    <td class="value"><?= $info['baseInfo']['contactName'] ?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">注册资本</td>
                    <td class="value"><?= $info['baseInfo']['registeredCapital'] ?></td>
                    <td class="lab">联系方式</td>
                    <td class="value"><?= $info['baseInfo']['contactMobileNum'] ?></td>
                </tr>
                <tr>
                    <td class="lab">经营范围</td>
                    <td class="value"><?= $info['baseInfo']['businessScope'] ?></td>
                    <td class="lab">公司地址</td>
                    <td class="value"><?= $info['baseInfo']['address'] ?></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">公司成立时间</td>
                    <td class="value"><?= $info['baseInfo']['regTime'] ?></td>
                    <td class="lab">公司邮箱 </td>
                    <td class="value"><?= $info['baseInfo']['email'] ?></td>
                </tr>
                <tr>
                    <td class="lab">公司简介</td>
                    <td class="value" colspan="3">
                        <?= $info['baseInfo']['description'] ?>
                    </td>
                </tr>
            </table>
        </div>
        <div class="comInfo-tit">企业资质</div>
        <div class="comInfo-table">
            <table>
                <?php $count = count($info['certicate']); ?>
                <?php for($i=0; $i < $count; $i +=2): ?>
                    <tr>
                        <?php if(isset($info['certicate'][$i])): ?>
                            <td class="lab"><?= $info['certicate'][$i]['certicateName'] ?></td>
                            <td class="value">
                                <?= $info['certicate'][$i]['certicateNum'] ?>个 
                                <a href="<?= $info['certicate'][$i]['certicateUrl'] ?>"><i class="ico i-eye2"></i></a>
                            </td>
                        <?php endif; ?>
                        <?php if(isset($info['certicate'][$i+1])): ?>
                            <td class="lab"><?= $info['certicate'][$i+1]['certicateName'] ?></td>
                            <td class="value">
                                <?= $info['certicate'][$i+1]['certicateNum'] ?>个 
                                <a href="<?= $info['certicate'][$i+1]['certicateUrl'] ?>"><i class="ico i-eye2"></i></a>
                            </td>
                        <?php endif; ?>
                    </tr>
                <?php endfor; ?>
            </table>
        </div>
        <div class="comInfo-tit">招投标一览</div>
        <div class="comInfo-table">
            <table>
                <tr>
                    <td class="lab">发出的标的</td>
                    <td class="value"><?= $info['bidInfo']['tenderNum'] ?>个</td>
                    <td class="lab">投出的标的</td>
                    <td class="value"><?= $info['bidInfo']['bidNum'] ?>个 </td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">流标</td>
                    <td class="value"><?= $info['bidInfo']['flowNum'] ?>个 </td>
                    <td class="lab">中标</td>
                    <td class="value"><?= $info['bidInfo']['winNum'] ?>个 </td>
                </tr>
                <tr>
                    <td class="lab">按时付款次数</td>
                    <td class="value"> <?= $info['bidInfo']['onTimeNum'] ?>次 </td>
                    <td class="lab"></td>
                    <td class="value"></td>
                </tr>
                <tr class="tr-bg1">
                    <td class="lab">逾期付款次数</td>
                    <td class="value"> <?= $info['bidInfo']['outTimeNum'] ?>次 </td>
                    <td class="lab"></td>
                    <td class="value"> </td>
                </tr>
            </table>
        </div>
        <div class="comInfo-tit">评价一览</div>
        <div class="assess-cont">
            <div class="txt2">
                累计评价<span class="padl20"><?= $info['evaluationInfo']['companyEvaluateNum'] ?></span>
                <div class="assess-tag">
                    <?php foreach($info['evaluationInfo']['tag'] as $tag): ?>
                        <a href="javascript:void(0);"><?= $tag['tagName'] ?>（<?= $tag['tagNum'] ?>）</a>
                    <?php endforeach; ?>
                </div>
            </div>
            <div class="txt3">
                好评度 
                <?php for($i=1; $i <=5; $i++): ?>
                    <i class="ico i-star <?php if($i > $info['evaluationInfo']['companyEvaluateScore']) echo 'i-star2' ?>"></i>
                <?php endfor; ?>
            </div>
            <div class="assess-table">
                <table>
                    <?php foreach($info['evaluationInfo']['list'] as $comp): ?>
                        <tr>
                            <td><?= $comp['evaluationCompanyContent'] ?></td>
                            <td class="name"><?= $comp['evaluationCompanyName'] ?></td>
                            <td class="time"><?= $comp['evaluationCompanyTime'] ?></td>
                        </tr>
                    <?php endforeach; ?>
                </table>
            </div>
        </div>
    </div>

    <!--list-->

</div>
