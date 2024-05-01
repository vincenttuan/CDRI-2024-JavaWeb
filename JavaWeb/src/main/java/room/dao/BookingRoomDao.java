package room.dao;

import java.util.List;

import room.model.po.BookingRoom;

public interface BookingRoomDao {
	BookingRoom findById(Integer bookingId);
	List<BookingRoom> findAll();
	List<BookingRoom> findByUserId(Integer userId);
	int create(BookingRoom bookingRoom);
	int update(Integer bookingId, BookingRoom bookingRoom);
	int delete(Integer bookingId);
}
