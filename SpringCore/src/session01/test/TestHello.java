package session01.test;

import session01.bean.Hello;

public class TestHello {

	public static void main(String[] args) {
		// 傳統: 自行管理物件, 自行 new
		Hello hello1 = new Hello();
		System.out.println(hello1.getToday());

	}

}
