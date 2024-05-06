package session04.bean;

import org.springframework.stereotype.Component;

@Component("coke")
public class Coke implements FoodItem {

	@Override
	public String serve() {
		return "可樂";
	}

}
