<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript">
	$(function() {
		$("#dg").datagrid({
			url : 'category_queryJoinAccount.action',
			loadMsg:'请等待',
			striped:true,
			nowrap:true,
			fitColumns:true,
			pagination:true,
			singleSelect:false,
			idField:'id',//标识字段
			sortName:'id',
			queryParams:{type:''},
			toolbar:[{
				iconCls:'icon-add',
				text:'添加类别',
				handler:function(){
					console.info(parent.$("#win"));
					parent.$("#win").window({
						title:'添加类别',
						width:320,
						height:200,
						content:'<iframe src="send_category_save.action" frameborder="0" width="100%" height="100%"/>'
					});
				}
			},'-',{
			iconCls:'icon-edit',
			text:'更新类别',
				handler: function(){
					//alert("---update");
					//是否有选中的行
					var rows=$("#dg").datagrid("getSelections");
					if(rows.length!=1){
						for(var a=0;a<rows.length;a++)
							console.info("rows:"+rows[a].id);
						//弹出提示框
						$.messager.show({
							title:'error update',
							msg:rows.length==0?'至少选择一条':'最多只能选一条',
							timeout:2000,
							showType:'slide'
						});
					}else{
						//1.弹出更新页面
						parent.$("#win").window({
							title:'添加类别',
							width:320,
							height:250,
							content:'<iframe src="send_category_update.action" frameborder="0" width="100%" height="100%"/>'
						});
					}
				}
			},'-',{
			iconCls:'icon-remove',
			text:'删除类别',
				handler: function(){
					//是否有选中的行
					var rows=$("#dg").datagrid("getSelections");
					if(rows.length==0){
						//弹出提示框
						$.messager.show({
							title:'error delete',
							msg:'至少选择一条',
							timeout:2000,
							showType:'slide'
						});
					}
					else{
						//是否确认删除
						$.messager.confirm('确认删除','确定删除'+rows.length+'行记录？',function(r){
							if(r){
								//获取被选中的记录
								var ids="";
								for(var i=0;i<rows.length;i++){
									if(i!=rows.length-1)
										ids+=rows[i].id+",";
									else{ids+=rows[i].id;}
								}
								//alert(ids);
								$.post("category_deleteByIds.action",{ids:ids},function(result){
									if(result=="true"){
										//取消当前的所有行
										$('#dg').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
										$.messager.show({
											title:'删除通知',
											msg:'删除成功',
											timeout:2000,
											showType:'slide'
										});
										$("#dg").datagrid("reload");
									}else{
										alert("delete error");
										$('#dg').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
									}
								},"text");
							}
						});
					}
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
					field : 'type',title : '类别名称',width : 100,
					formatter:function(value,row,index){
						return "<span title="+value+">"+value+"</span>";
					}
				}, 
			 	{field : 'hot',title : '热点',width : 100,align : 'right'},
			 	{
			 		field : 'account.login',title : '所属管理员',width : 100,
			 		formatter:function(value,row,index){
						if(row.account!=null&& row.account.login!=null){
							return row.account.login;
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
