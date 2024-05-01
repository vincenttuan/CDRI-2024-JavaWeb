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
	
}
