package session01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session01.bean.Hello;
import session01.bean.Lotto;
import session01.config.SpringJavaConfig;
import session01.config.SpringJavaConfig2;

//執行時請加入 VM 參數: --add-opens java.base/java.lang=ALL-UNNAMED
//整體來說，這行命令的意思是："在運行時，允許所有未命名的模組訪問 java.base 模組中的 java.lang 包"。
//這是為了解決一些框架，如 Spring，在需要訪問這些封裝的API時遇到的反射問題。
public class TestHelloAndLotto {
	public static void main(String[] args) {
		
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfig.class);
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfig2.class);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config2.xml");
		Hello hello = ctx.getBean("hello", Hello.class);
		System.out.println(hello.getToday());
		Lotto lotto1 = ctx.getBean("lotto", Lotto.class);
		Lotto lotto2 = ctx.getBean("lotto", Lotto.class);
		System.out.println(lotto1.getNumbers());
		System.out.println(lotto2.getNumbers());
		
	}
}
