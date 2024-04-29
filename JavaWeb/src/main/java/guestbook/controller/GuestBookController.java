package guestbook.controller;

import java.io.IOException;
import java.util.List;

import guestbook.model.GuestBook;
import guestbook.service.GuestBookService;
import guestbook.service.GuestBookServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guestbook")
public class GuestBookController extends HttpServlet {
	
	private GuestBookService service = new GuestBookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得所有留言紀錄
		List<GuestBook> guestBooks = service.queryAll();
		req.setAttribute("guestBooks", guestBooks);
		// 內重導到 jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String content = req.getParameter("content");
		
		boolean state = service.add(username, content);
		req.setAttribute("state", state);
		
		// 內重導到 jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/guestbook_result.jsp");
		rd.forward(req, resp);
		
	}
	
}
