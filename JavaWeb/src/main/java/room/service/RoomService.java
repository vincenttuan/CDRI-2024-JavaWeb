package room.service;

import java.util.List;

import room.dao.RoomDao;
import room.dao.RoomDaoImpl;
import room.model.po.Room;

public class RoomService {
	private RoomDao roomDao = new RoomDaoImpl();
	
	public boolean addRoom(Integer roomId, String roomName) {
		Room room = new Room(roomId, roomName);
		return roomDao.create(room) > 0;
	}
	
	public Room getRoom(Integer roomId) {
		return roomDao.findById(roomId);
	}
	
	public List<Room> getRooms() {
		return roomDao.findAll();
	}
	
	public boolean updateRoom(Integer roomId, String roomName) {
		Room room = new Room(roomId, roomName);
		return roomDao.update(roomId, room) > 0;
	}
	
	public boolean deleteRoom(Integer roomId) {
		return roomDao.delete(roomId) > 0;
	}
	
}
