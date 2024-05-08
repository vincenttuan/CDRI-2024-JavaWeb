package session06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//加上 VM 參數: --add-opens java.base/java.lang=ALL-UNNAMED
public class TestProductAOP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		Product product = ctx.getBean("product", Product.class);
		product.setName("iPhone20");
		product.setPrice(800.0);
		
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		
	}

}
