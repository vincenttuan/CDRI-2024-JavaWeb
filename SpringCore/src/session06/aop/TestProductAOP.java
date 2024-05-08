package session06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//加上 VM 參數: --add-opens java.base/java.lang=ALL-UNNAMED
public class TestProductAOP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		
		
	}

}
