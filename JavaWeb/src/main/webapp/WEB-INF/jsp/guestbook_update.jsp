<%@page import="guestbook.model.GuestBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	GuestBook guestBook = (GuestBook)request.getAttribute("guestbook");
%>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>GuestBook Update</title>
	</head>
	<body style="padding: 15px">
		<!-- 修改留言 -->
		<form class="pure-form" action="/JavaWeb/guestbook/update" method="post">
			<fieldset>
				<legend>GuestBook Update</legend>
				序號: <input type="text" id="id" name="id" value="<%=guestBook.getId() %>" readonly /><p>
				姓名: <input type="text" id="username" name="username" value="<%=guestBook.getUsername() %>" placeholder="請輸入姓名" required /><p>
				留言: <br> 
				<textarea rows="5" cols="20" id="content" name="content" placeholder="請留言" required>
					<%=guestBook.getContent() %>
				</textarea><p>
				<button type="submit" class="pure-button pure-button-primary">修改留言</button>
			</fieldset>
		</form>
		
		
	</body>
</html>