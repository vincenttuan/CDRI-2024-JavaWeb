package room.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import room.dao.BookingRoomDao;
import room.dao.BookingRoomDaoImpl;
import room.model.dto.BookingRoomCount;
import room.model.po.BookingRoom;

public class BookingRoomService {
	private BookingRoomDao bookingRoomDao = new BookingRoomDaoImpl();
	
	public boolean addBookingRoom(Integer roomId, Integer userId, String checkinDateString) {
		BookingRoom bookingRoom = new BookingRoom();
		bookingRoom.setRoomId(roomId);
		bookingRoom.setUserId(userId);
		
		// String to Date
		// checkinDateString 轉 checkinDate
		Date checkinDate = null;
		try {
			checkinDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkinDateString);
			bookingRoom.setCheckinDate(checkinDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return bookingRoomDao.create(bookingRoom) > 0;
	}
	
	public BookingRoom getBookingRoom(Integer bookingId) {
		return bookingRoomDao.findById(bookingId);
	}
	
	public List<BookingRoom> findAllBookingRooms() {
		return bookingRoomDao.findAll();
	}
	
	public List<BookingRoom> findBookingRoomsByUserId(Integer userId) {
		return bookingRoomDao.findByUserId(userId);
	}
	
	public boolean updateBookingRoom(Integer bookingId, Integer roomId, Integer userId, String checkinDateString) {
		BookingRoom bookingRoom = new BookingRoom();
		bookingRoom.setBookingId(bookingId);
		bookingRoom.setRoomId(roomId);
		bookingRoom.setUserId(userId);

		// String to Date
		// checkinDateString 轉 checkinDate
		Date checkinDate = null;
		try {
			checkinDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkinDateString);
			bookingRoom.setCheckinDate(checkinDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return bookingRoomDao.update(bookingId, bookingRoom) > 0;
	}
	
	public boolean deleteBookingRoom(Integer bookingId) {
		return bookingRoomDao.delete(bookingId) > 0;
	}
	
	public List<BookingRoomCount> getBookingRoomCounts() {
		return bookingRoomDao.getBookingRoomCounts();
	}
}
