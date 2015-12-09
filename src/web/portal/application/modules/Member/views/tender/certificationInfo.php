<?php
if(check_resp($resp)){
    $info = $resp['certificationInfo'];
}
?>
<div class="auto  box pad0" id="certificationInfo">
    <div class="h2">资质要求</div>
    <div class="padm40">
        <form action="<?=U('/member/tender/saveCertificationInfo')?>" method="post" class="ajax-form" success="save_success" next_step="bondInfo">
        <input name="objectId" value="<?=$objectId?>" type="hidden" />
        <div class="clear padv40 tit9">
            <div class="left">
                <span class="red marr10">*</span> 投标人资质等级最低要求
            </div>
            <div class="right">
                <a href="javascript:" class="btn" id="add-cert">添加</a>
                <a href="javascript:" class="btn-grey marl10" id="del-cert">删除</a>
            </div>
        </div>

        <div class="table charge_table  ">
            <table>
                <tr class="bg2 thead">
                    <td class="wid70 "></td>
                    <td class="wid150">工程类别</td>
                    <td>资质名称</td>
                </tr>
                <tbody id="cert-body">
                <?php
                if(isset($info['bidderCertification']) && is_array($info['bidderCertification']))
                foreach($info['bidderCertification'] as $item):
                ?>
                <tr data="<?=$item['industryId'].$item['certificateId']?>">
                    <td>
                        <div class="checklist">
                            <i class="ico i-check"></i>
                        </div>
                    </td>
                    <td class="">
                        <input type="hidden" name="industry[]" value="<?=$item['industryId']?>" >
                        <?=$industryList[$item['industryId']]['industryName']?>
                    </td>
                    <td class="">
                        <input type="hidden" name="certificate[]" value="<?=$item['certificateId']?>" >
                        <?=$item['certificateName']?>
                    </td>
                </tr>
                <?php
                endforeach;
                ?>
                </tbody>
            </table>
        </div>

        <div class="text-center padv20 hide" id="cert-ok-wrap">
            <a href="javascript:" class="btn" id="cert-ok-btn">确  定</a>
        </div>

        <div class="tit10"><span>请选择投标方需要提供的资料</span></div>

        <div class="zhengshu checklist ziliao">
            <p class="txt">投标人主要人员资质</p>
            <ul class="clear">
                <li>
                    <i class="ico i-check <?php if(isset($info) && $info['needPmCertification'] == 'YES') echo 'on'?>"></i>
                    <input type="checkbox" name="needPmCertification" value="1" class="hide" <?php if(isset($info) && $info['needPmCertification'] == 'YES') echo 'checked'?>>
                    需要投标人项目经理证明
                </li>
                <li>
                    <i class="ico i-check <?php if(isset($info) && $info['needConstructorCertification'] == 'YES') echo 'on'?>"></i>
                    <input type="checkbox" name="needConstructorCertification" value="1" class="hide" <?php if(isset($info) && $info['needConstructorCertification'] == 'YES') echo 'checked'?>>
                    需要投标人建造师证明
                </li>
            </ul>
            <p class="txt">投标人安全生产证明</p>
            <ul class="clear">
                <li>
                    <i class="ico i-check <?php if(isset($info) && $info['needSafetyPermit'] == 'YES') echo 'on'?>"></i>
                    <input type="checkbox" name="needSafetyPermit" value="1" class="hide" <?php if(isset($info) && $info['needSafetyPermit'] == 'YES') echo 'checked'?>>
                    需要安全生产许可证明
                </li>
                <li>
                    <i class="ico i-check <?php if(isset($info) && $info['needPmSafetyCertification'] == 'YES') echo 'on'?>"></i>
                    <input type="checkbox" name="needPmSafetyCertification" value="1" class="hide" <?php if(isset($info) && $info['needPmSafetyCertification'] == 'YES') echo 'checked'?>>
                    需要项目经理安全生产考核合格证明
                </li>
            </ul>
        </div>

        <div class="text-center padv30">
            <button type="submit" class="btn-green2">保存并继续</button>
        </div>

        </form>

    </div>
</div>
<script>
$(function(){
    //行业证书
    var industryList = <?=json_encode($industryList)?>;
    //生成动态添加的html代码
    var _tr_html = '<tr>\
                        <td>\
                        <div class="checklist">\
                            <i class="ico i-check"></i>\
                        </div>\
                        </td>\
                        <td class="">%s</td>\
                        <td class="">&nbsp;</td>\
                    </tr>';
    var _industry_select = '<select class="industry_select wid160" _name="industry">';
    $.each(industryList, function (i,industry) {
        _industry_select += '<option value="'+industry.industryId+'">'+industry.industryName+'</option>';
    });
    _industry_select += '</select>';
    _tr_html = sprintf(_tr_html,_industry_select)

    var cert_body = $("#cert-body");
    //为添加按钮绑定事件
    $("#add-cert").click(function(){
        cert_body.append(_tr_html);
        //手动触发下拉联动
        $(".industry_select:last").change();
    });

    //二级联动触发事件
    $(document).on('change','.industry_select',function(){

        var _cert_select = '<select class="wid160" _name="certificate">';
        $.each(industryList[this.value]['certificateList'],function(i,cert){
            _cert_select += '<option value="'+cert.certificateId+'">'+cert.certificateName+'</option>';
        });
        _cert_select += '</select>';
        $(this).parent().next().html(_cert_select);
        $("#cert-ok-wrap").show();
    });

    //确定按钮事件
    $("#cert-ok-btn").click(function(){

        $("#cert-body select").each(function(){
            var $this = $(this);
            var _td_html = '<input type="hidden" name="'+$this.attr('_name')+'[]" value="'+$this.val()+'" >';
            _td_html += $this.children(':selected').text();
            $this.parent().html(_td_html);
        });

        //去除重复的行
        var data_list = [];
        $.each($("#cert-body tr"),function(){
            var $this = $(this);
            var data = $this.attr('data');
            if(data != null){
                data_list.push(data);
            }else{
                data = '';
                $.each($this.find('input'),function(){
                    data += this.value;
                });
                if($.inArray(data,data_list) > -1){
                    $this.remove();
                }else{
                    $this.attr('data',data);
                    data_list.push(data);
                }
            }
        });
        $("#cert-ok-wrap").hide();
    })

    //删除事件
    $("#del-cert").click(function(){
        var no_checked = true;
        $("#cert-body .i-check").each(function(){
            var $this = $(this);
            if($this.hasClass('on')){
                $this.closest('tr').remove();
                no_checked = false;
            }
        });
        if(no_checked){
            layer.alert('请选择要删除的证书！',{icon:2});
        }
    })
})
</script>