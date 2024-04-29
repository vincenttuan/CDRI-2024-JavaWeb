package guestbook.dao;

import java.util.List;

import guestbook.model.GuestBook;

public interface GuestBookDao {
	
	int create(GuestBook guestBook); // 新增
	GuestBook findById(Integer id); // 單筆查詢
	List<GuestBook> findAll(); // 多筆查詢
	int update(GuestBook guestBook); // 修改
	int deleteById(Integer id); // 刪除
	
}
