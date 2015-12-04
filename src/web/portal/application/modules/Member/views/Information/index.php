<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="auto box pad0" id="base-info">
            <div class="h2">发布信息</div>
            <div class="padm30">
                <form action="<?=U('/member/tender/baseInfo')?>" method="post" class="ajax-form" success="save_success" next_step="projectInfo">
                    <input name="objectId" value="<?=isset($info)?$info['objectId']:''?>" type="hidden" />
                    <div class="shangwubiao zbxmxx">
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>  地区</div>
                            <div class="value">
                                <div class="select">
                                    <select name="district">
                                        <option value="CNY">北京</option>
                                        <option value="USD">上海</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>  项目名称</div>
                            <div class="value">
                                <input name="objectName" type="text" class="input1 " placeholder="" >
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>地址</div>
                            <div class="value">
                                <input name="address" type="text" class="input1 " placeholder="" >
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>工期</div>
                            <div class="value">
                                <input name="projectPeriod" type="text" class="input1 " placeholder="" >
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>造价</div>
                            <div class="value">
                            <span class="yuanbox">
                                <span class="yuan">元</span>
                                <input name="objectAmount" type="text" class="input1 price_format" placeholder="" >
                            </span>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>阶段</div>
                            <div class="value">
                                <div class="select">
                                    <select name="phase" id="">
                                        <option value="CNY" >人民币</option>
                                        <option value="USD" >美元</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>  类别</div>
                            <div class="value">
                                <div class="select">
                                    <select name="objectType" id="">
                                        <option value="CNY" >人民币</option>
                                        <option value="USD" >美元</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>概况</div>
                            <div class="value">
                                <textarea name="projectSituation" class="textarea" placeholder=""></textarea>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>甲方</div>
                            <div class="value">
                                <textarea name="employer" class="textarea" placeholder=""></textarea>
                            </div>
                        </div>
                        <div class="item">
                            <div class="lab"></div>
                            <div class="value">
                                <a href="#" class="btn-green2 " style="margin-right: 143px">确定</a>
                                <a href="#" class="btn-green2 bg-grey " >返回</a>

                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
<block name="script">
<script>
$(function(){
    $("#left-menu .submenu:eq(4),#left-menu .submenu:eq(4) a:eq(0)").addClass('active');
})
</script>
</block>