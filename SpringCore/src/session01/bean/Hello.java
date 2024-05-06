package session01.bean;

import java.util.Date;

public class Hello {
	private Date today;
	
	public Hello() {
		System.out.println("Hello 建構子");
		today = new Date();
	}
	
	public Date getToday() {
		return today;
	}
}
