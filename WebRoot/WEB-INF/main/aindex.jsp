<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/public/head.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
#menu {
	width: 200px;
	/*border:1px solid red;*/
}

#menu ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

#menu ul li {
	border-bottom: 1px solid #fff;
}

#menu ul li a { /*设置为块级元素*/
	display: block;
	background-color: #00a6ac;
	color: #fff;
	padding: 5px;
	text-decoration: none;
}

#menu ul li a:HOVER {
	background-color: #008792;
}
</style>
<script type="text/javascript">
	$(function() {
		$("a[title]").click(function() {
			//1.判断当前后面是否已有新的标签
			//2.如果没有，创建一个tab，否则切换到响应tab
			var text=$(this).text();
			var href=$(this).attr("title");
			if($("#tt").tabs("exists",text)){
				//alert("exist");
				$("#tt").tabs("select",text);
			}else{
				//alert("not exists");
				$("#tt").tabs("add",{
					title:text,
					closable:true,
					content:'<iframe title='+text+' src="'+ href +'" frameborder="0" width="100%" height="100%"/>'
					//href:'send_category_query.action'
				});
			}
		});
	});
</script>
<body class="easyui-layout">
	<div data-options="region:'north',title:'welcome:',split:true"
		style="height:100px;"></div>
	<div data-options="region:'west',title:'系统操作',split:true"
		style="width:150px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="基本操作">
				<ul>
					<li><a href="#" title="send_category_query.action">类别管理</a></li>
					<li><a href="#" title="send_product_query.action">商品管理</a></li>
				</ul>
			</div>
			<div title="其他操作">
				<ul>
					<li><a href="#">类别管理</a></li>
					<li><a href="#">商品管理</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'后台操作页面'"
		style="padding:1px;background:#eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统缺省页面" style="padding:10px;">
				显示系统信息等等
			</div>
		</div>
	</div>
	<div id="win" data-options="collapsible:false,minizable:false,maximizable:false,modal:true"></div>
</body>
</html>
