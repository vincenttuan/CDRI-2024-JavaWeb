package room.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import room.model.po.Room;

public class RoomDaoImpl implements RoomDao {
	
	private JdbcTemplate jdbcTemplate = JdbcTemplateBuild.getInstance();
	
	@Override
	public Room findById(Integer roomId) {
		String sql = "select room_id, room_name from room where room_id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Room.class), roomId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Room> findAll() {
		String sql = "select room_id, room_name from room";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Room.class));
	}

	@Override
	public int create(Room room) {
		String sql = "insert into room(room_id, room_name) values(?, ?)";
		return jdbcTemplate.update(sql, room.getRoomId(), room.getRoomName());
	}

	@Override
	public int update(Integer roomId, Room room) {
		String sql = "update room set room_name = ? where room_id = ?";
		return jdbcTemplate.update(sql, room.getRoomName(), roomId);
	}

	@Override
	public int delete(Integer roomId) {
		String sql = "delete from room where room_id = ?";
		return jdbcTemplate.update(sql, roomId);
	}

}
