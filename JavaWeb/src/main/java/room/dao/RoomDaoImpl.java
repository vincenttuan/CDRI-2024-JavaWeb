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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer roomId, Room room) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer roomId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
