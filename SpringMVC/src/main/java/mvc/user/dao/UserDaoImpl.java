package mvc.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mvc.user.model.po.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public int addUser(User user) {
		String sql = "insert into user(name, age, birth, resume, education_id, gender_id) values(?, ?, ?, ?, ?, ?)";
		//return jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getBirth(), user.getResume(), user.getEducationId(), user.getGenderId());
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return namedParameterJdbcTemplate.update(sql, params);
	}

	@Override
	public int updateUser(Integer id, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
