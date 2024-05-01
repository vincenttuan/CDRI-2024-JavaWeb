package room.dao;

import java.util.List;

import room.model.dto.BookingRoomCount;
import room.model.po.BookingRoom;

public interface BookingRoomDao {
	BookingRoom findById(Integer bookingId);
	List<BookingRoom> findAll();
	List<BookingRoom> findByUserId(Integer userId);
	List<BookingRoomCount> getBookingRoomCounts(); // 計算每個房間的預訂次數
	
	int create(BookingRoom bookingRoom);
	int update(Integer bookingId, BookingRoom bookingRoom);
	int delete(Integer bookingId);
}
