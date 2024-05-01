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
		<title>Booking Room</title>
	</head>
	<body style="padding: 15px">
		<!-- 新增Booking Room -->
		<form class="pure-form" action="/JavaWeb/bookingroom" method="post">
			<fieldset>
				<legend>BookingRoom Add</legend>
				Room Name: <select id="room_id" name="room_id">
							<c:forEach items="${ rooms }" var="room">
								<option value="${ room.roomId }">${ room.roomName }</option>
							</c:forEach>
						   </select><p>
				Check In: <input type="date" id="checkin_date" name="checkin_date" /><p>
				<button type="submit" class="pure-button pure-button-primary">Booking</button>
			</fieldset>
		</form>
		<!-- BookingRoom列表 -->
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>Booking Id</th>
					<th>Room Id</th>
					<th>Room Name</th>
					<th>User Id</th>
					<th>Check In</th>
					<th>Create Time</th>
					<th>修改</th>
					<th>刪除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookingRoomDtos}" var="bookingRoomDto">
					<tr>
						<td>${ bookingRoomDto.bookingId }</td>
						<td>${ bookingRoomDto.room.roomId }</td>
						<td>${ bookingRoomDto.room.roomName }</td>
						<td>${ bookingRoomDto.userId }</td>
						<td>${ bookingRoomDto.checkinDate }</td>
						<td>${ bookingRoomDto.createTime }</td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- BookingRoomCounts列表 -->
		${ bookingRoomCounts }
</body>
</html>