package mvc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.user.model.po.User;
import mvc.user.service.UserService;

/**
 * 定義 URI 服務
 * ------------------------------------------------------------------
 * Method | URI     | Description
 * ------------------------------------------------------------------
 * GET    | /user   | 取得所有使用者資料
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
	@ResponseBody
	public String queryAllUsers() {
		List<User> users = userService.findUsers();
		return users.toString();
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
		Boolean success = userService.addUser(user);
		return "create: " + success;
	}
	
	@PutMapping("/{userId}")
	@ResponseBody
	public String updateUser(@PathVariable("userId") Integer userId, User user) {
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
