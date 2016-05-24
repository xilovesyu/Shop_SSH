<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	test for index.jsp
  	<a href="${pageContext.request.contextPath}/category_update.action?category.id=1&category.type=ssh_test&category.hot=true">访问update</a> 
  	<br>
  	<a href="${pageContext.request.contextPath}/category_update.action?id=1&type=modeld_test&hot=true">访问update</a> 
  	<br>
  	
  	<a href="category_query.action">查询所有类别</a>
  	<c:forEach items="${requestScope.categoryList}" var="category">
  		${category.id}|${category.type}|${category.hot} <br>
  	</c:forEach>
  	
  	<br><hr>Session
  	<c:forEach items="${sessionScope.categoryList}" var="category">
  		${category.id}|${category.type}|${category.hot} <br>
  	</c:forEach>
  	
  	<br><hr>Application
  	<c:forEach items="${applicationScope.categoryList}" var="category">
  		${category.id}|${category.type}|${category.hot} <br>
  	</c:forEach>
  	
  	<br>
  	<a href="account_query.action">查询所有账户</a>
  	<c:forEach items="${applicationScope.accountList}" var="account">
  		${account.id}|${account.login}|${account.name} |${account.pass}<br>
  	</c:forEach>
  </body>
</html>
