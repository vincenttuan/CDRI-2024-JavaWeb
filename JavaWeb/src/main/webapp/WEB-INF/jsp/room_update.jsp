<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>Room Update</title>
	</head>
	<body style="padding: 15px">
		<!-- 修改Room -->
		<form class="pure-form" action="/JavaWeb/room/update" method="post">
			<fieldset>
				<legend>Room Update</legend>
				Room Id: <input type="text" id="roomId" name="roomId" value="${ room.roomId }" readonly /><p>
				Room Name: <input type="text" id="roomName" name="roomName" value="${ room.roomName }" placeholder="請輸入room name" required /><p>
				<button type="submit" class="pure-button pure-button-primary">修改Room</button>
			</fieldset>
		</form>
		
		
	</body>
</html>