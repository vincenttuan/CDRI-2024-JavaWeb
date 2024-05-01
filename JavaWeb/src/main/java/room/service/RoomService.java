package room.service;

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
	
	public boolean updateRoom(Integer roomId, String roomName) {
		Room room = new Room(roomId, roomName);
		return roomDao.update(roomId, room) > 0;
	}
	
}
