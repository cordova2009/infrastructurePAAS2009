<extend name="Public/base" />
<block name="style">
    <style>
        .rule-wrap .form-item{ width: 33.3333%; float: left; text-align: center;}
        .rule-wrap .btnjt{ padding-top: 110px; line-height:40px; }
        .rule-wrap select{ width: 100%; height: 250px;}
    </style>
</block>
<block name="body">
    <?php
    echo ace_form_open('ztglobject/zbsort');
    ?>
    <div class="form-group rule-wrap">
        <div class="col-sm-5">
            <div class="controls">
                <select name="methods" multiple="multiple" id="select-left">
                    <?php
                    foreach($plist as $val):
                        if(array_key_exists($val['object_id'],$selected)){
                            continue;
                        }
                        ?>
                        <option value="<?=$val['object_id']?>"><?=$val['object_no']?>/<?=$val['object_name']?></option>
                    <?php
                    endforeach;
                    ?>
                </select>
            </div>
        </div>
        <div class="col-sm-2 ">
            <div class="hidden-xs btnjt">
                <button class="btn btn-block btn-sm btn-primary" type="button" id="to-left">
                    <i class="icon-arrow-right"></i>
                    <i class="icon-arrow-right"></i>
                    <i class="icon-arrow-right"></i>
                </button>
                <button class="btn btn-block btn-sm btn-danger" type="button" id="to-right">
                    <i class="icon-arrow-left"></i>
                    <i class="icon-arrow-left"></i>
                    <i class="icon-arrow-left"></i>
                </button>
            </div>
            <div class="hidden-sm hidden-md hidden-lg" style="padding: 20px 30px;">
                <button class="btn btn-block btn-sm btn-primary" type="button" id="to-left">
                    <i class="icon-arrow-down"></i>
                </button>
                <button class="btn btn-block btn-sm btn-danger" type="button" id="to-right">
                    <i class="icon-arrow-up"></i>
                </button>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="controls sort">
                <form action="{:U('zbsort')}" method="post">
                    <div class="sort_center">
                        <div class="sort_option">
                            <select name="selected[]" multiple="multiple" id="select-right">
                                <foreach name="selected" item="vo" >
                                    <option class="ids" title="<?=$vo['object_no']?>/{$vo.object_name}" value="{$vo.object_id}"><?=$vo['object_no']?>/{$vo.object_name}</option>
                                </foreach>
                            </select>
                        </div>
                    </div>
                    <div class="hr hr16 hr-dotted"></div>
                    <div class="sort_btn">
                        <button class="top btn btn-white" type="button"> <i class="icon-double-angle-left"> </i>第 一</button>
                        <button class="up btn btn-white" type="button"> <i class="icon-angle-left"></i> 上 移</button>
                        <button class="down btn btn-white" type="button">下 移 <i class="icon-angle-right"></i></button>
                        <button class="bottom btn btn-white" type="button">最 后 <i class="icon-double-angle-right"></i></button>
                    </div>
                    <div class="hr hr16 hr-dotted"></div>
                </form>
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
	<script type="text/javascript">

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
            rest();
            sort();
        })

        sort();
        $(".top").click(function(){
            rest();
            $("option:selected").prependTo($("#select-right"));
            sort();
        })
        $(".bottom").click(function(){
            rest();
            $("option:selected").appendTo($("#select-right"));
            sort();
        })
        $(".up").click(function(){
            rest();
            $("option:selected").after($("option:selected").prev());
            sort();
        })
        $(".down").click(function(){
            rest();
            $("option:selected").before($("option:selected").next());
            sort();
        })
        function sort(){
            $('#select-right option').text(function(){return ($(this).index()+1)+'.'+$(this).text()});
        }

        //重置所有option文字。
        function rest(){
            $('#select-right option').text(function(){
                return $(this).text().split('.')[1]
            });
        }
    })
	</script>
</block>