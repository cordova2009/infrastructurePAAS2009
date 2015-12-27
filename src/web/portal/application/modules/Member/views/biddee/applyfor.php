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
<div class=" main">
    <div class="box  pad0 bg-orange">
        <div class="stepbox2">
            <ul class="clear">
                <li class="first active">
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">1.填写基本信息</span>
                </li>
                <li>
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">2.填写法人资质</span>
                </li>
                <li >
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">3.填写公司注册信息</span>
                </li>
                <li class="last">
                    <span class="num"></span>
                    <div class="line"></div>
                    <span class="txt">4.提交招标人注册申请</span>
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
                                <input type="text" class="input1 " name="companyName" id="companyName" value="<?=isset($base['companyName'])?$base['companyName']:''?>">
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"><span class="red">*</span> 公司（单位）简称</span>
                            <div class="auto value ">
                                <input type="text" class="input1" name="shortName" value="<?=isset($base['shortName'])?$base['shortName']:''?>">
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
                                            <input type="hidden" name="logoUrl" value="<?=$base['logoUrl']?>">
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
                                <textarea id="" class="textarea" name="description" ><?=$base['description']?></textarea>
                            </div>
                        </div>
                        <div class="item">
                            <span class="lab"> 注册资本</span>
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
            <div class="padm30 chargeBox">
                <form action="<?=U('doapply')?>" method="post" class="ajax-form" success="legal_sucess">
                    <div class=" charge_form padv40 jibenxx">
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
                            <span class="lab"><span class="red">*</span> 法人身份证扫描件</span>
                            <div class="value auto">
                                <div class="marb20 clear">
                                    <img src="<?=empty($legal['idCardfrontUrl']) ? '/uploads/pic.jpg' : imageView2($legal['idCardfrontUrl'],178,112)?>" alt="" class="left marr10">
                                    <div class="left wid110">
                                        <label class="btn-file3  ">
                                            <span>上传附件</span>
                                            <input type="file" name="file" >
                                            <input class="hidden-url" type="hidden" name="idCardfrontUrl" value="<?=$legal['idCardfrontUrl']?>" >
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
                        </div>
                        <div class="item">
                            <span class="lab">法人授权书扫描件</span>
                            <div class="auto value ">
                                <div class="btn-file3 left <?php if(isset($legal) && !empty($legal['authorityBookUrl'])) echo 'hide'?>">
                                    <span>上传文件</span>
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
                                <i class="ico tip-qus2 verm marl20"></i>
                                <span class="red tips_txt hide">如果法人姓名与注册账号姓名不一致，需要上传法人授权书</span>
                            </div>
                        </div>


                        <div class="text-center padv30">
                            <input type="hidden" name="type" value="legal" >
                            <input type="submit" class="btn-green2" value="保存并继续">
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
                    <div class=" charge_form <?=($registered['businessLicenseType'] != 'OLD')? '' :'hide';?>">
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
                    <div class=" charge_form <?=($registered['businessLicenseType'] == 'OLD')? '' :'hide';?>" >
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
                            <div class="auto value ">
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
                            <span class="lab"><span class="red">*</span> 公司名称</span>
                            <div class="auto value ">
                                <input type="text" class="input1 wid350" name="accountName" value="<?=$bankInfo['accountName']?>" id="accountName" >
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
    </div>
</div>
<block name="script">
    <script src="/js/My97DatePicker/WdatePicker.js"></script>
    <?php require_once __DIR__.'/../common/upload.js.php';?>
    <script>
        function base_sucess()
        {
            $('#base').hide();
            $('#legal').show();
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(1)").addClass('active');
            $(".side_menu li").removeClass('on');
            $(".side_menu li:eq(1)").addClass('on');
            $(".side_menu li:eq(0) a").html('基本信息 <i class="ico i-right"></i>');
            $('#creditRating').html('25');
            $(".progressBox .progress span").css({'width':'25%'});
            $('#accountName').val($('#companyName').val());
        }
        function legal_sucess()
        {
            $('#legal').hide();
            $('#companyRegistered').show();
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(1)").addClass('active');
            $(".side_menu li").removeClass('on');
            $(".side_menu li:eq(2)").addClass('on');
            $(".side_menu li:eq(1) a").html('法人信息 <i class="ico i-right"></i>');
            $('#creditRating').html('50');
            $(".progressBox .progress span").css({'width':'50%'})
        }
        function companyRegistered_sucess()
        {
            $('#companyRegistered').hide();
            $('#bank').show();
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(2)").addClass('active');
            $(".side_menu li").removeClass('on');
            $(".side_menu li:eq(3)").addClass('on');
            $(".side_menu li:eq(2) a").html('公司注册信息 <i class="ico i-right"></i>');
            $('#creditRating').html('75');
            $(".progressBox .progress span").css({'width':'75%'})
        }
        function bank_sucess()
        {
            $(".stepbox2 .clear li").removeClass('active');
            $(".stepbox2 .clear li:eq(3)").addClass('active');
            $(".side_menu li:eq(3) a").html('银行开户信息 <i class="ico i-right"></i>');
            $('#creditRating').html('100');
            $(".progressBox .progress span").css({'width':'100%'});
            $('#tijiao').attr('href','<?=U('submitapply')?>').addClass('bg-green2');
        }
        function change()
        {
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
        function init()
        {
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
        }
        $(function(){
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
            init();

            $("input[type=file]").fileupload({
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

            $(".delete-pic-btn").click(function () {
                $(this)
                    .closest('.uploaded').hide()
                    .prev().removeClass('hide').show()
                    .find('.hidden-url').val('');
            });
        });
    </script>
</block>
