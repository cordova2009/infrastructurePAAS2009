<extend name="Public/base"/>

<block name="body">
<?php $status=['OK#'=>'施工中','FLS'=>'终止','END'=>'完结'];?>
     <div class="table-responsive">
        <div class="dataTables_wrapper">  
            
            <div class="row">
                <div class="col-sm-12">
                    <form class="search-form">
                        <label>项目编号
                            <input type="text" class="search-input" name="project_id" value="{:I('project_id')}" placeholder="请输入项目编号">
                        </label>
                        <label>项目名称
                            <input type="text" class="search-input" name="object_name" value="{:I('object_name')}" placeholder="请输入项目名称">
                        </label>
                        <label>状态
<select name="status">
<option value="">请选择</option>
<?php
foreach ($status as $k=>$v){
	$selected = $k==I('status')?'selected':'';
	echo '<option value="'.$k.'" '.$selected.' >'.$v."</option>";
}
?>
</select>
                        </label>
			<label>
                            <button class="btn btn-sm btn-primary" type="button" id="search" url="{:U('index')}">
                               <i class="icon-search"></i>搜索
                            </button>
                        </label>
                    </form>  
                </div>
            </div>
            
            <form class="ids">
            <!-- 数据列表 -->
            <table class="table table-striped table-bordered table-hover dataTable">
                <thead>
                    <tr>
                        <th>项目编号</th>
                        <th>项目名称</th>
                        <th>中标人</th>
                        <th>招标人</th>
                        <th>状态</th>
                        <th>工程开始时间</th>
                        <th>工程结束时间</th>
                    </tr>
                </thead>
                <tbody>
				<notempty name="_list">
                <volist name="_list" id="item">
                    <tr>
                        <td><a href="{:U('show?id='.$item['id'])}">{$item.project_id}</a></td>
                        <td>{$item.object_name}</td>
                        <td><a href="{:U('object/baseshow?id='.$item['bidder_id'].'&type=bidder')}">{$item.bidder_name}</a></td>
                        <td><a href="{:U('object/baseshow?id='.$item['biddee_id'].'&type=biddee')}">{$item.biddee_name}</a></td>
                        <td><?php echo $status[$item['status']];?></td>
                        <td>{$item.start_time}</td>
                        <td>{$item.end_time}</td>
                    </tr>
                </volist>
				<else/>
				<td colspan="10" class="text-center"> aOh! 暂时还没有内容! </td>
				</notempty>
                </tbody>
            </table>
            </form>
            <include file="Public/page"/>
        </div>
    </div>
</block>

<block name="script">
    <script type="text/javascript">
        $(function() {
            //搜索功能
            $("#search").click(function() {
                var url = $(this).attr('url');
                var query = $('.search-form').serialize();
                query = query.replace(/(&|^)(\w*?\d*?\-*?_*?)*?=?((?=&)|(?=$))/g, '');
                query = query.replace(/^&/g, '');
                if (url.indexOf('?') > 0) {
                    url += '&' + query;
                } else {
                    url += '?' + query;
                }
                window.location.href = url;
            });
            //回车搜索
            $(".search-input").keyup(function(e) {
                if (e.keyCode === 13) {
                    $("#search").click();
                    return false;
                }
            });
        });
    </script>
</block>
