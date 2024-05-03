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
		// 取得 session 中的 passCode
		String passCode = session.getAttribute("passCode") + "";
		System.out.println(code + ", " + passCode);
		if(code.equals(passCode)) { // 檢查參數 code 是否等於 passCode
			// 將 code 的值寫入到 session 屬性中
			session.setAttribute("code", code);
			chain.doFilter(request, response); // pass
		} else if(session.getAttribute("code") != null) { // 檢查 session["code"] 是否有資訊
			chain.doFilter(request, response); // pass
		} else {
			//response.getWriter().print("PassCode Error !");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/passcode.jsp");
			rd.forward(request, response);
		}
		
	}
	
}
