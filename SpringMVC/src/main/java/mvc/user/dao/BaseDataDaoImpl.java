package mvc.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Education getEducationById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Gender> findAllGenders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Gender getGenderById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Interest> findAllInterests() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Interest getInterestById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
