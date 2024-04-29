<%@page import="guestbook.model.GuestBook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	List<GuestBook> guestBooks = (List)request.getAttribute("guestBooks");
%>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>GuestBook</title>
	</head>
	<body style="padding: 15px">
		<!-- 新增留言 -->
		<form class="pure-form" action="/JavaWeb/guestbook" method="post">
			<fieldset>
				<legend>GuestBook Add</legend>
				姓名: <input type="text" id="username" name="username" placeholder="請輸入姓名" required /><p>
				留言: <br> 
				<textarea rows="5" cols="10" id="content" name="content" placeholder="請留言" required></textarea><p>
				<button type="submit" class="pure-button pure-button-primary">新增留言</button>
			</fieldset>
		</form>
		
	</body>
</html>