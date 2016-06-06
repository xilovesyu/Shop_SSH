<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript">
	$(function() {
		$("#dg").datagrid({
			url : 'product_queryJoinCategory.action',
			loadMsg:'请等待',
			striped:true,
			nowrap:true,
			fitColumns:true,
			pagination:true,
			singleSelect:false,
			idField:'id',//标识字段
			sortName:'id',
			queryParams:{name:''},
			toolbar:[{
				iconCls:'icon-add',
				text:'添加商品',
				handler:function(){
					parent.$("#win").window({
						title:'添加商品',
						width:500,
						height:500,
						content:'<iframe src="send_product_save.action" frameborder="0" width="100%" height="100%"/>'
					});
				}
			},'-',{
			iconCls:'icon-edit',
			text:'更新商品',
				handler: function(){
					//alert("---update");
				
				}
			},'-',{
			iconCls:'icon-remove',
			text:'删除类别',
				handler: function(){
					//是否有选中的行
					
				}
			},'-',{
				text:"<input id='search' name='search'/>"
			}],
			rowStyler:function(index,row){
				if(index%2==0){
					return 'background-color:#fff;';
				}else{
					return 'background-color:#F4F2F2;';
				}
			},
			frozenColumns:[[
				{field:'xyz',checkbox:true},
				{field : 'id',title : '编号',width : 100}
			]],
			columns : [ [ 
				{
					field : 'name',title : '商品名称',width : 100,
					formatter:function(value,row,index){
						return "<span title="+value+">"+value+"</span>";
					}
				}, 
			 	{field : 'remark',title : '简单介绍',width : 100,align : 'right'},
			 	{
			 		field : 'category.type',title : '所属类别',width : 100,
			 		formatter:function(value,row,index){
						if(row.category!=null&& row.category.type!=null){
							return row.category.type;
						}
						else{return "<span style='color:red;'>没有设置管理员</span>";}
					},
					styler:function(value,row,index){
						
			 		}
			 	}
			 ]]
		});
		
		$('#search').searchbox({
			searcher:function(value,name){
				//alert(value+","+name);
				$("#dg").datagrid('load',{type:value});
			},
			prompt:'search'
		});
	});
</script>
</head>

<body>
	类别管理
	<table id="dg"></table>
	</body>
</html>
