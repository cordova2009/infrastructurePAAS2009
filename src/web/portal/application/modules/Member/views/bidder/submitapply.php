<div class=" main">
    <form action="<?=U('submitapply')?>" method="post" class="ajax-form" before="subbefor" >
        <!--list-->
        <div class="result-list bgf">
            <div class="tit1">请确定投标人申请信息后提交</div>
            <div class="fanganInfo padb30">
                <table>
                    <tbody><tr class="tr-bg1">
                        <td class="lab">公司（单位）全称</td>
                        <td class="value"><?=$base['companyName']?></td>
                    </tr>
                    <tr>
                        <td class="lab">公司（单位）简称</td>
                        <td class="value"><?=$base['shortName']?></td>
                    </tr>
                    <tr class="tr-bg1">
                        <td class="lab">公司（单位）简介</td>
                        <td class="value"><?=$base['description']?></td>
                    </tr>
                    <tr>
                        <td class="lab">注册资本</td>
                        <td class="value"><?=$base['registeredCapital']?></td>
                    </tr>
                    <tr class="tr-bg1">
                        <td class="lab">办公电话</td>
                        <td class="value"><?=$base['telephone']?></td>
                    </tr>
                    <tr>
                        <td class="lab">电子邮箱</td>
                        <td class="value"><?=$base['email']?></td>
                    </tr>
                    <tr class="tr-bg1">
                        <td class="lab">法人姓名</td>
                        <td class="value"><?=$legal['name']?></td>
                    </tr>
                    <tr>
                        <td class="lab">法人身份证号</td>
                        <td class="value"><?=$legal['idCard']?></td>
                    </tr>
                    <?php if($registered['businessLicenseType']=='OLD') {?>
                        <tr class="tr-bg1">
                            <td class="lab">营业执照</td>
                            <td class="value"><?=$registered['businessLicenseNum']?></td>
                        </tr>
                        <tr class="">
                            <td class="lab">组织机构代码证</td>
                            <td class="value"><?=$registered['organizationCodeNum']?></td>
                        </tr>
                        <tr class="tr-bg1">
                            <td class="lab">税务登记证</td>
                            <td class="value"><?=$registered['taxRegistrationNum']?></td>
                        </tr>
                    <?php }else{?>
                        <tr class="tr-bg1">
                            <td class="lab">统一社会信用代码</td>
                            <td class="value"><?=$registered['newBusinessLicenseNum']?></td>
                        </tr>
                    <?php }?>
                    <tr class="">
                        <td class="lab">经营范围</td>
                        <td class="value"><?=$registered['businessScope']?></td>
                    </tr>
                    <tr class="tr-bg1">
                        <td class="lab">成立时间</td>
                        <td class="value"><?=$registered['regTime']?></td>
                    </tr>
                    <tr>
                        <td class="lab">营业期限</td>
                        <td class="value"><?=$registered['businessLicenseExpireTime']?>年</td>
                    </tr>
                    <tr class="tr-bg1">
                        <td class="lab">公司地址</td>
                        <td class="value"><?=$registered['address']?></td>
                    </tr>
                    <tr>
                        <td class="lab">开户银行</td>
                        <td class="value"><?=$bank['bank']?></td>
                    </tr>
                    <tr class="tr-bg1">
                        <td class="lab">账号名称</td>
                        <td class="value"><?=$bank['accountName']?></td>
                    </tr>
                    <tr>
                        <td class="lab">银行账号</td>
                        <td class="value"><?=$bank['accountId']?></td>
                    </tr>
                    <tr class="bordb tr-bg1">
                        <td class="lab vert">企业资质</td>
                        <td class="value lineh20 padb20">
                            <?php foreach($eqInfo as $v){?>
                                <p><?=$v['eqName'];?></p>
                            <?php }?>
                        </td>
                    </tr>

                    </tbody></table>

                <div class="text-center agreen">
                    <p class="checklist"><i class="ico i-check"></i> 我已阅读并同意《<a class="blue" href="<?=cms_url('about/54')?>">投标人认证协议</a>》</p>
                    <div class="padv20">
                        <a href="<?=U('/member/bidder/applyfor')?>" class="btn-green2 bg-grey ">返回</a>
                        <input type="submit" class="btn-green2 marl150" value="确定">
                    </div>
                </div>

            </div>

        </div>
    </form>
</div>
<block name="script">
    <script>
        function subbefor()
        {
            var obj = $(".ico.i-check").hasClass('on')
            if(!obj)
            {
                layer.alert('请先阅读并同意协议',{icon:2});
                return false;
            }
        }
    </script>
</block>
