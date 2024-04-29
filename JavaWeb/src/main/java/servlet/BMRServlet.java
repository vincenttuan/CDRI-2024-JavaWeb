package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmr")
public class BMRServlet extends HttpServlet {
	
	// 存放 bmr 的歷史紀錄
	private List<Map<String, Object>> bmrList = new CopyOnWriteArrayList();
	
	// 紀錄查詢
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理資料
		// 透過 setAttribute 將 bmrList 放到 req 屬性中的技術
		// 就可以將 bmrList 傳遞給 jsp
		req.setAttribute("bmrList", bmrList);
		
		// 分派到 jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/bmr_list.jsp");
		rd.forward(req, resp);
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
		
		// 建立 Map 集合放置表單與bmr的內容
		Map<String, Object> map = new LinkedHashMap();
		map.put("name", userName);
		map.put("gender", userGender);
		map.put("age", userAge);
		map.put("height", userHeight);
		map.put("weight", userWeight);
		map.put("bmr", bmr);
		bmrList.add(map);
		
		// 回應內容:
		resp.getWriter().print("BMR Result = " + bmr);
	}
	
}
