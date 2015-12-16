<extend name="Public/base" />

<block name="body">
     <div class="table-responsive">
        <div class="dataTables_wrapper">  
            
            <div class="row">
                <div class="col-sm-12">
                    <form action="<?=U('ztglobject/zzzbindex')?>" method="POST" class="search-form">
                        <label>项目编号
                            <input type="text" class="search-input" name="object_no" value="{:I('object_no')}">
                        </label>
                        <label>项目名称
                            <input type="text" class="search-input" name="object_name" value="{:I('object_name')}">
                        </label>
                        <label>工程类别
                            <?=form_dropdown('industry_id',[''=>'---全部---']+$industry,I('industry_id'))?>
                        </label>
                        <label>
                            <button class="btn btn-sm btn-primary" type="button" id="search-btn" url="{:U('ztglobject/zzzbindex')}">
                               <i class="icon-search"></i>搜索
                            </button>
                        </label>
                    </form>
                </div>
            </div>
            
            <!-- 数据列表 -->
            <table class="table table-striped table-bordered table-hover dataTable">
			    <thead>
			        <tr>
                        <th class="">项目编号</th>
                        <th class="">名称</th>
                        <th class="">投标人数</th>
                        <th class="text-right">标的估价</th>
                        <th class="">工程类别</th>
                        <th class="">创建时间</th>
                        <th class="">开标日期</th>
                        <th class="">投标截止日期</th>
					</tr>
			    </thead>
			    <tbody>
					<notempty name="list">
					<volist name="list" id="vo">
					<tr>
						<td><a href="{:U('viewzb',array('object_id'=>$vo['object_id']))}">{$vo.object_no}</a></td>
						<td><?=$vo['object_name']?></td>
                        <td>
                            <?=$tb_counts[$vo['object_id']]?>
                        </td>
                        <td class="text-right"><?=price_format($vo['evaluation_amount'])?></td>
                        <td><?=$industry[$vo['industry_id']]?></td>
						<td><?=$vo['insert_time']?></td>
						<td>{$vo.bid_open_date}</td>
						<td><?=date('Y-m-d',strtotime($vo['bidding_end_time']))?></td>
					</tr>
					</volist>
					<else/>
					<td colspan="10" class="text-center"> aOh! 暂时还没有内容! </td>
					</notempty>
				</tbody>
            </table>

            <div class="row">
                <div class="col-sm-4">
                </div>
                <div class="col-sm-8">
                    <include file="Public/page"/>
                </div>
            </div>
        </div>
    </div>
</block>