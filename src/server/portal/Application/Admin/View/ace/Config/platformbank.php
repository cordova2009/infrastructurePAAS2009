<extend name="Public/base"/>

<block name="body">

<div class="detail-content">
    <div class="widget-box">
        <div class="widget-header header-color-blue">
            <h5 class="bigger lighter">
                <i class="icon-credit-card "></i>
                平台银行账户
            </h5>

            <div class="widget-toolbar no-border">
                <label>
                    <button type="button" style="display: none" id="save_btn" class="btn btn-xs btn-success pull-right">
                        <i class="icon-ok"></i>
                        <span class="bigger-110">保存</span>
                    </button>
                </label>
                <label>
                    <button type="button" style="display: none" id="cancel_btn" class="btn btn-xs btn-warning pull-right">
                        <i class="icon-undo"></i>
                        <span class="bigger-110">取消</span>
                    </button>
                </label>
                <label>
                    <button type="button" id="edit_btn" class="btn btn-xs btn-info pull-right">
                        <i class="icon-pencil"></i>
                        <span class="bigger-110">修改</span>
                    </button>
                </label>
            </div>
        </div>

        <div class="widget-body">
            <div class="widget-main no-padding">
                <table class="table table-striped table-bordered table-hover">
                    <tbody>
                    <tr>
                        <th width="40%" class="">银行名称</th>

                        <td width="60%" class="bank_value" cloum_name="bank_name">
                            <?=$item['bank_name']?>
                        </td>
                    </tr>

                    <tr>
                        <th class="">支行名称</th>

                        <td class="bank_value" cloum_name="bank_branch_name">
                            <?=$item['bank_branch_name']?>
                        </td>
                    </tr>

                    <tr>
                        <th class="">银行账号</th>

                        <td class="bank_value" cloum_name="account_no">
                            <?=$item['account_no']?>
                        </td>
                    </tr>

                    <tr>
                        <th class="">省份</th>

                        <td class="bank_value" cloum_name="province">
                            <?=$item['province']?>
                        </td>
                    </tr>

                    <tr>
                        <th class="">城市</th>

                        <td class="bank_value" cloum_name="city">
                            <?=$item['city']?>
                        </td>
                    </tr>

                    <tr>
                        <th class="">开户人名称</th>

                        <td class="bank_value" cloum_name="account_name">
                            <?=$item['account_name']?>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</block>
<block name="script">
<script>
    var input_html = '<input type="text" class="width-100" name="%s" value="%s" />';
    var item = <?=json_encode($item)?>;

    $("#edit_btn").click(function(){
        $(".bank_value").each(function(i){
            var $this = $(this);
            $this.html(sprintf(input_html,$this.attr('cloum_name'), $.trim($this.text())));
        })
        $("#save_btn,#cancel_btn").show();
        $(this).hide();
    })
    $("#cancel_btn").click(function(){
        $(".bank_value").each(function(i){
            var $this = $(this);
            $this.text((item[$this.attr('cloum_name')] == null) ? '' : item[$this.attr('cloum_name')]);
        })
        $("#save_btn,#cancel_btn").hide();
        $("#edit_btn").show();
    })
    $("#save_btn").click(function(){
        $.post(
            '<?=U('config/platformbank')?>',
            $("input").serializeArray(),
            function(resp){
                if(resp.status == '1'){
                    updateAlert(resp.info);
                    item = resp.item;
                    $("#cancel_btn").click();
                }else{
                    updateAlert(resp.info,'alert-danger');
                }
            },
            'json');
    })
</script>
</block>