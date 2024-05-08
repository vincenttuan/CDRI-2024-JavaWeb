package session06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		Computer computer = ctx.getBean("computerImpl", ComputerImpl.class);
		System.out.println(computer.add(20, 10));
		System.out.println(computer.sub(30, 10));
		System.out.println(computer.mul(50, 10));
		System.out.println(computer.div(60, 10));
		
	}

}
