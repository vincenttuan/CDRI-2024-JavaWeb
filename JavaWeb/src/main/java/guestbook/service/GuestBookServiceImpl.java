package guestbook.service;

import java.util.List;

import guestbook.dao.GuestBookDao;
import guestbook.dao.GuestBookDaoInMemory;
import guestbook.model.GuestBook;

public class GuestBookServiceImpl implements GuestBookService {
	
	private GuestBookDao dao = new GuestBookDaoInMemory();
	
	@Override
	public boolean add(String username, String content) {
		GuestBook gb = new GuestBook(username, content);
		int rowcount = dao.create(gb);
		return rowcount == 1;
	}

	@Override
	public GuestBook getById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<GuestBook> queryAll() {
		return dao.findAll();
	}

	@Override
	public boolean updateUsername(Integer id, String username) {
		
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
