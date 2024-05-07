package session05.test;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import session05.bean.GuestBook;
import session05.service.GuestBookService;

@Component
public class GuestBookApp {
	
	@Autowired
	@Qualifier("gbService")
	private GuestBookService guestBookService;
	
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void menu() {
		System.out.println("-----------------");
		System.out.println("1. 新增留言");
		System.out.println("2. 修改留言");
		System.out.println("3. 刪除留言");
		System.out.println("4. 查詢留言");
		System.out.println("9. 離開系統");
		System.out.println("-----------------");
		System.out.print("請選擇 => ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				addContent();
				break;
			case 2:
				uptContent();
				break;
			case 3:
				delContent();
				break;
			case 4:
				findContent();
				break;
			case 9:
				System.exit(1);
			default:
				System.out.println("輸入錯誤請重新輸入");
				menu();
		}
	}
	
	public void addContent() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入留言內容: ");
		String content = scanner.next();
		guestBookService.add(username, content);
	}
	
	public void uptContent() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入要修改的留言 id: ");
		int id = scanner.nextInt();
		System.out.print("請輸入要修改的留言內容: ");
		String content = scanner.next();
		guestBookService.updateContent(id, content);
	}
	
	public void delContent() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入要刪除的留言 id: ");
		int id = scanner.nextInt();
		guestBookService.removeById(id);
	}
	
	public void findContent() {
		guestBookService.queryAll().forEach(gb -> {
			System.out.printf("%d %s %s %s %s %n", 
					gb.getId(), gb.getUsername(), gb.getContent(), gb.getCreateDate(), gb.getUpdateDate());
		});
	}
	
}
