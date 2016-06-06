<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/public/head.jspf" %>
		<style type="text/css">
			#ff div{
				margin:5px;
				margin-left: auto;
				margin-right: auto;
			}
		</style>
		<script type="text/javascript">
			$(function(){
			$("input[name=type]").validatebox({
				required:true,
				misssingMessage:'请输入类别'
			});
			$("#ff").form("disableValidation");
			//注册a标签的事件
			$("#btn").click(function(){
				//开启验证
				$("#ff").form("enableValidation");
				//如果验证成功，则提交数据
				if($("#ff").form("validate")){
					//提交数据
					$('#ff').form('submit',{
						url:'category_save.action',
						success:function(){
							//关闭当前窗体
							parent.$("#win").window('close');
							//刷新
							//parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("reload");
							parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
			<label for="type">类别名称：</label>
			<input type="text" name="type"/>
		</div>
		<div>
			<input type="radio" name="hot" value="true"/>
			<label for="hot">热点</label>
			<input type="radio" name="hot" value="false" checked="checked"/>
			<label for="nothot">非热点</label>
		</div>
		<div>
			<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类别</a>
		</div>
		</form>
	</body>
</html>
