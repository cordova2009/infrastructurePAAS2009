<extend name="Public/base"/>

<block name="body">
    <!-- 数据列表 -->
    <div class="table-responsive">
        <div class="dataTables_wrapper">  
            <div class="row">
                <div class="col-sm-12">
                    <form action="" class="search-form">
                        <empty name="model.extend">
                        <label>
                            <a class="btn btn-sm btn-primary" href="<?=isset($add_url) ? U($add_url) : U('add',['model'=>$model['id']])?>"><i class="icon-plus"></i>新增</a>
                        </label>
                        <?php if($model['need_batch_handle']):?>
                        <label>
                            <button class="btn btn-sm btn-inverse ajax-post confirm" target-form="ids" url="{:U('del?model='.$model['id'])}">
                                <i class="icon-trash"></i>删 除
                            </button>
                        </label>
                        <?php endif;?>
                        </empty>
                        <?php if(!empty($model['search_key'])):?>
				        <!-- 高级搜索 -->
				        <label> 
                            <input type="text" name="{$model['search_key']|default='title'}" class="search-input" value="{:I('title')}" placeholder="请输入关键字">
                        </label>
                        <label>
                            <button class="btn btn-sm btn-primary" type="button" id="search-btn" id="search" url="{:U('Think/lists','model='.$model['name'],false)}">
                               <i class="icon-search"></i>搜索
                            </button>
                        </label>
                        <?php endif;?>
                    </form>  
                </div>
            </div>

            <include file="Think/lists_common"/>
            <include file="Public/page"/>
        </div>
    </div>
</block>

<block name="script">
<script type="text/javascript">
$(function(){

    //导航高亮
    <?php if(isset($active_menu)):?>
    highlight_subnav('<?=U($active_menu)?>');
    <?php else:?>
    highlight_subnav('{:U('Model/index')}');
    <?php endif;?>
})
</script>
</block>
