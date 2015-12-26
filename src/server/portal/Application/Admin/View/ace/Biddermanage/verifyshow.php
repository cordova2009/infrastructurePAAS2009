<extend name="Public/base" />

<block name="body">
    <!-- 表单 -->
    <div class="space-10"></div>
    <style>
        .item-table td{width:50%;}
        img{max-width:400px;}
    </style>
    <form action="{:U('check')}" method="POST" class="form-horizontal check_data" id="form_submit" role="form">
        <input type="hidden" name="id"  value="{$item.id}">
        <div class="widget-header widget-header-small header-l-blue">
            <h5 class="smaller">
                账号基本信息
            </h5>
        </div>
        <table class="table table-striped table-bordered table-hover item-table ">
            <tbody>
                <tr>
                    <td><span class="">昵称:</span>{$user.nick_name}</td>
                    <td><span class="">电话:</span>{$user.mobile_num}</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <span class="">姓名:</span>{$user.real_name}
                    </td>
                </tr>
            </tbody>
        </table>

        <?php foreach($table_list as $title=>$tr):?>
        <div class="widget-header widget-header-small header-l-blue">
            <h5 class="smaller">
                <?=$title?>
            </h5>
        </div>
        <?php if($title == '资质列表'):?>
        <table class="table table-striped table-bordered table-hover dataTable">
            <thead>
                <tr>
                    <th>资质类别</th>
                    <th>资质名称</th>
                    <th>资质编号</th>
                    <th>资质有效期</th>
                    <th>适用区域</th>
                    <th>扫描件</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach($tr as $td):?>
                <tr>
                    <td><?=$td['industry_id']?></td>
                    <td><?=$td['certification_name']?></td>
                    <td><?=$td['certification_no']?></td>
                    <td><?=$td['expire_time']?></td>
                    <td><?=$td['applicable_region']?></td>
                    <td>
                        <a href="<?=imageView2($td['certification_content'])?>" class="ace-thumbnails" >
                            <img src="<?php echo imageView2($td['certification_content'],50,50)?>"/>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td colspan="7">
                        <div class="control-group center">
                            <label>
                                <input class="ace" type="radio" value="Y" name="certificationsCheck[<?=$td['id']?>]">
                                <span class="lbl"> 审核通过</span>
                            </label>
                            <label>
                                <input class="ace" type="radio" value="N" name="certificationsCheck[<?=$td['id']?>]">
                                <span class="lbl"> 审核不通过</span>
                            </label>
                            <input type="text" name="certificationsCheck_msg[<?=$td['id']?>]" placeholder="输入审核未通过原因">
                        </div>
                    </td>
                </tr>
                <?php endforeach;?>
            </tbody>
        </table>
        <?php
                continue;
            endif;
        ?>
        <table class="table table-striped table-bordered table-hover item-table ">
            <tbody>
            <?php foreach($tr as $key=>$td):?>
            <tr>
                <?php
                if($key === 'business_license_type'):
                ?>
                    <td colspan="2">
                        <span><?=$td?>：</span>
                        <?=($item['business_license_type']=='NEW') ? '三证合一' : '非三证合一';?>
                    </td>
                <?php
                    continue;
                endif;
                ?>
                <td>
                <?php
                if(!is_array($td)){
                    echo '<span>'.$td.'：</span>'.$item[$key];
                }else{
                    foreach($td as $el=>$label){
                        echo '<span>'.$label.'：</span>';
                        switch($el){
                            case 'img':
                                echo '<a href="'.imageView2($item[$key]).'" class="ace-thumbnails" ><img src="'.imageView2($item[$key],100,100).'"/></a>';
                            break;
                        }
                    }
                }
                ?>
                </td>
                <td>
                    <div class="control-group">
                        <label>
                            <input class="ace" type="radio" value="Y" name="<?=$key?>">
                            <span class="lbl"> 审核通过</span>
                        </label>
                        <label>
                            <input class="ace" type="radio" value="N" name="<?=$key?>">
                            <span class="lbl"> 审核不通过</span>
                        </label>
                        <input type="text" name="<?=$key?>_name_msg" placeholder="输入审核未通过原因">
                    </div>
                </td>
            </tr>
            <?php endforeach;?>
        </table>
        <?php endforeach;?>

        <div class="clearfix form-actions">
            <div class="col-xs-12 center" style="margin-top:1em;">
                <input type="hidden" name="business_license_type" value="<?=$item['business_license_type']?>" >
                <button id="sub-btn" class="btn btn-success ajax-post no-refresh" target-form="form-horizontal" type="submit" before="subbef">
                    <i class="icon-ok bigger-110"></i> 确认提交
                </button>
            </div>
        </div>
    </form>
</block>

<block name="script">
    <include file="Public/colorbox"/>
    <script type="text/javascript" charset="utf-8">
        Think.setValue('type',{$type|default=1});

        $(function(){
            $("input[type=radio]").click(function(){
                if(this.value == 'Y'){
                    $(this).closest('tr').children('td').css('background-color','#dff0d8');
                }else{
                    $(this).closest('tr').children('td').css('background-color','#f2dede');
                }
            });
        });
        function subbef(){
            var ret = true;
            $("input[type=radio][value=Y]").each(function (i,e){
                if(!e.checked&&$(e).parent().next().next().val()=='')
                {
                    ret =false;
                    layer.alert('请先填写不通过原因!',{icon:2});
                    return false;
                }
            });
            return ret;
        }
        //导航高亮
        highlight_subnav('{:U('biddermanage/verify')}');
    </script>
</block>
