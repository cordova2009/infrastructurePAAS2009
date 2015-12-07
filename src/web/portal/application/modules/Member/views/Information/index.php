<div class="main">
    <div class="clear">
        <?php
        require_once APP_PATH.'modules/Member/views/common/nav.php';
        ?>
        <div class="auto box pad0" id="base-info">
            <div class="h2">发布信息</div>
            <div class="padm30">
                <form action="<?=U('/member/Information/index')?>" method="post" class="ajax-form" success="save_success" next_step="projectInfo">
                    <input name="objectId" value="<?=isset($info)?$info['objectId']:''?>" type="hidden" />
                    <div class="shangwubiao zbxmxx">
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>  地区</div>
                            <div class="value">
                                <div class="select">
                                    <select name="district">
                                        <option value="北京">北京</option>
                                        <option value="上海">上海</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>  项目名称</div>
                            <div class="value">
                                <input name="objectName" value="<?=$result['objectName']?>" type="text" class="input1 " placeholder="" >
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>地址</div>
                            <div class="value">
                                <input name="address" value="<?=$result['address']?>" type="text" class="input1 " placeholder="" >
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>工期</div>
                            <div class="value">
                                <input name="projectPeriod" value="<?=$result['projectPeriod']?>"  type="text" class="input1 " placeholder="" >
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>造价</div>
                            <div class="value">
                            <span class="yuanbox">
                                <span class="yuan">元</span>
                                <input name="objectAmount" value="<?=$result['objectAmount']?>"  type="text" class="input1 price_format" placeholder="" >
                            </span>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>阶段</div>
                            <div class="value">
                                <div class="select">
                                    <select name="phase" id="">
                                        <option value="施工准备阶段" >施工准备阶段</option>
                                        <option value="施工阶段" >施工阶段</option>竣工阶段
                                        <option value="竣工阶段" >竣工阶段</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>  类别</div>
                            <div class="value">
                                <div class="select">
                                    <select name="objectType" id="">
                                        <option value="房屋建筑工程" >房屋建筑工程</option>
                                        <option value="公路工程" >公路工程</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>概况</div>
                            <div class="value">
                                <textarea name="projectSituation" value="<?=$result['projectSituation']?>" class="textarea" placeholder=""></textarea>
                            </div>
                        </div>
                        <div class="item ">
                            <div class="lab"><span class="red">*</span>甲方</div>
                            <div class="value">
                                <textarea name="employer" value="<?=$result['employer']?>" class="textarea" placeholder=""></textarea>
                            </div>
                        </div>
                        <div class="item">
                            <div class="lab"></div>
                            <div class="value">
                                <button class="btn-green2 " type="submit" style="margin-right: 143px">确定</button>
                                <button type="reset" class="btn-green2 bg-grey " >重置</button>

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