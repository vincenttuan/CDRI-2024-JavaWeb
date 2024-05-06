package session04.bean;

import org.springframework.stereotype.Component;

@Component("buger")
public class Burger implements FoodItem {

	@Override
	public String serve() {
		return "麥香魚";
	}

}
