package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 編碼
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 接收參數
		String userName = req.getParameter("userName");
		String userHeight = req.getParameter("userHeight");
		String userWeight = req.getParameter("userWeight");
		
		// 計算 BMI
		// 將 userHeight 與 userWeight 由 String 轉 Double
		double height = Double.parseDouble(userHeight);
		double weight = Double.parseDouble(userWeight);
		double bmi = weight / Math.pow(height/100, 2);
		
		// 回應內容:
		resp.getWriter().print("BMI Result = " + bmi);
		
	}
	
	
	
}
