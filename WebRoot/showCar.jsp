<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
</head>
<body>
	购物车显示页面
	<table>
	<tr>
		<td>编号</td>
		<td>商品名</td>
		<td>价格</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${sessionScope.forder.sorderSet}" var="sorder" varStatus="num">
		<tr>
			<td>${num.count}</td>
			<td>${sorder.name}</td>
			<td>${sorder.price}</td>
			<td><input type="text" size="3" value="${sorder.number}"/></td>
			<td>${sorder.price*sorder.number}</td>
			
		</tr>
	</c:forEach>
		<tr colspan="6">总价格：￥${sessionScope.forder.total}</tr>
	</table>
</body>
</html>