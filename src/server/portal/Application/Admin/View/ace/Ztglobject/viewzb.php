<extend name="Public/base" />

<block name="body">
<div class="col-md-offset-2 col-xs-8">
    <div class="accordion-style1 panel-group" id="accordion">
        <?php
        $panel_titles = [
            'xmjbxx'=>'项目基本信息',
            'gcjbxx'=>'工程基本信息',
            'gcsgzm'=>'工程施工证明',
            'gqyq'=>'工期要求',
            'zzyq'=>'资质要求',
            'bzj'=>'保证金',
            'zbfs'=>'招标方式',
            'ztbwjyq'=>'招投标文件要求',
            'dyfs'=>'答疑方式',
            'pbfs'=>'评标方式',
        ];
        ?>
        <?php foreach($panel_titles as $key=>$val):?>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a href="#<?=$key?>" data-parent="#accordion" data-toggle="collapse" class="accordion-toggle collapsed">
                            <i data-icon-show="icon-angle-right" data-icon-hide="icon-angle-down" class="bigger-110 icon-angle-right"></i>
                            <?=$val?>
                    </a>
                </h4>
            </div>

            <div id="<?=$key?>" class="panel-collapse collapse">
                <div class="panel-body">
                </div>
            </div>
        </div>
        <?php endforeach;?>
    </div>
    <div class="clearfix form-actions">
        <div class="col-xs-12 center">
            <a onclick="history.go(-1)" class="btn btn-info" href="javascript:;">
                <i class="icon-reply"></i>返回上一页
            </a>
        </div>
    </div>
</div>
</block>
<block name="script">
<script>
    $(document).ready(function () {

        //导航高亮
        highlight_subnav('<?=$active_menu?>');
        function get_tb_detail(type){
            var loading = layer.load();
            $.post(
                '<?=U('ztglobject/viewzb',['object_id'=>$object_id])?>',
                {type:type},
                function(html){
                    $("#"+type+' .panel-body').html(html);
                },
                'html'
            ).always(function(){
                layer.close(loading);
            });
        }

        get_tb_detail('xmjbxx');
        $("#xmjbxx").addClass('in').data('loaded',true);

        $(".panel-title a").click(function(){
            var type = $(this).attr('href');
            if(!$(type).data('loaded')){
                get_tb_detail(type.replace('#',''));
                $(type).data('loaded',true);
            }
        })
    })
</script>
</block>