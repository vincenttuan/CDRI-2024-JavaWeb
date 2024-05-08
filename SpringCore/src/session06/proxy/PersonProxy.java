package session06.proxy;

public class PersonProxy implements Person {
	// 代理對象
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	
	@Override
	public void work() {
		// before:公用邏輯
		System.out.println("出門戴口罩");
		// 執行代理對象的業務方法
		try {
			person.work();
		} catch(Exception e) {
			// exception:公用邏輯
			System.out.println("發生錯誤, 處理方式是將錯誤 log 記錄下來");
		}
		// end:公用邏輯
		System.out.println("回家要洗手");
	}
}
