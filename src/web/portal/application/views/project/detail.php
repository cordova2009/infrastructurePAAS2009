<div class=" main">
    <!--company-->
    <div class="box pad0 zbxm_info">
        <div class="tit5"><?=isset($baseInfo)?$baseInfo['objectName']:''?>（编号：<?=isset($info)?$info['objectId']:''?>）</div>
        <div class="clear">
            <div class="left leftBox">
                <div class="table">
                    <div class="cell leibie">
                        <div class="txt1"><span class="tag3">土</span> 土石方</div>
                        <div class="txt2">工程类别</div>
                    </div>
                    <div class="cell gujia">
                        <div class="txt1"><span class="orange"><?=isset($survey['evalutionAmount'])?price_format($survey['evalutionAmount']):'0'?></span> <span class="fz20">元</span></div>
                        <div class="txt2">标的估价</div>
                    </div>
                    <div class="cell gongqi">
                        <div class="txt1"><?=isset($projectRequirementInfo['projectExpectPeriod'])?$projectRequirementInfo['projectExpectPeriod']:'0'?><span class="fz20">天</span></div>
                        <div class="txt2">工程工期</div>
                    </div>
                </div>
                <div class="table txtCont2">
                    <div class="cell wdi50">
                        <div class="clear">
                            <div class="lab">公告截止时间 </div>
                            <div class="value"><?=date('Y-m-d',strtotime($survey['announcementEndTime']))?></div>
                        </div>
                        <div class="clear">
                            <div class="lab">投标截止时间 </div>
                            <div class="value"><?=date('Y-m-d',strtotime($survey['biddingEndTime']))?></div>
                        </div>
                    </div>
                    <div class="cell ">
                        <div class="clear">
                            <div class="lab">工程地址 </div>
                            <div class="value"><?=isset($projectInfo['projectSite'])?$projectInfo['projectSite']:'未填写'?></div>
                        </div>
                        <div class="clear">
                            <div class="lab">保证金 </div>
                            <div class="value"><?=isset($bondInfo['bidBondAmount'])?price_format($bondInfo['bidBondAmount']).'元':'未填写'?></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="right rightBox">
                <div class="time"><?=$daojishi?></div>
                <div class="txt2">截止时间</div>
                <div >
                    <div class="txt3 blue fz36"><?=isset($survey['bidderNum'])?$survey['bidderNum']:'未填写'?>
                        <?php if($info['status']=='PUB'){?>
                        <div class="text-center padt30 right">
                            <a href="<?=U('/member/bid/requirement',['objectId'=>$info['objectId']])?>" class="btn-green4">我要投标</a>
                        </div>
                        <?php }?>
                    </div>
                    <div class="txt4">投标公司</div>
                </div>

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
                    <span class="txt">
                        <?=isset($dateRequirementInfo['announcementBeginTime'])?time_format(strtotime($dateRequirementInfo['announcementBeginTime']),'Y-m-d'):'未填写'?>
                        <br>招标发布
                    </span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">
                        <?=isset($dateRequirementInfo['announcementEndTime'])?time_format(strtotime($dateRequirementInfo['announcementEndTime']),'Y-m-d'):'未填写'?>
                        <br>公告截止
                    </span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">
                        <?=isset($dateRequirementInfo['biddingEndTime'])?time_format(strtotime($dateRequirementInfo['biddingEndTime']),'Y-m-d'):'未填写'?>
                        <br>投标截止
                    </span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">
                        <?=isset($dateRequirementInfo['bidOpenDate'])?time_format(strtotime($dateRequirementInfo['bidOpenDate']),'Y-m-d'):'未填写'?>
                        <br>开标
                    </span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">
                        <?=isset($projectRequirementInfo['projectExpectStartDate'])?$projectRequirementInfo['projectExpectStartDate']:'未填写'?>
                        <br>工程开始
                    </span>
                </li>
                <li class="last">
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">
                        <br>工程结束
                    </span>
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
                            <td class="value" ><?=isset($baseInfo['objectName'])?$baseInfo['objectName']:'未填写'?></td>

                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标项目编号</td>
                            <td class="value"><?=isset($baseInfo['biddingNo'])?$baseInfo['biddingNo']:'未填写'?></td>

                        </tr>
                        <tr>
                            <td class="lab">招标项目范围</td>
                            <td class="value"><?=isset($baseInfo['objectScope'])?$baseInfo['objectScope']:'未填写'?></td>

                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标经办人</td>
                            <td class="value"><?=isset($baseInfo['biddeeCompanyPrincipal'])?$baseInfo['biddeeCompanyPrincipal']:'未填写'?></td>
                        </tr>
                        <tr >
                            <td class="lab">招标办公电话</td>
                            <td class="value"><?=isset($baseInfo['biddeeCompanyTelephone'])?$baseInfo['biddeeCompanyTelephone']:'未填写'?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">采用币种</td>
                            <td class="value">
                                <?php $currency_list = ['CNY'=>'人民币','USD'=>'美元'];?>
                                <?=$currency_list[$baseInfo['currency']]?>
                            </td>
                        </tr>
                        <tr >
                            <td class="lab">标的估价</td>
                            <td class="value"><?=isset($baseInfo['evaluationAmount'])?price_format($baseInfo['evaluationAmount']).'元':'未填写'?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">承包方式</td>
                            <td class="value"><?=isset($baseInfo['contractType'])?$baseInfo['contractType']:'未填写'?></td>
                        </tr>
                        <tr >
                            <td class="lab">工程名称</td>
                            <td class="value"><?=isset($projectInfo['projectName'])?$projectInfo['projectName']:'未填写'?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">工程地点</td>
                            <td class="value"><?=isset($projectInfo['projectSite'])?$projectInfo['projectSite']:'未填写'?> </td>
                        </tr>
                        <tr >
                            <td class="lab">工程规模及特征</td>
                            <td class="value"><?=isset($projectInfo['projectScale'])?$projectInfo['projectScale']:'未填写'?>  </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">建设单位</td>
                            <td class="value"><?=isset($projectInfo['employer'])?$projectInfo['employer']:'未填写'?>  </td>
                        </tr>
                        <tr >
                            <td class="lab">建设单位经办人</td>
                            <td class="value"><?=isset($projectInfo['employerPrincipal'])?$projectInfo['employerPrincipal']:'未填写'?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">建设单位联系电话</td>
                            <td class="value"><?=isset($projectInfo['employerTelephone'])?$projectInfo['employerTelephone']:'未填写'?></td>
                        </tr>
                        <tr >
                            <td class="lab">国有土地使用证</td>
                            <td class="value"><?=isset($constructionInfo['landUseCertificateNo'])?$constructionInfo['landUseCertificateNo']:'未填写'?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">建设用地规划许可证</td>
                            <td class="value"><?=isset($constructionInfo['constructionLandUsePermitNo'])?$constructionInfo['constructionLandUsePermitNo']:'未填写'?></td>
                        </tr>
                        <tr>
                            <td class="lab">计划开工日期</td>
                            <td class="value"><?=isset($projectRequirementInfo['projectExpectStartDate'])?$projectRequirementInfo['projectExpectStartDate']:'未填写'?>  </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">标准工期</td>
                            <td class="value"><?=isset($projectRequirementInfo['projectExpectPeriod'])?$projectRequirementInfo['projectExpectPeriod'].'天':'未填写'?>  </td>
                        </tr>
                        <tr >
                            <td class="lab">建造师要求</td>
                            <?php $constructorCertification = ['YES' => '需要提供', 'NO#' => '不需要提供']; ?>
                            <td class="value"><?=isset($bidderCertificationInfo['needConstructorCertification'])?$constructorCertification[$bidderCertificationInfo['needConstructorCertification']]:'未填写'?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">项目经理要求</td>
                            <?php $pmCertification = ['YES' => '需要提供', 'NO#' => '不需要提供']; ?>
                            <td class="value"><?=isset($bidderCertificationInfo['needPmCertification'])?$pmCertification[$bidderCertificationInfo['needPmCertification']]:'未填写'?></td>
                        </tr>
                        <tr >
                            <td class="lab">安全生产许可证要求</td>
                            <?php $safetyPermit = ['YES' => '需要提供', 'NO#' => '不需要提供']; ?>
                            <td class="value"><?=isset($bidderCertificationInfo['needSafetyPermit'])?$pmCertification[$bidderCertificationInfo['needSafetyPermit']]:'未填写'?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">项目经理安全生产考核合格证要求</td>
                            <?php $pmSafetyCertification = ['YES' => '需要提供', 'NO#' => '不需要提供']; ?>
                            <td class="value"><?=isset($bidderCertificationInfo['$pmSafetyCertification'])?$pmCertification[$bidderCertificationInfo['$pmSafetyCertification']]:'未填写'?></td>
                        </tr>
                        <tr >
                            <td class="lab">投标担保金额</td>
                            <td class="value"><?=isset($bondInfo['bidBondAmount'])?price_format($bondInfo['bidBondAmount']).'元':'未填写'?>  </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">招标方式</td>
                            <?php $objectMethod = ['PUB' => '公开招标', 'INVI' => '邀请投标']; ?>
                            <td class="value"> <?=isset($objectMethodInfo['objectMethodInfo'])?$objectMethod[$objectMethodInfo['objectMethodInfo']]:'未填写'?> </td>
                        </tr>
                        <tr >
                            <td class="lab">资格审查文件电子标书1份</td>
                            <?php $certificationCheckupFile = ['YES' => '需要提供', 'NO#' => '不需要提供']; ?>
                            <td class="value"><?=isset($bidFileTypeInfo['needCertificationCheckupFile'])?$certificationCheckupFile[$bidFileTypeInfo['needCertificationCheckupFile']]:'未填写'?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">商务标部分电子标书1份</td>
                            <?php $businessStandard = ['YES' => '需要提供', 'NO#' => '不需要提供']; ?>
                            <td class="value"><?=isset($bidFileTypeInfo['needBusinessStandard'])?$businessStandard[$bidFileTypeInfo['needBusinessStandard']]:'未填写'?></td>
                        </tr>
                        <tr >
                            <td class="lab">技术标部分电子标书1份</td>
                            <?php $technicalStandard = ['YES' => '需要提供', 'NO#' => '不需要提供']; ?>
                            <td class="value"><?=isset($bidFileTypeInfo['needCertificationCheckupFile'])?$technicalStandard[$bidFileTypeInfo['needCertificationCheckupFile']]:'未填写'?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">答疑方式</td>
                            <td class="value">
                                <?php if(!empty($answerQuestion['qq'])):?>
                                <div>QQ答疑，QQ群号：<?=$answerQuestion['qq']?>，群口令：<?=$answerQuestion['qqtoken']?></div>
                                <?php endif;?>
                                <?php if(!empty($answerQuestion['email'])):?>
                                <div>邮件答疑，邮箱地址：<?=$answerQuestion['email']?></div>
                                <?php endif;?>
                                <?php if(!empty($answerQuestion['address'])):?>
                                <div>现场答疑，答疑地址：<?=$answerQuestion['address']?>，答疑时间：<?=$answerQuestion['answerTime']?></div>
                                <?php endif;?>
                                <?php if(!empty($answerQuestion['telephone'])):?>
                                <div>电话答疑，联系电话：<?=$answerQuestion['telephone']?></div>
                                <?php endif;?>
                            </td>
                        </tr>
                        <tr>
                            <td class="lab">招标时间要求</td>
                            <td class="value"> <?=isset($dateRequirementInfo['bidOpenDate'])?$info['detail']['dateRequirementInfo']['bidOpenDate']:'未设置'?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">评标方法及标准</td>
                            <?php $evaluationType = ['QLT' => '定性', 'CRE' => '信用商户评价', 'OVE' => '综合评估']; ?>
                            <td class="value"> <?=isset($bidEvaluationTypeInfo['bidEvalutionType'])? $evaluationType[$info['detail']['bidEvaluationTypeInfo']['bidEvalutionType']]:'未设置'?> </td>
                        </tr>
                        <tr>
                            <td class="lab">技术标评标地点</td>
                            <td class="value"> <?=isset($bidEvaluationTypeInfo['bidEvalutionSite'])?$info['detail']['bidEvaluationTypeInfo']['bidEvalutionSite']:'未设置'?> </td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">中标人的确定方法</td>
                            <?php $bidWinnerDetermineWay = ['ORV' => '直接票决定标', 'MRV' => '逐轮票决定标', 'VDM' => '票决筹钱定标']; ?>
                            <td class="value"><?=isset($bidEvaluationTypeInfo['bidWinnerDatemineWay'])?$bidWinnerDetermineWay[$info['detail']['bidEvaluationTypeInfo']['bidWinnerDatemineWay']]:'未设置'?> </td>
                        </tr>
                        <tr >
                            <td class="lab">票决方式</td>
                            <?php $voteWinWay = ['SMP' => '简单铎书法', 'CPN' => '对比胜出法']; ?>
                            <td class="value"> <?=isset($bidEvaluationTypeInfo['voteWinWay'])?$voteWinWay[$info['detail']['bidEvaluationTypeInfo']['voteWinWay']]:'未设置'?> </td>
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
        <a href="javascript:" class="pad5 color8">举报</a>
    </div>
    <!--list-->

</div>