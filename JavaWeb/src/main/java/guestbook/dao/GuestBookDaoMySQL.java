package guestbook.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import guestbook.model.GuestBook;

public class GuestBookDaoMySQL implements GuestBookDao {
	
	private JdbcTemplate jdbcTemplate;
	
	{
		String driverName = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei";
		String username = "root";
		String password = "12345678";
		
		// 資料源設定
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(dbURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		// 將資料源設定給 jdbcTemplae
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
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
			return null;
		}
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
