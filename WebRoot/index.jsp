<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	test for index.jsp
  	<a href="${pageContext.request.contextPath}/category_update.action?category.id=5&category.type=ssh_test&category.hot=true">访问update</a> 
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
  </body>
</html>
