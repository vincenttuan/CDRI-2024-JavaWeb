package mvc.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.user.dao.BaseDataDao;
import mvc.user.dao.UserDao;
import mvc.user.model.dto.UserDto;
import mvc.user.model.po.Interest;
import mvc.user.model.po.Statistics;
import mvc.user.model.po.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BaseDataDao baseDataDao;
	
	public List<User> findUsers() {
		return userDao.findAllUsers();
	}
	
	public List<UserDto> findUserDtos() {
		List<UserDto> userDtos = new ArrayList<>();
		// PO
		List<User> users = findUsers();
		// PO 轉 DTO
		for(User user : users) {
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setAge(user.getAge());
			userDto.setBirth(user.getBirth());
			userDto.setResume(user.getResume());
			userDto.setEducation(baseDataDao.getEducationById(user.getEducationId()));
			userDto.setGender(baseDataDao.getGenderById(user.getGenderId()));
			
			// 找到user所有興趣id
			Integer[] interestIds = user.getInterestIds();
			// 準備一個興趣List, 用來存放所有興趣物件
			List<Interest> interests = new ArrayList<>();
			for(Integer interestId : interestIds) {
				// 透過interestId得到興趣物件
				Interest interest = baseDataDao.getInterestById(interestId);
				// 將興趣物件注入到興趣List
				interests.add(interest);
			}
			userDto.setInterests(interests);
			// 將 userDto 注入到 userDtos 列表
			userDtos.add(userDto);
		}
		return userDtos;
	}
	
	public User getUser(Integer userId) {
		return userDao.getUserById(userId);
	}
	
	// 新增 user 並回傳是否成功
	public Boolean addUser(User user) {
		return addUserAndGetId(user) > 0;
	}
	
	// 新增 user 並回傳最新 userId
	public Integer addUserAndGetId(User user) {
		return userDao.addUser(user);
	}
	
	public Boolean updateUser(Integer userId, User user) {
		return userDao.updateUser(userId, user) > 0;
	}
	
	public Boolean deleteUser(Integer userId) {
		return userDao.deleteUser(userId) > 0;
	}
	
	public List<Statistics> queryStatistics(String statisticsName) {
		switch (statisticsName) {
			case "Gender":
				return userDao.queryGenderStatistics();
			case "Education":
				return userDao.queryEducationStatistics();
		}
		return null;
	}
}
