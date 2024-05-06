package session03.bean;

import java.util.List;

public class LibraryManager {
	
	private Book comicBook;
	private Book computerBook;
	
	public LibraryManager(Book comicBook, Book computerBook) {
		this.comicBook = comicBook;
		this.computerBook = computerBook;
	}
	
	public void displayComic() {
		comicBook.display();
	}
	
	public void displayComputer() {
		computerBook.display();
	}
	
}
