<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Boolean state = (Boolean)request.getAttribute("state");
%>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>GuestBook Result</title>
	</head>
	<body style="padding: 15px">
		
		<div class="pure-form">
			<fieldset>
				<legend>GuestBook Result</legend>
				<%=state?"新增成功":"新增失敗" %><p>
				<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary" >返回</a>
			</fieldset>
		</div>
		
	</body>
</html>