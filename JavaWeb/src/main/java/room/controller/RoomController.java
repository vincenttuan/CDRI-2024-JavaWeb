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
	// 建立 RoomService 物件
	private RoomService roomService = new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 是否有 deleteId 參數帶入 ?
		String deleteId = req.getParameter("deleteId");
		// 如果有 deleteId 參數帶入
		if (deleteId != null) {
			// 刪除房間
			roomService.deleteRoom(Integer.valueOf(deleteId));
			// 重新導向至 /room
			resp.sendRedirect(req.getContextPath() + "/room");
			return;
		}
		// 將所有房間資料放入 request 物件中
		req.setAttribute("rooms", roomService.getRooms());
		// 轉交至 /WEB-INF/jsp/room.jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
		// 轉交
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 roomId 及 roomName 參數
		Integer roomId = Integer.valueOf(req.getParameter("roomId"));
		String roomName = req.getParameter("roomName");
		// 新增房間
		roomService.addRoom(roomId, roomName);
		// 重新導向至 /room
		resp.sendRedirect(req.getContextPath() + "/room"); // resp.sendRedirect("/JavaWeb/room");
	}
	
	
}
