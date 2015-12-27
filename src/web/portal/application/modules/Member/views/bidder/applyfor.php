<block name="style">
    <style>
        /*img{max-width:178px;}*/
        .btn-file3{position: relative;}
        .btn-file3 input {
            cursor: pointer;
            direction: ltr;
            height: 44px;
            margin: 0;
            opacity: 0;
            position: absolute;
            right: 0;
            top: 0;
            width: 92px;
            display:block;
        }
    </style>
</block>
<!--list-->
<div class=" main">
    <div class="box  pad0 bg-orange">
        <div class="stepbox2">
            <ul class="clear">
                <li class="first active">
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">1.填写基本信息</span>
                </li>
                <li >
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">2.填写公司注册信息</span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">3.填写行业资质</span>
                </li>
                <li class="last">
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">4.提交投标人注册申请</span>
                </li>
            </ul>
        </div>
    </div>

    <div class="clear mart30">
        <div class="left side_menu">
            <div class="progressBox">
                <div class="text-center">信息完整度<span id="creditRating">0</span>%</div>
                <div class="progress">
                    <span style="width:0%" class="on"></span>
                </div>
            </div>
            <ul>
                <li class="on" data-id="base">
                    <a href="javascript:;">基本信息 </a>
                </li>
                <li data-id="legal">
                    <a href="javascript:;">法人信息 </a>
                </li>
                <li data-id="companyRegistered">
                    <a href="javascript:;">公司注册信息 </a>
                </li>
                <li data-id="bank">
                    <a href="javascript:;">银行开户信息</a>
                </li>
                <li data-id="zizhi">
                    <a href="javascript:;">企业资质</a>
                </li>
            </ul>
        </div>
        <div class="auto  box pad0 " id="base">
            <form action="<?=U('doapply')?>" method="post" class="ajax-form" success="base_sucess">
                <div class="h2">基本信息</div>
                <div class="padm30 jibenxx">
                    <div class=" charge_form padv40">
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 公司（单位）全称</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " name="companyName" id="companyName" value="<?=$base['companyName']?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 公司（单位）简称</span>
                            <div class="auto value ">
                                <input type="text" class="input1" name="shortName" value="<?=$base['shortName']?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 公司（单位）LOGO</span>
                            <div class="auto value ">
                                <div class="marb20 clear">
                                    <img src="<?=empty($base['logoUrl']) ? '/uploads/pic.jpg' : imageView2($base['logoUrl'],178,112)?>" alt="" class="left marr10">
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传图片</span>
                                            <input type="file" name="file">
                                            <input class="hidden-url" type="hidden" name="logoUrl" value="<?=$base['logoUrl']?>">
                                        </label>
                                        <div class="progress mart20 hide">
                                            <span class="on"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 公司（单位）简介</span>
                            <div class="auto value ">
                                <textarea class="textarea" name="description" ><?=$base['description']?></textarea>
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab">注册资本</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " name="registeredCapital" value="<?=$base['registeredCapital']?>" >
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 办公电话</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " placeholder="区号+座机号码+分机号码" name="telephone" value="<?=$base['telephone']?>" >
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 电子邮箱</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " name="email" value="<?=$base['email']?>">
                            </div>
                        </div>

                        <div class="text-center padv30">
                            <input type="hidden" name="type" value="base" >
                            <input type="submit" class="btn-green2" value="保存并继续">
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="auto  box pad0 hide" id="legal">
            <div class="h2">法人信息</div>
            <div class="padm30 chargeBox jibenxx">
                <form action="<?=U('doapply')?>" method="post" class="ajax-form" success="legal_sucess">
                    <div class=" charge_form padv40">
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 法人姓名</span>
                            <div class="auto value ">
                                <input type="text" class="input1 wid350" name="name" value="<?=$legal['name']?>" >
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 法人身份证号</span>
                            <div class="auto value ">
                                <input type="text" class="input1 wid350" name="idCard" value="<?=$legal['idCard']?>" >
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab">法人身份证扫描件</span>
                            <div class="value auto">
                                <div class="marb20 clear">
                                    <img src="<?=empty($legal['idCardfrontUrl']) ? '/uploads/pic.jpg' : imageView2($legal['idCardfrontUrl'],178,112)?>" alt="" class="left marr10" >
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传附件</span>
                                            <input type="file" name="file" >
                                            <input type="hidden" name="idCardfrontUrl" value="<?=$legal['idCardfrontUrl']?>" >
                                        </label>
                                        <div class="progress mart20 hide">
                                            <span class="on"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="marb20 clear">
                                    <img src="<?=empty($legal['idCardBackUrl']) ? '/uploads/pic.jpg' : imageView2($legal['idCardBackUrl'],178,112)?>" alt="" class="left marr10">
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传附件</span>
                                            <input type="file" name="file">
                                            <input class="hidden-url" type="hidden" name="idCardBackUrl" value="<?=$legal['idCardBackUrl']?>" >
                                        </label>
                                        <div class="progress mart20 hide">
                                            <span class="on"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <span class="lab">法人授权书扫描件</span>
                                <div class="auto value ">
                                    <div class="btn-file3 <?php if(isset($legal) && !empty($legal['authorityBookUrl'])) echo 'hide'?>">
                                        <span>上传附件</span>
                                        <input type="file" name="file">
                                        <input class="hidden-url" type="hidden" name="authorityBookUrl" value="<?=$legal['authorityBookUrl']?>" >
                                    </div>
                                    <div class="uploaded left <?php if(!isset($legal) || empty($legal['authorityBookUrl'])) echo 'hide'?>">
                                        <a target="_blank" href="<?=isset($legal)?imageView2($legal['authorityBookUrl']):''?>" class="btn-file2 view">查看</a>
                                        <a class="btn-file2 bg-grey delete-pic-btn">删除</a>
                                    </div>
                                    <div class="progress wid100 dib hide left">
                                        <span class="on"></span>
                                    </div>
                                    <i class="ico tip-qus2 verm marl20 "></i>
                                    <span class="red tips_txt hide">如果法人姓名与注册账号姓名不一致，需要上传法人授权书</span>
                                </div>
                            </div>
                            <div class="text-center padv30">
                                <input type="hidden" name="type" value="legal" >
                                <input type="submit" class="btn-green2" value="保存并继续">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>


        <div class="auto  box pad0 hide"  id="companyRegistered">
            <div class="h2">公司注册信息</div>
            <div class="padm30 jibenxx">
                <form action="<?=U('doapply')?>" method="post" class="ajax-form" success="companyRegistered_sucess">
                    <div class="text-center checkBtn padv40 zhucexx">
                        <a href="javascript:;" class=" <?=($registered['businessLicenseType'] != 'OLD')? 'active' :'';?>">
                            统一社会信用代码
                            <input type="radio" class="hide" <?=($registered['businessLicenseType'] != 'OLD')? 'checked' :'';?> name="businessLicenseType" value="NEW" >
                        </a>
                        <a href="javascript:;" class=" <?=($registered['businessLicenseType'] == 'OLD')? 'active' :'';?>">
                            非统一社会信用代码
                            <input type="radio" class="hide" <?=($registered['businessLicenseType'] == 'OLD')? 'checked' :'';?> name="businessLicenseType" value="OLD" >
                        </a>
                    </div>
                    <!--统一社会信用代码-->
                    <div class=" charge_form  <?=($registered['businessLicenseType'] != 'OLD')? '' :'hide';?>">
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 统一社会信用代码</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " name="newBusinessLicenseNum" value="<?=$registered['newBusinessLicenseNum']?>">
                            </div>
                        </div>

                        <div class="item">
                            <span class="lab"><span class="red">*</span> 统一社会信用代码扫描件</span>
                            <div class="auto value ">
                                <div class="marb20 clear">
                                    <img src="<?=empty($registered['newBusinessLicenseUrl']) ? '/uploads/pic.jpg' : imageView2($registered['newBusinessLicenseUrl'],178,112)?>" alt="" class="left marr10">
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传附件</span>
                                            <input type="file" name="file" >
                                            <input class="hidden-url" type="hidden" name="newBusinessLicenseUrl" value="<?=$registered['newBusinessLicenseUrl']?>">
                                        </label>
                                        <div class="progress mart20 hide">
                                            <span class="on"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=" charge_form  <?=($registered['businessLicenseType'] == 'OLD')? '' :'hide';?>" >
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 营业执照编号</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " name="businessLicenseNum" value="<?=$registered['businessLicenseNum']?>">
                            </div>
                        </div>

                        <div class="item">
                            <span class="lab"><span class="red">*</span> 营业执照扫描件</span>
                            <div class="auto value ">
                                <div class="marb20 clear">
                                    <img src="<?=empty($registered['businessLicenseUrl']) ? '/uploads/pic.jpg' : imageView2($registered['businessLicenseUrl'],178,112)?>" alt="" class="left marr10">
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传附件</span>
                                            <input type="file" name="file" >
                                            <input class="hidden-url" type="hidden" name="businessLicenseUrl" value="<?=$registered['businessLicenseUrl']?>">
                                        </label>
                                        <div class="progress mart20 hide">
                                            <span class="on"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="item">
                            <span class="lab"><span class="red">*</span> 组织机构代码证编号</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " name="organizationCodeNum" value="<?=$registered['organizationCodeNum']?>">
                            </div>
                        </div>

                        <div class="item">
                            <span class="lab"><span class="red">*</span> 组织机构代码证扫描件</span>
                            <div class="auto value ">
                                <div class="marb20 clear">
                                    <img src="<?=empty($registered['organizationCodeUrl']) ? '/uploads/pic.jpg' : imageView2($registered['organizationCodeUrl'],178,112)?>" alt="" class="left marr10">
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传附件</span>
                                            <input type="file" name="file" >
                                            <input class="hidden-url" type="hidden" name="organizationCodeUrl" value="<?=$registered['organizationCodeUrl']?>">
                                        </label>
                                        <div class="progress mart20 hide">
                                            <span class="on"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="item">
                            <span class="lab"><span class="red">*</span> 税务登记证编号</span>
                            <div class="auto value ">
                                <input type="text" class="input1 " name="taxRegistrationNum" value="<?=$registered['taxRegistrationNum']?>">
                            </div>
                        </div>

                        <div class="item">
                            <span class="lab"><span class="red">*</span> 税务登记证扫描件</span>
                            <div class="auto value " id="">
                                <div class="marb20 clear">
                                    <img src="<?=empty($registered['taxRegistrationUrl']) ? '/uploads/pic.jpg' : imageView2($registered['taxRegistrationUrl'],178,112)?>" alt="" class="left marr10">
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传附件</span>
                                            <input type="file" name="file" >
                                            <input class="hidden-url" type="hidden" name="taxRegistrationUrl" value="<?=$registered['taxRegistrationUrl']?>">
                                        </label>
                                        <div class="progress mart20 hide">
                                            <span class="on"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 经营范围</span>
                        <div class="auto value ">
                            <textarea  id="" class="textarea" name="businessScope"><?=$registered['businessScope']?></textarea>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 成立时间</span>
                        <div class="auto value ">
                            <input type="text" class="input1 datepicker" name="regTime" value="<?=$registered['regTime']?>">
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 营业期限</span>
                        <div class="auto value ">
                            <div class="select">
                                <select name="businessLicenseExpireTime" id="">
                                    <option value="0" <?=$registered['businessLicenseExpireTime']=='0'?'selected':''?> >长期</option>
                                    <option value="1" <?=$registered['businessLicenseExpireTime']=='1'?'selected':''?> >一年</option>
                                    <option value="2" <?=$registered['businessLicenseExpireTime']=='2'?'selected':''?> >两年</option>
                                    <option value="3" <?=$registered['businessLicenseExpireTime']=='3'?'selected':''?> >三年</option>
                                    <option value="5" <?=$registered['businessLicenseExpireTime']=='5'?'selected':''?> >五年</option>
                                    <option value="10" <?=$registered['businessLicenseExpireTime']=='10'?'selected':''?> >十年</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <span class="lab"><span class="red">*</span> 公司地址</span>
                        <div class="auto value ">
                            <input type="text" class="input1 " name="address" value="<?=$registered['address']?>" >
                        </div>
                    </div>

                    <div class="text-center padv30">
                        <input  type="submit" class="btn-green2" value="保存并继续">
                    </div>
                    <input type="hidden" name="type" value="companyRegistered" >
                </form>
            </div>
        </div>

        <div class="auto  box pad0 hide" id="bank">
            <div class="h2">银行开户信息</div>
            <div class="padm30 chargeBox jibenxx">
                <form action="<?=U('doapply')?>" method="post" class="ajax-form" success="bank_sucess">
                    <div class=" charge_form padv40">
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 开户人姓名</span>
                            <div class="auto value ">
                                <input type="text" name="accountName" class="input1 wid350" value="<?=$bankInfo['accountName'];?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 开户银行</span>
                            <div class="auto value ">
                                <input type="text" name="bank" class="input1 wid350" value="<?=$bankInfo['bank'];?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 银行账号</span>
                            <div class="auto value ">
                                <input type="text" class="input1 wid350" name="accountId" value="<?=$bankInfo['accountId']?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 税号</span>
                            <div class="auto value ">
                                <input type="text" name="taxNo" class="input1 wid350" value="<?=$bankInfo['taxNo'];?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 联系电话</span>
                            <div class="auto value ">
                                <input type="text" name="telephone" class="input1 wid350" value="<?=$bankInfo['telephone'];?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 公司地址</span>
                            <div class="auto value ">
                                <input type="text" name="address" class="input1 wid350" value="<?=$bankInfo['address'];?>">
                            </div>
                        </div>
                        <div class="text-center padv30">
                            <input type="hidden" name="type" value="bankInfo" >
                            <input type="submit" class="btn-green2" value="保存并继续">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="auto  box pad0 hide" id="zizhi">
            <div class="h2">企业资质</div>
            <div class="padm30 jibenxx" id="zizhi_show">
                <div id="zizhi_model" >
                </div>
                <div class=" charge_form padv20">
                    <div class="bordb text-center padv40">
                        <a id="add-new-zizhi" href="javascript:">
                            <img width="54" height="54" alt="" src="/images/add.png">
                        </a>
                    </div>
                    <div class="text-center padv30">
                        <input type="hidden" name="type" value="bankInfo" >
                        <input type="button" id="submit" success="zizhi_sucess" class="btn-green2" value="保存并继续" >
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--list-->

<div id="new-zizhi-wrap" class="">
    <div class="item">
        <span class="lab"><span class="red">*</span> 工程类别</span>
        <div class="auto value ">
            <a href="javascript:;" class="btn right save-btn">保存</a>
            <div class="select">
                <select name="projectType" id="projectType">
                    <?php foreach($projectType as $k=>$v){?>
                        <option value="<?=$k?>"><?=$v?></option>
                    <?php }?>
                </select>
            </div>
        </div>
    </div>
    <div class="item">
        <span class="lab"><span class="red">*</span> 资质名称</span>
        <div class="auto value ">
            <div class="select">
                <select name="certificationId" id="certificationId" >
                </select>
            </div>
        </div>
    </div>
    <div class="item">
        <span class="lab"><span class="red">*</span> 资质编号</span>
        <div class="auto value ">
            <input type="text" class="input1 " name="certificationNo" id="certificationNo">
        </div>
    </div>
    <div class="item">
        <span class="lab"><span class="red">*</span> 资质有效期</span>
        <div class="auto value ">
            <input type="text" class="input1 datepicker" name="expiryDate" id="expiryDate" minDate="<?=date('Y-m-d',strtotime('+1 day'))?>">
        </div>
    </div>
    <div class="item">
        <span class="lab"><span class="red">*</span> 适用区域</span>
        <div class="auto value ">
            <input type="text" class="input1 " name="applicableRegion" id="applicableRegion">
        </div>
    </div>

    <div class="item bordb padb30">
        <span class="lab"><span class="red">*</span> 附件上传</span>
        <div class="auto value ">
            <div class="marb20 clear">
                <img id="cshow" src="/uploads/pic.jpg" alt="" class="left marr10">
                <div class="left wid110">
                    <label class="btn-file3  ">
                        <span>上传附件</span>
                        <input type="file" name="file" >
                        <input type="hidden" class="hidden-url" name="certificationContent" value="" id="certificationContent">
                    </label>
                    <div class="progress mart20 hide">
                        <span class="on"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<block name="script">
    <script src="/js/My97DatePicker/WdatePicker.js"></script>

    <?php require_once __DIR__.'/../common/upload.js.php';?>
    <script>
        function add(obj,subitem){
            var tmp = [];
            tmp.push('<div class="subitem"><div class="text-right padt20"> <a href="javascript:;" class="btn edit-zizhi" >修改</a> <a href="javascript:;" class=" btn-grey2 marl10 del-zizhi">删除</a> </div> <div class="qyzz bordb padb30"> <span class="left leftimg "><img src="');
            tmp.push(obj.cshow);
            tmp.push('"></span><div class="auto"> <div class="item"> <span class="lab">资质类别</span> <div class="auto">');
            tmp.push(obj.projectType);
            tmp.push('&nbsp;</div><div class="auto value hide" data-name="projectType">');
            tmp.push(obj.projectTypeid);
            tmp.push('</div><div class="auto value hide" data-name="certificationContent">');
            tmp.push(obj.certificationContent);
            tmp.push('</div> </div> <div class="item"> <span class="lab">资质名称</span> <div class="auto value" data-name="eqName">');
            tmp.push(obj.eqName);
            tmp.push('</div><div class="auto value hide" data-name="certificationId">');
            tmp.push(obj.certificationId);
            tmp.push('</div> </div> <div class="item"> <span class="lab">资质编号</span> <div class="auto value" data-name="certificationNo">');
            tmp.push(obj.certificationNo);
            tmp.push('</div> </div> <div class="item"> <span class="lab">资质有效期</span> <div class="auto value" data-name="expiryDate">');
            tmp.push(obj.expiryDate);
            tmp.push('</div> </div> <div class="item"> <span class="lab">适用区域</span> <div class="auto value" data-name="applicableRegion">');
            tmp.push(obj.applicableRegion);
            tmp.push('</div></div></div>');
            if(subitem != null && subitem.length > 0){
                subitem.before(tmp.join(''));
            }else{

                $('#zizhi_model').append(tmp.join(''));
            }
        }

        function submit(){
            var obj = [];
            $('#zizhi_model .subitem').each(function (i,o){
                var tmp = {}
                $(o).find('.value').each(function(i,o){
                    var id = $(o).data('name')
                    tmp[id]= $(o).html();
                });
//                var src = $(o).find('img').eq(0).attr('src');
//                tmp.certificationContent=src;
                obj.push(tmp);
            });

            if(obj.length==0)
            {
                layer.alert("请先添加资质证书",{icon:2});
                return false;
            }
            var url = '<?=U('doapply')?>';
//            if(this.id == 'tijiao'){
//                url = '<?//=U('doapply/and/save')?>//'
//            }
            ajax_post.apply(this,[url,{type:'zizhi',data:obj}]);
        }

        function base_sucess(){

            $('#base').hide();
            $('#legal').show();
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(1)").addClass('active');
            $(".side_menu li").removeClass('on');
            $(".side_menu li:eq(1)").addClass('on');
            $(".side_menu li:eq(0) a").html('基本信息 <i class="ico i-right"></i>');
            $('#creditRating').html('20');
            $(".progressBox .progress span").css({'width':'20%'});
            //$('#accountName').val($('#companyName').val());
        }
        function legal_sucess(){

            $('#legal').hide();
            $('#companyRegistered').show();
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(1)").addClass('active');
            $(".side_menu li").removeClass('on');
            $(".side_menu li:eq(2)").addClass('on');
            $(".side_menu li:eq(1) a").html('法人信息 <i class="ico i-right"></i>');
            $('#creditRating').html('40');
            $(".progressBox .progress span").css({'width':'40%'})
        }
        function companyRegistered_sucess(){
            $('#companyRegistered').hide();
            $('#bank').show();
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(2)").addClass('active');
            $(".side_menu li").removeClass('on');
            $(".side_menu li:eq(3)").addClass('on');
            $(".side_menu li:eq(2) a").html('公司注册信息 <i class="ico i-right"></i>');
            $('#creditRating').html('60');
            $(".progressBox .progress span").css({'width':'60%'})
        }
        function bank_sucess(){
            $('#bank').hide();
            $('#zizhi').show();
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(3)").addClass('active');
            $(".side_menu li").removeClass('on');
            $(".side_menu li:eq(4)").addClass('on');
            $(".side_menu li:eq(3) a").html('银行开户信息 <i class="ico i-right"></i>');
            $('#creditRating').html('80');
            $(".progressBox .progress span").css({'width':'80%'});
        }
        function zizhi_sucess(form,resp){
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(3)").addClass('active');
            $(".side_menu li:eq(4) a").html('企业资质 <i class="ico i-right"></i>');
            $('#creditRating').html('100');
            $(".progressBox .progress span").css({'width':'100%'});
        }
        function change(){
            if($(this).find('.i-right').size()==0)
            {
                return false;
            }

            $(".side_menu li").removeClass('on');
            $(this).addClass('on');

            $(".auto.box").hide();
            var id = $(this).data('id');
            $('#'+id).show();
        }
        function init(){
            var base="<?=empty($base['companyName'])?'1':'0'?>";
            if(base==0)
            {
                base_sucess();
            }else{
                return;
            }
            var legal="<?=empty($legal['name'])?'1':'0'?>";
            if(legal==0)
            {
                legal_sucess();
            }else{
                return;
            }
            var registered="<?=empty($registered['businessLicenseType'])?'1':'0'?>";
            if(registered==0)
            {
                companyRegistered_sucess();
            }else{
                return;
            }
            var bankInfo="<?=empty($bankInfo['accountId'])?'1':'0'?>";
            if(bankInfo==0)
            {
                bank_sucess();
            }else{
                return;
            }
            var zizhi=<?=json_encode($zizhi)?>;
            if(zizhi[0]!=undefined)
            {
                zizhi_sucess();
                for(var i=0;i<zizhi.length;i++)
                {
                    zizhi[i].projectTypeid = zizhi[i].projectType;
                    zizhi[i].projectType = zizhi[i].projectTypeName;
                    add(zizhi[i]);
                }
            }else{
                return;
            }
        }
        $(function(){

            init();

            $(".jibenxx .checkBtn a").click(function() {
                $(this)
                    .addClass('active')
                    .children('input').prop('checked',true);
                $(this).siblings('a').removeClass('active');

                $('#companyRegistered .charge_form')
                    .addClass('hide')
                    .eq($(this).index()).removeClass('hide');
            });

            $(".side_menu li").click(change);

            $(document).on('click',"#zizhi_model .del-zizhi",function(){
                $(this).closest('.subitem').remove();
            });

            $(document).on('click',"#zizhi_model .edit-zizhi",function(){
                var parent = $(this).closest('.subitem');
                parent.after(new_zizhi);
                pic_upload($("#new-zizhi-wrap input[type=file]"));

                parent.find('.value').each(function(i,o){
                    var id = $(o).data('name');
                    $('#'+id).val($.trim($(o).html()));
                    if(id == 'projectType'){
                        $("#projectType").change();
                    }
                });

                var src = parent.find('img').eq(0).attr('src');
                $('#cshow').attr('src',src);
            });

            var eqName = <?=json_encode($certificateName);?>;
            function projecttype_change_fun(){
                var o = eqName[this.value];
                if(o == null){
                    return false;
                }
                var _option_html = '';
                for(var i=0;i<o.length;i++){
                    _option_html += '<option value="'+o[i].certificateId+'">'+o[i].certificateName+'</option>';
                }
                $('#certificationId').html(_option_html);
            }

            $(document).on('change','#projectType',projecttype_change_fun);
            projecttype_change_fun.call(document.getElementById("projectType"));

            $('#submit').click(submit);

            function pic_upload(element){
                $(element).fileupload({
                    url:'<?=U('/member/upload/picture')?>',//文件上传地址，当然也可以直接写在input的data-url属性内
                    dataType: 'json',
                    formData:{width:178,height:112},//如果需要额外添加参数可以在这里添加
                    add: function (e, data) {
                        if (e.isDefaultPrevented()) {
                            return false;
                        }
                        $(this).prev().text('上传中..')
                            .parent().css('background','#bebebe')
                            .nextAll('.progress').show()
                            .children('span').css('width','0%');
                        data.submit();
                    },
                    progressall: function (e, data) {
                        var progress = parseInt(data.loaded / data.total * 100, 10);
                        $(this).parent()
                            .nextAll('.progress')
                            .children('span')
                            .css('width',progress + '%');
                    },
                    done:function(e,data){
                        //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
                        //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息
                        //返回的数据在result.result中，假设我们服务器返回了一个json对象

                        var $this = $(this);
                        var parent =$this
                            .prev().text('上传附件')
                            .parent().css('background','#8ab46e');

                        if(data.result.status == '0'){
                            //为隐藏标签赋值
                            $this.next().val(data.result.url);

                            var obj = parent.next('.uploaded');
                            if(obj.length > 0) {
                                parent.hide();
                                obj.removeClass('hide').show()
                                    .find('.view').attr('href', data.result.src);
                            }

                            var img_el = parent.parent().prev('img');
                            if(img_el.length > 0){
                                img_el.attr('src',data.result.src);
                            }
                        }else{
                            layer.alert(data.result.msg,{icon:2});
                        }

                        parent.nextAll('.progress').hide();
                    },
                    fail: function () {
                        $(this)
                            .prev().text('上传附件')
                            .parent().css('background','#8ab46e');
                        layer.alert('上传失败，请重新再试',{icon:2});
                    }
                });
            }
            pic_upload("input[type=file]");

            $(document).on('click',".delete-pic-btn",function () {
                $(this)
                    .closest('.uploaded').hide()
                    .prev().removeClass('hide').show()
                    .find('.hidden-url').val('');
            });

            $(document).on('click',".save-btn",function(){
                var obj ={};
                obj.projectTypeid= $('#projectType').val();
                obj.projectType= $('#projectType').find('option[value='+obj.projectTypeid+']').html()
                obj.eqName= $('#certificationId').find("option:selected").text();

                obj.certificationId = $('#certificationId').val();
                if(obj.certificationId == ''){
                    layer.alert("资质证书名称不能为空！",{icon:2});
                    return false;
                }

                obj.certificationNo= $('#certificationNo').val();
                if(obj.certificationNo == ''){
                    layer.alert("资质证书编号不能为空！",{icon:2});
                    return false;
                }

                obj.expiryDate= $('#expiryDate').val();
                if(obj.expiryDate == ''){
                    layer.alert("资质证书有效期不能为空！",{icon:2});
                    return false;
                }

                obj.applicableRegion= $('#applicableRegion').val();
                if(obj.applicableRegion == ''){
                    layer.alert("适用区域不能为空！",{icon:2});
                    return false;
                }

                obj.certificationContent = $('#certificationContent').val();
                obj.cshow = $('#cshow').attr('src');
                if(obj.certificationContent == '' || obj.cshow == '/uploads/pic.jpg'){
                    layer.alert("请上传资质证书附件",{icon:2});
                    return false;
                }

                $('#certificationNo,#expiryDate,#applicableRegion,#certificationContent').val('');

                $('#cshow').attr('src','/uploads/pic.jpg');

                var subitem = $("#new-zizhi-wrap").prev('.subitem');

                add(obj,subitem);
                if(subitem.length > 0){
                    subitem.remove();
                }
                $("#new-zizhi-wrap").remove();
            });

            var new_zizhi = $("#new-zizhi-wrap").clone();
            $("#new-zizhi-wrap").remove();
            $("#add-new-zizhi").click(function(){
                $("#zizhi_model").after(new_zizhi)

                $('#certificationNo,#expiryDate,#applicableRegion,#certificationContent').val('');

                $('#cshow').attr('src','/uploads/pic.jpg');

                pic_upload($("#new-zizhi-wrap input[type=file]"));
            });
        });
    </script>
</block>
