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
		<title>Pass Code</title>
	</head>
	<body style="padding: 15px">
		<!-- Pass Code -->
		<form class="pure-form" method="post">
			<fieldset>
				<legend>Pass Code</legend>
				Pass Code: <input type="number" id="passcode" name="passcode" placeholder="請輸入passcode" required /><p>
				<button type="submit" class="pure-button pure-button-primary">驗證</button>
			</fieldset>
		</form>
		
		
</body>
</html>