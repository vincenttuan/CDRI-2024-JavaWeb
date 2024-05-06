package session02.bean;

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
