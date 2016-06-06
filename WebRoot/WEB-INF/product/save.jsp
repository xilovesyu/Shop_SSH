<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 引入公共的JSP片段 -->
<%@ include file="/public/head.jspf"%>
<style type="text/css">
form div {
	margin: 10px;
}
</style>
<script type="text/javascript">
	$(function() {
		//自定义的方法
		$.extend($.fn.validatebox.defaults.rules,{
			format:{
				validator:function(value,param){
					//获取当前文件的后缀名
					var ext=value.substring(value.lastIndexOf('.')+1);
					var arr=param[0].split(",");
					for(var i=0;i<arr.length;i++){
						if(ext==arr[i]){
							return true;
						}
					}
					return false;
				},
				message:'文件格式必须为{0}'
			}
		});
		$("input[name=name]").validatebox({
			required : true,
			misssingMessage : '请输入商品名称'
		});
		$("input[name=price]").numberbox({
			required : true,
			misssingMessage : '请输入商品价格',
			min:0,
			precision:2,
			prefix:'￥'
		});
		$("input[name=upload]").validatebox({
			required : true,
			misssingMessage : '请上传商品图片',
			// 设置自定义的方法
			validType:"format['gif,jpg,png,jpeg']"
		});
		$('#cc').combobox({
			url:'category_query.action',
			valueField:'id',
			textField:'type',
			panelHeight:'auto',
			panelWidth:150,
			width:150,
			editable:false,
			required:true,
			misssingMessage : '请选择类别'
		});
		//当文件域内容发生变化时调用验证方法
		$("input[name='fileModel.upload']").change(function(){
			$(this).validatebox("validate");
		});
		$("textarea[name=remark]").validatebox({
			required : true,
			misssingMessage : '请输入简单描述',
		});
		$("textarea[name=xremark]").validatebox({
			required : true,
			misssingMessage : '请输入详细描述',
		});
		$("#ff").form("disableValidation");
		//单击事件
		$("#submit").click(function(){
			//开启验证
			$("#ff").form("enableValidation");
			//如果验证成功，则提交数据
			if($("#ff").form("validate")){
				//提交数据
				$('#ff').form('submit',{
					url:'product_save.action',
					success:function(){
						//关闭当前窗体
						parent.$("#win").window('close');
						//刷新
						//parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("reload");
						parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid("reload");
					}
				});
			};
		});
		$("#reset").click(function(){
			//重置表单数据
			$("#ff").form("reset");
		});
		
	});
</script>
</head>

<body>
	<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
		<div>
			<label>商品名称:</label> <input type="text" name="name" />
		</div>
		<div>
			<label>商品价格:</label> <input type="text" name="price" />
		</div>
		<div>
			<label>图片上传:</label> <input type="file" name="fileModel.upload" />
		</div>
		<div>
			<label>所属类别：</label> <input id="cc" name="category.id"/>
		</div>
		<div>
			<label>加入推荐:</label> 推荐:<input type="radio" name="commend"
				checked="checked" value="true" /> 不推荐:<input type="radio"
				name="commend" value="false" />
		</div>
		<div>
			<label>是否有效:</label> 上架:<input type="radio" name="available"
				checked="checked" value="true" /> 下架:<input type="radio"
				name="open" value="false" />

		</div>
		<div>
			<label>简单描述:</label>
			<textarea name="remark" cols="40" rows="4"></textarea>
		</div>
		<div>
			<label>详细描述:</label>
			<textarea name="xremark" cols="40" rows="8"></textarea>
		</div>
		<div>
			<a id="submit" href="#" class="easyui-linkbutton">添 加</a> <a
				id="reset" href="#" class="easyui-linkbutton">重 置</a>
		</div>
	</form>
</body>
</html>
