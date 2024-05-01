package room.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import room.dao.BookingRoomDao;
import room.dao.BookingRoomDaoImpl;
import room.model.po.BookingRoom;

public class BookingRoomService {
	private BookingRoomDao bookingRoomDao = new BookingRoomDaoImpl();
	
	public boolean addBookingRoom(Integer bookingId, Integer roomId, Integer userId, String checkinDateString) {
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
		
		return bookingRoomDao.create(bookingRoom) > 0;
	}
}
