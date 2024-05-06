package session02.bean;

import org.springframework.stereotype.Component;

public class Tea implements Beverage {

	@Override
	public String serve() {
		return "一壺熱茶";
	}
	
}
