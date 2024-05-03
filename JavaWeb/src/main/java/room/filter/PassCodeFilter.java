package room.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/room/*", "/bookingroom/*"})
public class PassCodeFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession(); // 取得 session 物件
		System.out.println("PassCodeFilter for Room, sessionId = " + session.getId());
		// 檢查 request 是否有帶入 ?code=1234
		String code = request.getParameter("code") == null? "" : request.getParameter("code");
		if(code.equals("1234")) { // 檢查參數 code 是否等於 1234
			// 將 code 的值寫入到 session 屬性中
			session.setAttribute("code", code);
			chain.doFilter(request, response); // pass
		} else if("1234".equals(session.getAttribute("code")+"")) { // 檢查 session["code"] 的內容是否是 1234
			chain.doFilter(request, response); // pass
		} else {
			//response.getWriter().print("PassCode Error !");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/passcode.jsp");
			rd.forward(request, response);
		}
		
	}
	
}
