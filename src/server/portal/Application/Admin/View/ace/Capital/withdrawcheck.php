<extend name="Public/base" />

<block name="body">
<link rel="stylesheet" href="__STATIC__/uploadify/uploadify.css" />
<script type="text/javascript" src="__STATIC__/uploadify/jquery.uploadify.min.js"></script>
	<!-- 表单 -->
<style>
td{width:50%;}
</style>
<div class="widget-box" style="opacity: 1; z-index: 0;margin-bottom:1em;">
<div class="widget-header" style="color:#999;">
          <h5 class="bigger lighter">提现信息</h5>        
</div>
<div class="widget-body">
<div class=""> 
       <table class="table  table-bordered " style="margin-bottom:0px;">
	<tbody>
		<tr>
			<td><span style="color:#999;padding-right:8px;">用户名:</span>{$item.nick_name}</td>
			<td><span style="color:#999;padding-right:8px;">提现时间:</span>{$item.transport_time}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">提现金额:</span>{$item.withdraw_amount|price_format}</td>
			<td><span style="color:#999;padding-right:8px;">申请时间:</span>{$item.insert_time}</td>
		</tr>
		<tr>
			<td><span style="color:#999;padding-right:8px;">银行账号:</span>{$item.account_no}</td>
			<td><span style="color:#999;padding-right:8px;">开户银行:</span>{$item.bank_name}</td>
		</tr>
	 </tbody>
	</table>
</div>
</div>
</div>
<form action="{:U('withdrawcheck')}" method="POST" class="form-horizontal" id="form_submit" role="form">
<input type="hidden" value="{$item.order_id}" name="order_id">
<div class="form-group">
        <label class="col-xs-12 col-sm-2 control-label no-padding-right">上传凭证</label>
        <div class="col-xs-12 col-sm-5">
	<div class="controls">
                <input type="file" id="upload_file_file_id">
                <input type="hidden" name="file_id" value="" id="file_id"/>
                <div class="upload-img-box">
                </div>
            <script type="text/javascript">
                //上传图片
                /* 初始化上传插件 */
                $("#upload_file_file_id").uploadify({
                    "height"          : 30,
                    "swf"             : "__STATIC__/uploadify/uploadify.swf",
                    "fileObjName"     : "download",
                    "buttonText"      : "上传凭证",
                    "uploader"        : "{:U('File/uploadPicture',array('session_id'=>session_id()))}",
                    "width"           : 100,
                    'removeTimeout'       : 1,
                    'fileTypeExts'        : '*.jpg;*jpeg;*.png;',
                    "onUploadSuccess" : uploadFilefile_id,
                    'onFallback' : function() {
                        alert('未检测到兼容版本的Flash.');
                    }
                });
                function uploadFilefile_id(file, data){
		    var data = $.parseJSON(data);
		    var src = '';
		    if(data.status){
			    src = data.url || '' + data.src;
			    $("#file_id").val(src);
			    $("#file_id").parent().find('.upload-img-box').html(
					    '<div class="upload-pre-item"><img width="120" src="' + data.src+ '"/></div>'
					    );
		    } else {
			    updateAlert(data.info);
			    setTimeout(function(){
					    $('#top-alert').find('button').click();
					    $(that).removeClass('disabled').prop('disabled',false);
					    },1500);
		    }
                }
            </script>
	    </div>
    </div>
 <span class="help-block col-xs-12 col-sm-reset inline">（请选择要上传的文件，仅支持jpg格式）</span>
    </div>
	    
<div class="form-group">
        <label class="col-xs-12 col-sm-2 control-label no-padding-right">审核意见</label>
        <div class="col-xs-12 col-sm-5">
	    <input type="radio" name="status" value="OK#"> 通过&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="radio" name="status" value="FLS"> 拒绝
	    </div>
    </div>
<div class="form-group">
        <label class="col-xs-12 col-sm-2 control-label no-padding-right">凭证号</label>
        <div class="col-xs-12 col-sm-5">
	    <input type="text" name="voucher" value="" placeholder="请填写上传的凭证号">
	    </div>
    </div>
<div class="form-group">
        <label class="col-xs-12 col-sm-2 control-label no-padding-right">备注</label>
        <div class="col-xs-12 col-sm-5">
	    <textarea  name="remark" placeholder="请填写审核备注" style="width:250px;height:150px;"></textarea>
	    </div>
    </div>
		<div class="clearfix form-actions">
            <div class="col-xs-12 center" style="margin-top:1em;">
<button id="sub-btn" class="btn btn-success ajax-post no-refresh" target-form="form-horizontal" type="submit">
                              <i class="icon-ok bigger-110"></i> 审核
                          </button>
            </div>
        </div>
</form>
</block>

<block name="script">
<script type="text/javascript" charset="utf-8">
	Think.setValue('type',{$type|default=1});
</script>
</block>
