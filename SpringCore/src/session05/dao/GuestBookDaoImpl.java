package session05.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import session05.bean.GuestBook;

//@Component
@Repository
public class GuestBookDaoImpl implements GuestBookDao {

	@Override
	public int create(GuestBook guestBook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GuestBook findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
