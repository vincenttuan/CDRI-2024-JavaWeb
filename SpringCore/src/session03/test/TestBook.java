package session03.test;

import session03.bean.Book;
import session03.bean.ComicBook;
import session03.bean.ComputerBook;
import session03.bean.LibraryManager;

public class TestBook {

	public static void main(String[] args) {
		// 傳統方式
		Book comicBook = new ComicBook();
		Book computerBook = new ComputerBook();
		LibraryManager libraryManager = new LibraryManager(comicBook, computerBook);
		libraryManager.displayComic();
		libraryManager.displayComputer();

	}

}
