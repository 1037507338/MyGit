<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="${path}/resources/css/table.css" type="text/css">
</head>
<body>
<a href='logout.do' id='a_logout'>注销</a><br>
<table id='table_main'>
<tr><td>用户id</td><td>${user.userid}</td></tr>
<tr><td>用户名</td><td>${user.username}</td></tr>
<tr><td>真实姓名</td><td>${user.realname}</td></tr>
<tr><td>性别</td><td>${user.sex}</td></tr>
<tr><td>生日</td><td>${user.birth}</td></tr>
<tr><td>地址</td><td>${user.address}</td></tr>
<tr><td>爱好</td><td>${user.hobby}</td></tr>
</table>
<a href='bookselect.do' id='a_book'>图书表</a>
</body>
</html>