package session04.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import session04.bean.ComboMeal;
import session04.config.FoodConfig;

public class FoodTest {
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("food-config.xml"); // xml 配置 auto-scan
		ApplicationContext ctx = new AnnotationConfigApplicationContext(FoodConfig.class); // java 配置 auto-scan
		ComboMeal comboMeal = ctx.getBean("comboMeal", ComboMeal.class);
		System.out.println(comboMeal.serveMeal());
		
	}
}
