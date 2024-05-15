package mvc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mvc.user.dao.BaseDataDao;
import mvc.user.model.dto.UserDto;
import mvc.user.model.po.Education;
import mvc.user.model.po.Interest;
import mvc.user.model.po.User;
import mvc.user.model.response.ApiResponse;
import mvc.user.service.UserService;

/**
 * 定義 URI 服務
 * ---------------------------------------------------------------------------------
 * Method | URI          | Description
 * ---------------------------------------------------------------------------------
 * GET    | /rest/user   | 取得所有使用者 json 資料
 * GET    | /rest/user/1 | 根據 userId 取得單筆使用者 json 資料
 * POST   | /rest/user   | 新增使用者資料, 會自動夾帶 User 的 json 物件資料上來
 * PUT    | /rest/user/1 | 修改指定 userId 的使用者資料, 會自動夾帶要修改的 User 的 json 物件資料上來
 * DELETE | /rest/user/1 | 刪除指定 userId 的使用者紀錄
 * ---------------------------------------------------------------------------------
 * URL 範例: GET http://localhost:8080/SpringMVC/mvc/rest/user
 */

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BaseDataDao baseDataDao;
	
	@GetMapping("/educations")
	public List<Education> queryEducations() {
		return baseDataDao.findAllEducations();
	}
	
	@GetMapping("/interests")
	public List<Interest> queryInterests() {
		return baseDataDao.findAllInterests();
	}
	
	// 查詢多筆紀錄
	@GetMapping
	public ResponseEntity<ApiResponse<List<UserDto>>> queryAllUsers() {
		List<UserDto> userDtos = userService.findUserDtos();
		ApiResponse apiResponse = new ApiResponse<>(true, "query success", userDtos);
		// 回傳 json 字串
		return ResponseEntity.ok(apiResponse);
	}
	
	// 查詢單筆紀錄
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<User>> getUser(@PathVariable("id") Integer id) {
		try {
			User user = userService.getUser(id);
			ApiResponse apiResponse = new ApiResponse<>(true, "get success", user);
			return ResponseEntity.ok(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
			ApiResponse apiResponse = new ApiResponse<>(false, e.getMessage(), null);
			return ResponseEntity.ok(apiResponse);
		}
	}
	
	// 新增紀錄
	@PostMapping
	public ResponseEntity<ApiResponse<User>> addUser(@RequestBody User user) {
		Integer userId = userService.addUserAndGetId(user);
		if(userId != null) {
			user.setId(userId);
			ApiResponse apiResponse = new ApiResponse<>(true, "add success", user);
			return ResponseEntity.ok(apiResponse);
		}
		ApiResponse apiResponse = new ApiResponse<>(false, "add fail", user);
		return ResponseEntity.ok(apiResponse);
	
	}
	
	// 修改紀錄 PUT
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		// 修改
		Boolean state = userService.updateUser(id, user);
		// 將 id 注入到 user 物件中, 有助於前端判讀
		user.setId(id);
		String message = state ? "success" : "fail";
		// 回應資料
		ApiResponse apiResponse = new ApiResponse<>(state, "update " + message, user);
		return ResponseEntity.ok(apiResponse);
	}
	
	// 刪除紀錄 Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable("id") Integer id) {
		User user = null;
		try {
			// 查詢該 user 是否存在
			user = userService.getUser(id);
			// 刪除
			Boolean state = userService.deleteUser(id);
			String message = state ? "success" : "fail";
			// 回應資料
			ApiResponse apiResponse = new ApiResponse<>(state, "delete " + message, user);
			return ResponseEntity.ok(apiResponse);
		} catch (Exception e) {
			ApiResponse apiResponse = new ApiResponse<>(false, e.toString(), user);
			return ResponseEntity.ok(apiResponse);
		}
		
	}
	
}









