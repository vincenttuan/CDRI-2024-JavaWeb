package session02.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session02.bean.BeverageMachine;

// 使用 java	配置在執行時要加上 VM 參數: --add-opens java.base/java.lang=ALL-UNNAMED
public class TestBeverage {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(BeverageConfig.class);
		BeverageMachine machine1 = ctx.getBean("coffeeBeverageMachine", BeverageMachine.class);
		System.out.println(machine1.serveBeverage());
		BeverageMachine machine2 = ctx.getBean("teaBeverageMachine", BeverageMachine.class);
		System.out.println(machine2.serveBeverage());
	}

}
