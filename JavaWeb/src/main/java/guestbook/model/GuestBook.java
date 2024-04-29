package guestbook.model;

import java.util.Date;

import lombok.Data;

@Data
public class GuestBook {
	private Integer id;
	private String username;
	private String content;
	private Date createDate;
	private Date updateDate;
}
