package guestbook.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import guestbook.model.GuestBook;

public class GuestBookDaoInMemory implements GuestBookDao {
	
	// In-Memory 資料
	private List<GuestBook> guestBooks = new CopyOnWriteArrayList<>();
	
	@Override
	public int create(GuestBook guestBook) {
		// 找到 guestBooks 中 id 的最大值
		Integer maxId = guestBooks.stream()
				.map(GuestBook::getId) // .map(gb -> gb.getId())
				.max(Integer::compareTo) // .max((o1, o2) -> Integer.compare(o1, o2))
				.orElse(0);
		maxId += 1; // 將最大值加一
		guestBook.setId(maxId);
		guestBook.setCreateDate(new Date());
		guestBooks.add(guestBook);
		return 1;
	}

	@Override
	public GuestBook findById(Integer id) {
		return guestBooks.stream().filter(gb -> gb.getId().equals(id)).findFirst().orElseGet(null);
	}

	@Override
	public List<GuestBook> findAll() {
		return guestBooks;
	}

	@Override
	public int update(GuestBook guestBook) {
		GuestBook guestBookUpt = findById(guestBook.getId());
		if(guestBookUpt == null) {
			return 0;
		}
		guestBookUpt.setUsername(guestBook.getUsername());
		guestBookUpt.setContent(guestBook.getContent());
		guestBookUpt.setUpdateDate(new Date());
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		GuestBook guestBookDel = findById(id);
		if(guestBookDel == null) {
			return 0;
		}
		guestBooks.remove(guestBookDel);
		return 1;
	}

}
