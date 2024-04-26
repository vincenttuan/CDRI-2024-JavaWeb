package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet {
	
	// 存放 bmi 的歷史紀錄
	private List<Map<String, Object>> bmiList = new CopyOnWriteArrayList();
	
	// 查詢使用
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 編碼
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 回應內容:
		//resp.getWriter().print(bmiList);
		// 回應內容(含 HTML):
		resp.getWriter().print("<html>");
		resp.getWriter().print("<head>");
		resp.getWriter().print("</head>");
		resp.getWriter().print("<body>");
		resp.getWriter().print("<table border='1'>");
		
		resp.getWriter().print("<thead>");
		resp.getWriter().print("<tr>");
		resp.getWriter().print("<th>Name</th>");
		resp.getWriter().print("<th>Height</th>");
		resp.getWriter().print("<th>Weight</th>");
		resp.getWriter().print("<th>BMI</th>");
		resp.getWriter().print("</tr>");
		resp.getWriter().print("</thead>");
		
		resp.getWriter().print("<body>");
		resp.getWriter().print("<tr>");
		
		resp.getWriter().print("</tr>");
		resp.getWriter().print("</body>");
		
		resp.getWriter().print("</table>");
		resp.getWriter().print("</body>");
		resp.getWriter().print("</html>");
	}
	
	// 表單使用

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 編碼
		req.setCharacterEncoding("utf-8");
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
		
		// 建立 Map 集合放置表單與bmi的內容
		Map<String, Object> map = new LinkedHashMap();
		map.put("name", userName);
		map.put("height", height);
		map.put("weight", weight);
		map.put("bmi", bmi);
		// 將資料儲存到 bmiList 集合中
		bmiList.add(map);
		
		// 回應內容:
		resp.getWriter().print("BMI Result = " + bmi);
		
	}
	
	
	
}
