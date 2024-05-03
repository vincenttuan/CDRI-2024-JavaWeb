package guestbook.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 通關密碼: code=1234
// 使用者輸入通關密碼才可以到訪客留言版(GuestBook)
@WebFilter("/guestbook")
public class PassCodeFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("PassCodeFilter 過濾 " + request.getMethod());
		
		if(request.getMethod().equals("GET")) {
			// 檢查 code 是否等於 1234
			if(request.getParameter("code") == null || !request.getParameter("code").equals("1234")) {
				response.getWriter().print("PassCode Error !");
				return;
			}
		}
		// 放行
		chain.doFilter(request, response);
	}
	
}
