<extend name="Public/base" />

<block name="body">
<div class="span12">
    <div class="widget-box">
        <div class="widget-header widget-header-blue widget-header-flat">
        </div>

        <div class="widget-body">
            <div class="widget-main">
                <div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
                    <ul class="wizard-steps">
                        <li data-target="#step1" class="active">
                            <span class="step">1</span>
                            <span class="title">提示</span>
                        </li>

                        <li data-target="#step2">
                            <span class="step">2</span>
                            <span class="title">输入资料</span>
                        </li>

                        <li data-target="#step3">
                            <span class="step">3</span>
                            <span class="title">确认重置</span>
                        </li>
                    </ul>
                </div>

                <hr />
                <div class="step-content row-fluid position-relative" id="step-container">
                    <div class="step-pane active" id="step1">
                        <div class="alert alert-danger">
                            <strong>警告！</strong>
                            本功能仅在用户有需要的时候才会使用！
                            点击下一步进入重置用户登录密码页面
                            <br>
                        </div>
                    </div>

                    <div class="step-pane" id="step2">
                        <form id="sample-form" class="form-horizontal">
                            <div class="form-group has-info">
                                <label class="col-xs-12 col-sm-3 control-label no-padding-right" for="inputInfo">
                                    手机号码
                                </label>

                                <div class="col-xs-12 col-sm-5">
                                    <span class="block input-icon input-icon-right">
                                        <input type="text" class="width-100" id="mobile_num" name="mobile_num">
                                        <i class="icon-mobile-phone"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="form-group has-info">
                                <label class="col-xs-12 col-sm-3 control-label no-padding-right" for="inputInfo">
                                    身份证号
                                </label>

                                <div class="col-xs-12 col-sm-5">
                                    <span class="block input-icon input-icon-right">
                                        <input type="text" class="width-100" id="id_num" name="id_num">
                                        <i class="icon-info"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="form-group has-info">
                                <label class="col-xs-12 col-sm-3 control-label no-padding-right" for="inputInfo">
                                    真实姓名
                                </label>

                                <div class="col-xs-12 col-sm-5">
                                    <span class="block input-icon input-icon-right">
                                        <input type="text" class="width-100" id="real_name" name="real_name">
                                        <i class="icon-user"></i>
                                    </span>
                                </div>
                            </div>

                        </form>
                    </div>

                    <div class="step-pane" id="step3">
                        <div class="center">
                            <h3 class="blue lighter">This is step 3</h3>
                        </div>
                    </div>

                </div>

                <hr />
                <div class="row-fluid wizard-actions">
                    <button class="btn btn-info btn-prev">
                        <i class="icon-arrow-left"></i>
                        上一步
                    </button>

                    <button class="btn btn-success btn-next" data-last="确认重置 ">
                        下一步
                        <i class="icon-arrow-right icon-on-right"></i>
                    </button>
                </div>
            </div><!-- /widget-main -->
        </div><!-- /widget-body -->
    </div>
</div>
</block>

<block name="script">

    <script src="__ACE__/js/fuelux/fuelux.wizard.min.js"></script>

    <script>

    window.ace.click_event=$.fn.tap?"tap":"click";
    $('#fuelux-wizard').ace_wizard().on('change' , function(e, info){
console.info(info);
//        if(info.step == 1) {
//            return false;
//        }else if(info.step == 2){
//            return false;
//        }
    }).on('finished', function(e) {

    }).on('stepclick', function(e){
        //return false;//prevent clicking on steps
    });
</script>
</block>