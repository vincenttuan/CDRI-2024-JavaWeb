package session02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import session02.bean.Beverage;
import session02.bean.BeverageMachine;
import session02.bean.Coffee;
import session02.bean.Tea;

// 飲料配置
@Configuration
public class BeverageConfig {
	
	//@Bean(name = "coffee")
	@Bean
	public Beverage coffee() {
		return new Coffee();
	}
	
	@Bean
	public Beverage tea() {
		return new Tea();
	}
	
	@Bean
	public BeverageMachine coffeeBeverageMachine() {
		BeverageMachine machine = new BeverageMachine(coffee());
		return machine;
	}
	
	@Bean
	public BeverageMachine teaBeverageMachine() {
		BeverageMachine machine = new BeverageMachine(tea());
		return machine;
	}
	
}




