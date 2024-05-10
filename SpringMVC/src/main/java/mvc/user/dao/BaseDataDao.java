package mvc.user.dao;

import java.util.List;

import mvc.user.model.po.Education;
import mvc.user.model.po.Gender;
import mvc.user.model.po.Interest;

public interface BaseDataDao {
	List<Education> findAllEducations(); // 查詢所有教育程度
	Education getEducationById(Integer id); // 查詢教育程度
	
	List<Gender> findAllGenders(); // 查詢所有性別
	Gender getGenderById(Integer id); // 查詢性別
	
	List<Interest> findAllInterests(); // 查詢所有興趣
	Interest getInterestById(Integer id); // 查詢興趣
	int addInterest(Integer userId, Integer interestId); // 新增興趣
	int deleteInterestsByUserId(Integer userId); // 刪除指定使用者的興趣
}
