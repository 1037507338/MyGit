<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部分图书查询</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="${path}/resources/css/table.css" type="text/css">
</head>
<body>
<a href='logout.do' id='a_logout'>注销</a>
<form action='partbookselect.do' method='post'>
搜索：<input type='text' name='partname'>
<input type='submit' value='查询'>
</form>
<table id='table_main'>
<tr><th>书籍编号</th><th>书籍名</th><th>价格</th></tr>
<c:forEach items="${booklist}" var="book">
<tr>
	<td>${book.bookid}</td>
	<td>${book.bookname}</td>
	<td>${book.bookprice}</td>
</tr>
</c:forEach>
</table>
<a href='bookselect.do' id='a_book'>返回</a>
</body>
</html>