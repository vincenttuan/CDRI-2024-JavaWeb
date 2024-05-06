package session01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session01.bean.Hello;

public class TestHello {

	public static void main(String[] args) {
		// 傳統: 自行管理物件, 自行 new
		Hello hello1 = new Hello();
		System.out.println(hello1.getToday());
		
		// Spring: 利用 IoC 技術來建立物件
		// 配置文件: conf/beans-config.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		
		
	}

}
