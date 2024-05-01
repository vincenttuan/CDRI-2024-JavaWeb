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
		String sql = "SELECT booking_id, room_id, user_id, checkin_date, create_time FROM booking_room";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingRoom.class));
	}

	@Override
	public List<BookingRoom> findByUserId(Integer userId) {
		String sql = "SELECT booking_id, room_id, user_id, checkin_date, create_time FROM booking_room WHERE user_id = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingRoom.class), userId);
	}

	@Override
	public int create(BookingRoom bookingRoom) {
		String sql = "INSERT INTO booking_room (room_id, user_id, checkin_date) VALUES (?, ?, ?)";
		return jdbcTemplate.update(sql, bookingRoom.getRoomId(), bookingRoom.getUserId(), bookingRoom.getCheckinDate());
	}

	@Override
	public int update(Integer bookingId, BookingRoom bookingRoom) {
		String sql = "UPDATE booking_room SET room_id = ?, user_id = ?, checkin_date = ? WHERE booking_id = ?";
		return jdbcTemplate.update(sql, bookingRoom.getRoomId(), bookingRoom.getUserId(), bookingRoom.getCheckinDate(), bookingId);
	}

	@Override
	public int delete(Integer bookingId) {
		String sql = "DELETE FROM booking_room WHERE booking_id = ?";
		return jdbcTemplate.update(sql, bookingId);
	}

}
