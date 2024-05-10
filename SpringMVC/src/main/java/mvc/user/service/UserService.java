package mvc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.user.dao.UserDao;
import mvc.user.model.po.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findUsers() {
		return userDao.findAllUsers();
	}
	
	public User getUser(Integer userId) {
		return userDao.getUserById(userId);
	}
	
	public Boolean addUser(User user) {
		return userDao.addUser(user) > 0;
	}
	
	public Boolean updateUser(Integer userId, User user) {
		return userDao.updateUser(userId, user) > 0;
	}
	
	public Boolean deleteUser(Integer userId) {
		return userDao.deleteUser(userId) > 0;
	}
}
