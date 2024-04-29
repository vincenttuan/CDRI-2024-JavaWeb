package guestbook.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import guestbook.model.GuestBook;

public class GuestBookDaoInMemory implements GuestBookDao {
	
	// In-Memory 資料
	private List<GuestBook> guestBooks = new CopyOnWriteArrayList<>();
	
	@Override
	public int create(GuestBook guestBook) {
		guestBooks.add(guestBook);
		return 1;
	}

	@Override
	public GuestBook findById(Integer id) {
		return guestBooks.stream().filter(gb -> gb.getId().equals(id)).findFirst().orElseGet(null);
	}

	@Override
	public List<GuestBook> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(GuestBook guestBook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
