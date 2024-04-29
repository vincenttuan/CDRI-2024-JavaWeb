package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmr")
public class BMRServlet extends HttpServlet {
	
	// 紀錄查詢
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理資料
		
		// 分派到 jsp
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 接收參數
		String userName = req.getParameter("userName");
		String userGender = req.getParameter("userGender");
		String userAge = req.getParameter("userAge");
		String userHeight = req.getParameter("userHeight");
		String userWeight = req.getParameter("userWeight");
		
		double age = Double.parseDouble(userAge);
		double height = Double.parseDouble(userHeight);
		double weight = Double.parseDouble(userWeight);
		
		// 根據性別計算 bmr
		double bmr = 0;
		switch (userGender) {
			case "M":
				bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
				break;
			case "F":
				bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
				break;
		}
		
		// 回應內容:
		resp.getWriter().print("BMR Result = " + bmr);
	}
	
}
