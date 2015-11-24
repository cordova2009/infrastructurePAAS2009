<extend name="Public/base" />

<block name="body">
	<!-- 表单 -->

<style>
td{width:50%;}
</style>
<input type="hidden" name="id"  value="{$item.id}">
<div class="widget-box" style="opacity: 1; z-index: 0;margin-bottom:1em;">
<div class="widget-header" style="color:#999;">
          <h5 class="bigger lighter">工程收款信息</h5>        
</div>
<div class="widget-body">
<div class=""> 
       <table class="table  table-bordered " style="margin-bottom:0px;">
	<tbody>
		<tr>
			<td><span style="color:#999;padding-right:8px;">工程名称:</span>{$item.nick_name}</td>
			<td><span style="color:#999;padding-right:8px;">订单号:</span>{$item.transport_time}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">总期数:</span>{$item.transport_time}</td>
			<td><span style="color:#999;padding-right:8px;">总金额:</span>{$item.amount|price_format}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">当前期数:</span>{$item.insert_time}</td>
			<td><span style="color:#999;padding-right:8px;">当前金额:</span>{$item.amount|price_format}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">剩余金额:</span>{$item.account_no}</td>
			<td><span style="color:#999;padding-right:8px;">剩余期数:</span>{$item.bank_name}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">应付时间:</span>{$item.transport_time}</td>
			<td><span style="color:#999;padding-right:8px;">支付时间:</span>{$item.voucher}</td>
		</tr>
		<tr>
			<td colspan="2"><span style="color:#999;padding-right:8px;">状态:</span>{$item.transport_time}</td>
		</tr>
	 </tbody>
	</table>
</div>
</div>
</div>
</block>

<block name="script">
<script type="text/javascript" charset="utf-8">
	Think.setValue('type',{$type|default=1});
</script>
</block>
