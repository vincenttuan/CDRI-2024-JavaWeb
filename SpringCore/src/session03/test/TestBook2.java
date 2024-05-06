package session03.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session03.bean.LibraryManager;

public class TestBook2 {

	public static void main(String[] args) {
		// 使用 Spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("book-config.xml"); // xml 配置
		LibraryManager libraryManager = ctx.getBean("libraryManager", LibraryManager.class);
		libraryManager.displayComic();
		libraryManager.displayComputer();
	}

}
