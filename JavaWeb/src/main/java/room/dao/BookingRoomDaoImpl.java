package room.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import room.model.po.BookingRoom;

public class BookingRoomDaoImpl implements BookingRoomDao {
	
	private JdbcTemplate jdbcTemplate = JdbcTemplateBuild.getInstance();
	
	@Override
	public BookingRoom findById(Integer bookingId) {
		String sql = "SELECT booking_id, room_id, user_id, checkin_date, create_time FROM booking_room WHERE booking_id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookingRoom.class), bookingId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<BookingRoom> findAll() {
		
		return null;
	}

	@Override
	public List<BookingRoom> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(BookingRoom bookingRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer bookingId, BookingRoom bookingRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer bookingId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
