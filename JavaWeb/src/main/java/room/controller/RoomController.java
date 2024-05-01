package room.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.service.RoomService;

@WebServlet("/room")
public class RoomController extends HttpServlet {
	
	private RoomService roomService = new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("rooms", roomService.getRooms());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer roomId = Integer.valueOf(req.getParameter("roomId"));
		String roomName = req.getParameter("roomName");
		roomService.addRoom(roomId, roomName);
		resp.sendRedirect(req.getContextPath() + "/room"); // resp.sendRedirect("/JavaWeb/room");
	}
	
	
}
