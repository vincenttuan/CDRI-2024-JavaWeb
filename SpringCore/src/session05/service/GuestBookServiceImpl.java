package session05.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import session05.bean.GuestBook;

//@Component
@Service
public class GuestBookServiceImpl implements GuestBookService {

	@Override
	public boolean add(String username, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GuestBook getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuestBook> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUsername(Integer id, String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateContent(Integer id, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
