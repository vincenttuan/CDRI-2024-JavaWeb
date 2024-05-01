package room.dao;

import java.util.List;

import room.model.po.Room;

public interface RoomDao {
	Room findById(Integer roomId);
	List<Room> findAll();
	int create(Room room);
	int update(Integer roomId, Room room);
	int delete(Integer roomId);
}
