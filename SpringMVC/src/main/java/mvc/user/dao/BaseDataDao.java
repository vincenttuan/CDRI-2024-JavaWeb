package mvc.user.dao;

import java.util.List;

import mvc.user.model.po.Education;
import mvc.user.model.po.Gender;
import mvc.user.model.po.Interest;

public interface BaseDataDao {
	List<Education> findAllEducations();
	Education getEducationById(Integer id);
	
	List<Gender> findAllGenders();
	Gender getGenderById(Integer id);
	
	List<Interest> findAllInterests();
	Interest getInterestById(Integer id);
}
