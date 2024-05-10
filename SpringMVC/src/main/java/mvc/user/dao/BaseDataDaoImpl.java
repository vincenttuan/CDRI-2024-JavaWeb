package mvc.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mvc.user.model.po.Education;
import mvc.user.model.po.Gender;
import mvc.user.model.po.Interest;

@Repository
public class BaseDataDaoImpl implements BaseDataDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String queryAllSQL = "select item_id as id, item_name as name from base_data where group_name = ?";
	private final String getOneSQL = "select item_id as id, item_name as name from base_data where group_name = ? and item_id = ?";
	
	@Override
	public List<Education> findAllEducations() {
		return jdbcTemplate.query(queryAllSQL, new BeanPropertyRowMapper<>(Education.class), "Education");
	}
	
	@Override
	public Education getEducationById(Integer id) {
		return jdbcTemplate.queryForObject(getOneSQL, new BeanPropertyRowMapper<>(Education.class), "Education", id);
	}
	
	@Override
	public List<Gender> findAllGenders() {
		return jdbcTemplate.query(queryAllSQL, new BeanPropertyRowMapper<>(Gender.class), "Gender");
	}
	
	@Override
	public Gender getGenderById(Integer id) {
		return jdbcTemplate.queryForObject(getOneSQL, new BeanPropertyRowMapper<>(Gender.class), "Gender", id);
	}
	
	@Override
	public List<Interest> findAllInterests() {
		return jdbcTemplate.query(queryAllSQL, new BeanPropertyRowMapper<>(Interest.class), "Interest");
	}
	
	@Override
	public Interest getInterestById(Integer id) {
		return jdbcTemplate.queryForObject(getOneSQL, new BeanPropertyRowMapper<>(Interest.class), "Interest", id);
	}

	@Override
	public int addInterest(Integer userId, Integer interestId) {
		String sql = "insert into user_interest(user_id, interest_id) values(?, ?)";
		return jdbcTemplate.update(sql, userId, interestId);
	}

	@Override
	public int deleteInterestsByUserId(Integer userId) {
		String sql = "delete from user_interest where user_id = ?";
		return jdbcTemplate.update(sql, userId);
	}
	
	
	
}
