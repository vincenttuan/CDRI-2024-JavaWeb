<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>Room</title>
	</head>
	<body style="padding: 15px">
		<!-- 新增Room -->
		<form class="pure-form" action="/JavaWeb/room" method="post">
			<fieldset>
				<legend>Room Add</legend>
				Room Id: <input type="number" id="roomId" name="roomId" placeholder="請輸入roomId" required /><p>
				Room Name: <input type="text" id="roomName" name="roomName" placeholder="請輸入roomName" required /><p>
				<button type="submit" class="pure-button pure-button-primary">新增Room</button>
			</fieldset>
		</form>
		<!-- Room列表 -->
	
</body>
</html>