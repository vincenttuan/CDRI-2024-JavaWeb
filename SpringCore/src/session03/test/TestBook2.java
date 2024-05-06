package session03.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session03.bean.LibraryManager;
import session03.config.BookConfig;

//使用 java 配置在執行時要加上 VM 參數: --add-opens java.base/java.lang=ALL-UNNAMED
public class TestBook2 {

	public static void main(String[] args) {
		// 使用 Spring
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("book-config.xml"); // xml 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class); // java 配置
		LibraryManager libraryManager = ctx.getBean("libraryManager", LibraryManager.class);
		libraryManager.displayComic();
		libraryManager.displayComputer();
	}

}
