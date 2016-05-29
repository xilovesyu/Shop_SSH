<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url : 'test_datagrid.json',
			loadMsg:'请等待',
			striped:true,
			nowrap:true,
			fitColumns:true,
			pagination:true,
			rowStyler:function(index,row){
				console.info(index+' '+row );
				if(index%2==0){
					return 'background-color:#fff;';
				}else{
					return 'background-color:#cdcdcd;';
				}
			},
			frozenColumns:[[
				{field:'xyz',checkbox:true},
				{field : 'code',title : 'Code',width : 100},
			]],
			columns : [ [ 
				{field : 'productname',title : 'Name',width : 100}, 
			 	{field : 'unitcost',title : 'Price',width : 100,align : 'right'} 
			 ]]
		});
	});
</script>
</head>

<body>
	类别管理
	<table id="dg"></table>
</body>
</html>
