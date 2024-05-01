package room.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.dao.BookingRoomDao;
import room.model.dto.BookingRoomDto;
import room.model.po.BookingRoom;
import room.model.po.Room;
import room.service.BookingRoomService;
import room.service.RoomService;

@WebServlet("/bookingroom")
public class BookingRoomController extends HttpServlet {
	private BookingRoomService bookingRoomService = new BookingRoomService();
	private RoomService roomService = new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// dto 列表(空)
		List<BookingRoomDto> bookingRoomDtos = new ArrayList<>();
		
		// po 轉 dto
		List<BookingRoom> bookingRooms = bookingRoomService.findAllBookingRooms();
		for(BookingRoom bookingRoom : bookingRooms) {
			BookingRoomDto dto = new BookingRoomDto();
			dto.setBookingId(bookingRoom.getBookingId());
			dto.setCheckinDate(bookingRoom.getCheckinDate());
			dto.setCreateTime(bookingRoom.getCreateTime());
			dto.setUserId(bookingRoom.getUserId());
			Room room = roomService.getRoom(bookingRoom.getRoomId());
			dto.setRoom(room);
			
			// 加入到集合
			bookingRoomDtos.add(dto);
		}
		
		
		req.setAttribute("bookingRoomDtos", bookingRoomDtos);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/booking_room.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
