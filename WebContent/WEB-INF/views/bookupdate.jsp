<%@page import="com.wdh.util.TB_Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='logout.do'>注销</a><br>
<form action="bookupdate.do" method="post">
<table>
	<tr><td><label for="bookname">书籍编号：</label></td>
    <td><input type="text" name="bookid" value="${book.bookid}" readonly></td></tr>
    <tr><td><label for="bookname">书籍名：</label></td>
    <td><input type="text" name="bookname" value="${book.bookname}"></td></tr>
    <tr><td><label for="bookprice">价格：</label></td>
    <td><input type="text" name="bookprice" value="${book.bookprice}"></td></tr>
    <tr><td><input type="submit" value="修改"></td>
</table>
<a href='bookselect.do' id='a_book'>返回</a>
</form>
</body>
</html>