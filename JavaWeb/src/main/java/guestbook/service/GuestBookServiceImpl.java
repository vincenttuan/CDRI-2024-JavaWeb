package guestbook.service;

import java.util.List;

import guestbook.dao.GuestBookDao;
import guestbook.dao.GuestBookDaoInMemory;
import guestbook.dao.GuestBookDaoMySQL;
import guestbook.model.GuestBook;

public class GuestBookServiceImpl implements GuestBookService {
	
	//private GuestBookDao dao = new GuestBookDaoInMemory();
	private GuestBookDao dao = new GuestBookDaoMySQL();
	
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
		GuestBook gb = dao.findById(id);
		if(gb == null) {
			return false;
		}
		gb.setUsername(username);
		int rowcount = dao.update(gb);
		return rowcount == 1;
	}

	@Override
	public boolean updateContent(Integer id, String content) {
		GuestBook gb = dao.findById(id);
		if(gb == null) {
			return false;
		}
		gb.setContent(content);
		int rowcount = dao.update(gb);
		return rowcount == 1;
	}

	@Override
	public boolean removeById(Integer id) {
		int rowcount = dao.deleteById(id);
		return rowcount == 1;
	}
	
}
