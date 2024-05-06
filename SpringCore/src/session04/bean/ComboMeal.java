package session04.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("comboMeal")
@Component
public class ComboMeal {
	private FoodItem burger;
	private FoodItem fries;
	private FoodItem coke;
	
	@Autowired
	public ComboMeal(@Qualifier("burger") FoodItem burger, 
					 @Qualifier("fries") FoodItem fries, 
					 @Qualifier("coke") FoodItem coke) {
		this.burger = burger;
		this.fries = fries;
		this.coke = coke;
	}
	
	public String serveMeal() {
		return burger.serve() + " " + fries.serve() + " " + coke.serve();
	}
	
	
}
