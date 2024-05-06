package session02.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class BeverageMachine {
	private Beverage beverage;
	
	public BeverageMachine() {
		
	}
	
	// 建構子注入
	public BeverageMachine(Beverage beverage) {
		this.beverage = beverage;
	}

	public String serveBeverage() {
		return beverage.serve();
	}
	
	// 方法注入
	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}
	
	
}
