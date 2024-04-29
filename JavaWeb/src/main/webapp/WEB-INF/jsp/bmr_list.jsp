<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 接收來自 BMRServlet 的資料
	List<Map<String, Object>> bmrList = (List)request.getAttribute("bmrList");
%>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>BMR List</title>
	</head>
	<body style="padding: 15px">
		<h2>BMR List:</h2>
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>Id</th><th>Name</th><th>Gender</th><th>Age</th><th>Height</th><th>Weight</th><th>BMR</th>
				</tr>
			</thead>
			<tbody>
				<% for(int i=0;i<bmrList.size();i++) { %>
				<tr>
					<% Map<String, Object> map = bmrList.get(i); %>
					<td><%=i %></td>
					<td><%=map.get("name") %></td>
					<td><%=map.get("gender") %></td>
					<td><%=map.get("age") %></td>
					<td><%=map.get("height") %></td>
					<td><%=map.get("weight") %></td>
					<td><%=map.get("age") %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<p>
		<a href="/JavaWeb/bmr.html" class="pure-button pure-button-primary" >回上一頁</a>
	</body>
</html>