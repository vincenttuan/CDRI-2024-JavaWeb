package room.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.service.RoomService;

// 進行 Room 修改
@WebServlet("/room/update")
public class RoomUpdateController extends HttpServlet {
	private RoomService service = new RoomService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 Room ID
		Integer roomId = Integer.parseInt(req.getParameter("roomId"));
		// 取得 Room 資料
		req.setAttribute("room", service.getRoom(roomId));
		// 轉發至 Room 修改頁面
		req.getRequestDispatcher("/WEB-INF/jsp/room_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 Room ID
		Integer roomId = Integer.parseInt(req.getParameter("roomId"));
		// 取得 Room 名稱
		String roomName = req.getParameter("roomName");
		// 取得 Room 資料
		service.updateRoom(roomId, roomName);
		// 重新導向至 Room 主頁面
		resp.sendRedirect(req.getContextPath() + "/room");
	}
	
}
