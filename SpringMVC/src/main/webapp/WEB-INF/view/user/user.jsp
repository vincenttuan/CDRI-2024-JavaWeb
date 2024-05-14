<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!-- JSTL 標籤 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" />
		<title>User 首頁</title>
	</head>
	<body style="padding:15px">
		<h1>User 資料維護</h1>
		<hr />
		<table border=0>
			<tr>
				<!-- User 列表 -->
				<td colspan="2" valign="top">
					<%@ include file="userlist.jspf" %>
				</td>
			</tr>
			<tr>
				<!-- User 表單 -->
				<td valign="top">
					<%@ include file="userform.jspf" %>
				</td>
				<!-- User 圖表 -->
				<td valign="top">
					<%@ include file="userstatistics.jspf" %>
				</td>
			</tr>
		</table>
		
	</body>
</html>