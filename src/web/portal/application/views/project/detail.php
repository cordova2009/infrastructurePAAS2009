<div class=" main">
    <!--company-->
    <div class="box pad0 zbxm_info">
        <div class="tit5"><?= $info['detail']['baseInfo']['objectName'] ?>（编号：<?= $info['detail']['baseInfo']['biddingNo'] ?>）</div>
        <div class="clear">
            <div class="left leftBox">
                <div class="table">
                    <div class="cell leibie">
                        <div class="txt1"><span class="tag3">土</span> <?php //echo $info['detail']['bidderCertificationInfo']['industryName'] ?></div>
                        <div class="txt2">工程类别</div>
                    </div>
                    <div class="cell gujia">
                        <div class="txt1"><span class="orange"><?= $info['detail']['baseInfo']['evaluationAmount'] ? $info['detail']['baseInfo']['evaluationAmount'] : 0 ?></span> <span class="fz20">元</span></div>
                        <div class="txt2">标的估价</div>
                    </div>
                    <div class="cell gongqi">
                        <div class="txt1"><?= $info['detail']['projectRequirementInfo']['projectExpectPeriod'] ?><span class="fz20">天</span></div>
                        <div class="txt2">工程工期</div>
                    </div>
                </div>
                <div class="table txtCont2">
                    <div class="cell wdi50">
                        <div class="clear">
                            <div class="lab">公告起始时间 </div>
                            <div class="value"><?= $info['detail']['dateRequirementInfo']['announcementBeginTime'] ?></div>
                        </div>
                        <div class="clear">
                            <div class="lab">公告截止时间 </div>
                            <div class="value"><?= $info['detail']['dateRequirementInfo']['announcementEndTime'] ?></div>
                        </div>
                    </div>
                    <div class="cell ">
                        <div class="clear">
                            <div class="lab">工程地址 </div>
                            <div class="value"><?= $info['detail']['projectInfo']['projectSite'] ?></div>
                        </div>
                        <div class="clear">
                            <div class="lab">保证金 </div>
                            <div class="value"><?= $info['detail']['bondInfo']['bidBondAmount'] ?>元</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="right rightBox">
                <div class="time"><?= $info['survey']['biddingEndTime'] ?></div>
                <div class="txt2">截止时间</div>
                <div class="txt3 blue fz36"><?= $info['survey']['bidderNum'] ?></div>
                <div class="txt4">投标公司</div>
            </div>
        </div>
    </div>

    <div class="box mart30 pad0">
        <div class="padm20"><div class="tit5">标的进度</div></div>
        <div class="biaodi-step">
            <ul class="clear">
                <li class="first active">
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">dfasdfds<br>招标发布</span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt"><?= $info['detail']['dateRequirementInfo']['announcementEndTime'] ?><br>公告截止</span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt"><?= $info['detail']['dateRequirementInfo']['biddingEndTime'] ?><br>投标截止</span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt"><?= $info['detail']['dateRequirementInfo']['bidOpenDate'] ?><br>开标</span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt"><?= $info['detail']['projectRequirementInfo']['projectExpectStartDate'] ?><br>工程开始</span>
                </li>
                <li class="last">
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">adsfadf<br>工程结束</span>
                </li>
            </ul>
        </div>
    </div>
    <div class="box pad0 mart30">
        <div class="tab_box">
            <div class="hd tab_tit clear">
                <ul>
                    <li class="on">标的概况</li>
                    <li >常见问题</li>
                </ul>
            </div>
            <div class="bd">
                <div class="comInfo-table">
                    <table>
                        <tr>
                            <td class="lab">招标项目名称</td>
                            <td class="value"><?= $info['detail']['baseInfo']['objectName'] ?></td>

                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标项目编号</td>
                            <td class="value"><?= $info['detail']['baseInfo']['biddingNo'] ?> </td>

                        </tr>
                        <tr>
                            <td class="lab">招标项目范围</td>
                            <td class="value"> <?= $info['detail']['baseInfo']['objectScope'] ?> </td>

                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标经办人</td>
                            <td class="value"> <?= $info['detail']['baseInfo']['biddeeCompanyPrincipal'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标办公电话</td>
                            <td class="value"> <?= $info['detail']['baseInfo']['biddeeCompanyTelephone'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">采用币种</td>
                            <td class="value"> <?= $info['detail']['baseInfo']['currency'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">标的估价</td>
                            <td class="value"> <?= $info['detail']['baseInfo']['evaluationAmount'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">承包方式</td>
                            <td class="value"> <?= $info['detail']['baseInfo']['contractType'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">工程名称</td>
                            <td class="value"> <?= $info['detail']['projectInfo']['projectName'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">工程地点</td>
                            <td class="value"> <?= $info['detail']['projectInfo']['projectSite'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">工程规模及特征</td>
                            <td class="value"> <?= $info['detail']['projectInfo']['projectScale'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">建设单位</td>
                            <td class="value"> <?= $info['detail']['projectInfo']['employer'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">建设单位经办人</td>
                            <td class="value"> <?= $info['detail']['projectInfo']['employerPrincipal'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">建设单位联系电话</td>
                            <td class="value"> <?= $info['detail']['projectInfo']['employerTelephone'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">国有土地使用证</td>
                            <td class="value">xxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">建设用地规划许可证</td>
                            <td class="value">xxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">计划开工日期</td>
                            <td class="value"> <?= $info['detail']['projectRequirementInfo']['projectExpectStartDate'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">标准工期</td>
                            <td class="value"> <?= $info['detail']['projectRequirementInfo']['projectExpectPeriod'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">投标人资质等级要求</td>
                            <td class="value">xxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">投标人项目经理(建造师)要求</td>
                            <td class="value">xxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">投标担保金额</td>
                            <td class="value"> <?= $info['detail']['bondInfo']['bidBondAmount'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标方式</td>
                            <?php $objectMethod = ['PUB' => '公开招标', 'INVI' => '邀请投标']; ?>
                            <td class="value"> <?= $objectMethod[$info['detail']['objectMethodInfo']['objectMethodInfo']] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">资格审查文件电子标书1份</td>
                            <td class="value">xxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">商务标部分电子标书1份</td>
                            <td class="value">xxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">答疑方式</td>
                            <td class="value">
                                <?php if($info['detail']['answerQuestion']['qq']): ?>QQ疑答，QQ群号<?= $info['detail']['answerQuestion']['qq'] ?> <?php endif; ?> 
                                <?php if($info['detail']['answerQuestion']['email']): ?>&nbsp;&nbsp;&nbsp;email疑答，答疑邮件<?= $info['detail']['answerQuestion']['email'] ?> <?php endif; ?> 
                                &nbsp;&nbsp;&nbsp;&nbsp;<?= $info['detail']['answerQuestion']['startTime'] . ' － ' . $info['detail']['answerQuestion']['endTime'] . $info['detail']['answerQuestion']['address'] ?>
                            </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标时间要求</td>
                            <td class="value"> <?= $info['detail']['dateRequirementInfo']['bidOpenDate'] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">评标方法及标准</td>
                            <?php $evaluationType = ['QLT' => '定性', 'CRE' => '信用商户评价', 'OVE' => '综合评估']; ?>
                            <td class="value"> <?= $evaluationType[$info['detail']['bidEvaluationTypeInfo']['bidEvalutionType']] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">技术标评标地点</td>
                            <td class="value"> <?= $info['detail']['bidEvaluationTypeInfo']['bidEvalutionSite'] ?> </td>
                        </tr
                        <tr class="tr-bg1">
                            <td class="lab">中标人的确定方法</td>
                            <?php $bidWinnerDetermineWay = ['ORV' => '直接票决定标', 'MRV' => '逐轮票决定标', 'VDM' => '票决筹钱定标']; ?>
                            <td class="value"> <?= $bidWinnerDetermineWay[$info['detail']['bidEvaluationTypeInfo']['bidWinnerDatemineWay']] ?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">票决方式</td>
                            <?php $voteWinWay = ['SMP' => '简单铎书法', 'CPN' => '对比胜出法']; ?>
                            <td class="value"> <?= $voteWinWay[$info['detail']['bidEvaluationTypeInfo']['voteWinWay']] ?> </td>
                        </tr>
                    </table>
                </div>
                <div class="ques">
                    <p>1. 什么是薪计划？</p>

                    <p>薪计划是人人贷针对工薪族推出的高效、便捷的自动投标工具，每月固定日期加入固定资金，轻松攒钱同时享受高收益，
                        快速积累财富实现每个心愿。
                    </p>

                    <p>2. 薪计划的发布时间？</p>

                    <p>每月1-25号上午10:30。</p>

                    <p>3. 薪计划的收益有多少？</p>

                    <p>预期年化收益率9%，但根据系统自动投资标的利率不同，每个投资人间的预期收益率存在小许差异。</p>

                    <p>4. 薪计划的期限有多久？</p>

                    <p>薪计划的锁定期为12个月，在锁定期内薪计划的回款本息由系统自动实现循环复投，充分提高资金利用效率，
                        锁定期结束后自动通过债权转让退出。薪计划不支持提前退出。
                    </p>

                    <p>5. 到了每月投资日该如何支付？</p>

                    <p>
                        a.系统自动划扣：您可以在每月投资日前将相应金额充值到人人贷账户，在每月投资日当天24:00系统会从您的人人贷账户中自动划扣完成支付。
                        <br>
                        b.手动支付：每月投资日前的3天，您也可以在充值后主动进行手动支付；进入【我的人人贷】-【理财管理】-【薪计划】，
                        选择您要支付的一期薪计划，点击【立即支付】即可。
                    </p>

                    <p>6. 每月投资日和每月投资金额是否支持修改？</p>

                    <p>不支持修改。<br>
                        每月投资日和每月投资金额由首次加入薪计划时确定，后续月份须按时投入相同金额。<br>
                        请您在充分考虑自身理财需求后慎重决定。
                    </p>

                    <p>7. 如果未能按时支付每月投资金额会有什么影响？</p>

                    <p>若您的薪计划累计延期超过10天，则会产生相应延期费用，具体请参考薪计划延期费用。</p>
                </div>
            </div>
        </div>
    </div>
    <div class="text-right">
        <a href="#" class="pad5 color8">举报</a>
    </div>
    <!--list-->

</div>