package session03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import session03.bean.ComicBook;
import session03.bean.ComputerBook;
import session03.bean.LibraryManager;

@Configuration
public class BookConfig {
	
	@Bean
	public ComicBook comic() {
		return new ComicBook();
	}
	
	@Bean
	public ComputerBook computer() {
		return new ComputerBook();
	}
	
	@Bean
	public LibraryManager libraryManager() {
		return new LibraryManager(comic(), computer());
	}
	
}
