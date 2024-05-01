package room.model.dto;

import lombok.Data;

@Data
public class BookingRoomCount {
	private Integer roomId;
	private String roomName;
	private Integer bookingCount;
}
