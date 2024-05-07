package session05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import session05.bean.GuestBook;
import session05.dao.GuestBookDao;

@Service("gbService")
public class GuestBookServiceImpl implements GuestBookService {
	
	@Autowired
	@Qualifier("gbDao")
	private GuestBookDao guestBookDao;
	
	@Override
	public boolean add(String username, String content) {
		GuestBook guestBook = new GuestBook(username, content);
		return guestBookDao.create(guestBook) == 1;
	}

	@Override
	public GuestBook getById(Integer id) {
		return guestBookDao.findById(id);
	}

	@Override
	public List<GuestBook> queryAll() {
		return guestBookDao.findAll();
	}

	@Override
	public boolean updateUsername(Integer id, String username) {
		GuestBook guestBook = getById(id);
		if(guestBook == null) {
			return false;
		}
		guestBook.setUsername(username);
		return guestBookDao.update(guestBook) == 1;
	}

	@Override
	public boolean updateContent(Integer id, String content) {
		GuestBook guestBook = getById(id);
		if(guestBook == null) {
			return false;
		}
		guestBook.setContent(content);
		return guestBookDao.update(guestBook) == 1;
	}

	@Override
	public boolean removeById(Integer id) {
		return guestBookDao.deleteById(id) == 1;
	}

}
