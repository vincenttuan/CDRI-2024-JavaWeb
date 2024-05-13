package mvc.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.user.model.dto.UserDto;
import mvc.user.model.po.User;
import mvc.user.service.UserService;

/**
 * 定義 URI 服務
 * ------------------------------------------------------------------
 * Method | URI     | Description
 * ------------------------------------------------------------------
 * GET    | /user   | 取得所有使用者資料並重導到 /WEB-INF/view/user/user.jsp 頁面
 * GET    | /user/1 | 根據 userId 取得單筆使用者資料
 * POST   | /user   | 新增使用者資料, 會自動夾帶 User 物件資料上來
 * PUT    | /user/1 | 修改指定 userId 的使用者資料, 會自動夾帶要修改的 User 物件資料上來
 * DELETE | /user/1 | 刪除指定 userId 的使用者紀錄
 * ------------------------------------------------------------------
 * URL 範例: GET http://localhost:8080/SpringMVC/mvc/user
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	// model: 欲將給 jsp 的資料要放在 model 容器中
	public String queryAllUsers(Model model) {
		List<UserDto> userDtos = userService.findUserDtos();
		// 將 userDtos 資料傳給 jsp
		model.addAttribute("userDtos", userDtos);
		// 完整 jsp(view) 路徑 = "/WEB-INF/view/user/user.jsp";
		// 因為在 springmvc-servlet.xml
		// 已經定義: prefix = "/WEB-INF/view/"
		//        suffix = ".jsp"
		// 所以只要寫成 "user/user"
		return "user/user";
	}
	
	@GetMapping("/{userId}")
	@ResponseBody
	public String getUser(@PathVariable("userId") Integer userId) {
		User user = userService.getUser(userId);
		return user.toString();
	}
	
	@PostMapping
	@ResponseBody
	public String createUser(User user) {
		System.out.println(user);
		Boolean success = userService.addUser(user);
		return "create: " + success;
	}
	
	@PutMapping("/{userId}")
	@ResponseBody
	public String updateUser(@PathVariable("userId") Integer userId, User user) {
		System.out.println(user);
		Boolean success = userService.updateUser(userId, user);
		return "update: " + success;
	}
	
	@DeleteMapping("/{userId}")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") Integer userId) {
		Boolean success = userService.deleteUser(userId);
		return "delete: " + success;
	}
	
}
