package session05.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import session05.bean.GuestBook;

@Repository("gbDao")
public class GuestBookDaoImpl implements GuestBookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(GuestBook guestBook) {
		String sql = "insert into guestbook(username, content) values(?, ?)";
		return jdbcTemplate.update(sql, guestBook.getUsername(), guestBook.getContent());
	}

	@Override
	public GuestBook findById(Integer id) {
		String sql = "select id, username, content, create_date, update_date from guestbook where id = ?";
		try {
			GuestBook guestBook = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(GuestBook.class), id);
			return guestBook;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<GuestBook> findAll() {
		String sql = "select id, username, content, create_date, update_date from guestbook order by id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GuestBook.class));
	}

	@Override
	public int update(GuestBook guestBook) {
		String sql = "update guestbook set username=?, content=?, update_date=? where id=?";
		return jdbcTemplate.update(sql, guestBook.getUsername(), guestBook.getContent(), new Date(), guestBook.getId());
	}

	@Override
	public int deleteById(Integer id) {
		String sql = "delete from guestbook where id = ?";
		return jdbcTemplate.update(sql, id);
	}
	
}
