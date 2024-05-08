package session06.proxy;

public class PersonProxy implements Person {
	// 代理對象
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	
	@Override
	public void work() {
		// 公用邏輯
		System.out.println("出門戴口罩");
		// 執行代理對象的業務方法
		person.work();
		// 公用邏輯
		System.out.println("回家要洗手");
	}
}
