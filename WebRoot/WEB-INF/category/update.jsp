<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<style type="text/css">
#ff div {
	margin: 5px;
	margin-left: auto;
	margin-right: auto;
}
</style>
<script type="text/javascript">
	$(function() {
		var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
		//对管理员的下拉列表查询
		$('#cc').combobox({
			url:'account_query.action',
			valueField:'id',
			textField:'login',
			panelHeight:'auto',
			panelWidth:150,
			width:150,
			editable:false
		});
		//数据回显
		var rows=dg.datagrid("getSelections");
		console.info("account.login:"+rows[0].account );
		$("#ff").form('load',{
			id:rows[0].id,
			type:rows[0].type,
			hot:rows[0].hot,
			'account.id':rows[0].account==null?'null':rows[0].account.id
		});
		
		$("input[name=type]").validatebox({
			required : true,
			misssingMessage : '请输入类别'
		});
		$("#ff").form("disableValidation");
		//注册a标签的事件
		$("#btn").click(
				function() {
					//开启验证
					$("#ff").form("enableValidation");
					//如果验证成功，则提交数据
					if ($("#ff").form("validate")) {
					//提交数据
					$('#ff').form('submit',{
						url : 'category_update.action',
						success : function() {
						//关闭当前窗体
						parent.$("#win").window('close');
						dg.datagrid("reload");
						dg.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
					}
				});
			};
		});
	});
</script>
</head>

<body>
	<form id="ff" method="post">
		<div>
			<label for="type">类别名称：</label> <input type="text" name="type" />
		</div>
		<div>
			<input type="radio" name="hot" value="true" /> <label for="hot">热点</label>
			<input type="radio" name="hot" value="false" checked="checked" /> <label
				for="nothot">非热点</label>
		</div>
		<div>
			<label for="account">所属管理员</label> 
			<!-- <select id="cc" class="easyui-combobox" name="dept" style="width:200px;">
				<option value="aa">items1</option>
				<option>items2</option>
				<option>items3</option>
				<option>items4</option>
			</select>-->
			<input id="cc" name="account.id"/>
		</div>
		<div>
			<a id="btn" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit'">更新类别</a>
			<input type="hidden" name="id"/>
		</div>
	</form>
</body>
</html>
