package mvc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import mvc.user.dao.BaseDataDao;
import mvc.user.model.dto.UserDto;
import mvc.user.model.po.User;
import mvc.user.service.UserService;

/**
 * 定義 URI 服務
 * ---------------------------------------------------------------------------------
 * Method | URI          | Description
 * ---------------------------------------------------------------------------------
 * GET    | /rest/user   | 取得所有使用者 json 資料
 * GET    | /rest/user/1 | 根據 userId 取得單筆使用者 json 資料
 * POST   | /rest/user/  | 新增使用者資料, 會自動夾帶 User 的 json 物件資料上來
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
	
	Gson gson = new Gson();
	
	@GetMapping
	public String queryAllUsers() {
		List<UserDto> userDtos = userService.findUserDtos();
		// 回傳 json 字串
		return gson.toJson(userDtos);
	} 
}









