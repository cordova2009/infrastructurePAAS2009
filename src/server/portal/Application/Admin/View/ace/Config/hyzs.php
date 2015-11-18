<extend name="Public/base" />
<block name="style">
    <style>
        .rule-wrap .form-item{ width: 33.3333%; float: left; text-align: center;}
        .rule-wrap .btnjt{ padding-top: 110px; line-height:40px; }
        .rule-wrap select{ width: 98%; height: 250px;}
    </style>
</block>
<block name="body">
    <?php
        echo ace_form_open('','',array('industry_id'=>$industry_id));
    ?>
    <div class="form-group rule-wrap">
        <div class="col-sm-5">
            <label class="item-label">未选择</label>
            <div class="controls">
                <select name="methods" multiple="multiple" id="select-left">
                    <foreach name="plist" item="val" >
                        <option value="{$key}">{$val}（{$key}）</option>
                    </foreach>
                </select>
            </div>
        </div>
        <div class="col-sm-1 btnjt">
            <button class="btn btn-sm btn-primary" type="button" id="to-left">
                <i class="icon-double-angle-right"></i>
                <i class="icon-double-angle-right"></i>
                <i class="icon-double-angle-right"></i>
            </button>
            <button class="btn btn-sm btn-danger" type="button" id="to-right">
                <i class="icon-double-angle-left"></i>
                <i class="icon-double-angle-left"></i>
                <i class="icon-double-angle-left"></i>
            </button>
        </div>
        <div class="col-sm-5">
            <label class="item-label">已选择</label>
            <div class="controls">
                <select name="selected[]" multiple="multiple" id="select-right">
                    <foreach name="selected" item="val" >
                        <option value="{$key}">{$val}（{$key}）</option>
                    </foreach>
                </select>
            </div>
        </div>
        <div style="clear: both;"></div>
    </div>
    <?php
        echo ace_srbtn();
        echo ace_form_close()
    ?>
</block>
<block name="script">
    <script type="text/javascript" charset="utf-8">
        //导航高亮
        highlight_subnav('{:U('config/hangye')}');
        $('#sub-btn').click(function(){
            $("#select-right option").prop('selected',true);
        });
        $(function(){

            $("#to-right,#to-left").click(function(){
                var from = 'left',to = 'right';
                if(this.id != 'to-left'){
                    from = 'right';
                    to = 'left';
                }
                var op_html = '';
                $("#select-"+from+" option:selected").each(function(){
                    var e = $(this);
                    op_html += '<option value="'+e.val()+'">'+e.text()+'</option>'
                    e.remove();
                })
                $("#select-"+to).append(op_html);
            })
        })
    </script>
</block>

