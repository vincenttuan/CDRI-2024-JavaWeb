package guestbook.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuestBook {
	private Integer id;
	private String username;
	private String content;
	private Date createDate;
	private Date updateDate;
	
	public GuestBook(String username, String content) {
		this.username = username;
		this.content = content;
	}
}
