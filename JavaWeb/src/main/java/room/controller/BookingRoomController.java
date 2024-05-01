package room.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.model.po.BookingRoom;
import room.service.BookingRoomService;

@WebServlet("/bookingroom")
public class BookingRoomController extends HttpServlet {
	private BookingRoomService bookingRoomService = new BookingRoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BookingRoom> bookingRooms = bookingRoomService.findAllBookingRooms();
		req.setAttribute("bookingRooms", bookingRooms);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/booking_room.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
