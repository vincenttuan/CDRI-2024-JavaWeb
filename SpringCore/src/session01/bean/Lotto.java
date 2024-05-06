package session01.bean;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Lotto {
	private Set<Integer> numbers;
	
	public Lotto() {
		System.out.println("Lotto 建構子");
		// 自動產生 1~39 不重複的號碼 5 個 (今彩 539)
		Random random = new Random();
		numbers = new LinkedHashSet<>();
		while (numbers.size() < 5) {
			int number = random.nextInt(39) + 1;
			numbers.add(number); // 自動去除重複
		}
	}
	
	public Set<Integer> getNumbers() {
		return numbers;
	} 
	
}
