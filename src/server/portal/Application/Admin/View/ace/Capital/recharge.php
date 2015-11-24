<extend name="Public/base"/>
<block name="body">
<?php $status = ['CRT'=>'充值','OK#'=>'充值完成','FLS'=>'充值失败'];
?>
     <div class="table-responsive">
        <div class="dataTables_wrapper">  
            
            <div class="row">
                <div class="col-sm-12">
                    <form class="search-form">
                        <label>银行账户名称
                            <input type="text" class="search-input" name="account_name" value="{:I('account_name')}" placeholder="请输入银行账户名称">
                        </label>
                        <label>银行账户号
                            <input type="text" class="search-input" name="account_no" value="{:I('account_no')}" placeholder="请输入银行账户号">
                        </label>
                        <label>用户名
                            <input type="text" class="search-input" name="nick_name" value="{:I('nick_name')}" placeholder="请输入用户名">

                        </label>
                        <label>状态
			<select name="">
			<option >请选择</option>
			<?php print_r($status); foreach($status as $k=>$v){ ?>
				<option value="<?php echo $k?>"><?php echo $v?></option>
			<?php }?>
			</select>
                        <label>
                            <button class="btn btn-sm btn-primary" type="button" id="search" url="{:U('recharge')}">
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
                        <th>充值金额</th>
                        <th>充值时间</th>
                        <th>申请时间</th>
                        <th>银行账号</th>
                        <th>银行凭证号</th>
                        <th>银行名称</th>
                        <th>用户名</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
				<notempty name="_list">
                <volist name="_list" id="item">
                    <tr>
                        <td>
                            {$item.amount|price_format}
                        </td>
                        <td>{$item.transport_time}</td>
                        <td>{$item.insert_time}</td>
                        <td>{$item.account_no}</td>
                        <td>{$item.voucher}</td>
                        <td>{$item.bank_name}</td>
                        <td>{$item.nick_name}</td>
                        <td><?php echo $status[$item['status']];?></td>
                        <td>
			<?php if ($item['status']== 'CRT'){?>
				<a title="审核" href="<?php echo U('rechargecheck?id='.$item['order_id'])?>">审核</a>
			<?php }?>
                        </td>
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
