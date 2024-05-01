package room.model.po;

import java.util.Date;

import lombok.Data;

@Data
public class BookingRoom {
	private Integer bookingId;
	private Integer roomId;
	private Integer userId;
	private Date checkinDate;
	private Date createTime;
	
}
