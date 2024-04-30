package guestbook.controller;

import java.io.IOException;

import guestbook.model.GuestBook;
import guestbook.service.GuestBookService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guestbook/update")
public class GuestBookUpdateController extends HttpServlet {
	
	private GuestBookService guestBookService;
	
	// 指向修改頁面
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String updateId = req.getParameter("updateId");
		if(updateId == null) {
			return;
		}
		GuestBook guestBook = guestBookService.getById(Integer.parseInt(updateId));
		req.setAttribute("guestBook", guestBook);
		// 重導到修改頁面(Server 內部重導)
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook_update.jsp");
		rd.forward(req, resp);
	}
	
	// 修改內容
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String content = req.getParameter("content");
		
		guestBookService.updateUsername(id, content);
		guestBookService.updateContent(id, content);
		
		// 透過 redirtect 重導到首頁(Client 外部重導)
		resp.sendRedirect("/JavaWeb/guestbook");
	}
	
	
	
}
