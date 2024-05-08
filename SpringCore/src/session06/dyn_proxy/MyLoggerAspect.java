package session06.dyn_proxy;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class MyLoggerAspect {
	
	public static void before(Object[] args) {
		System.out.println("寫入 log 程序 ...");
		String path = "src/session06/dyn_proxy/log.txt";
		String content = Arrays.toString(args);
		try {
			Files.write( // 寫入
					Paths.get(path), // 存檔路徑 
					content.getBytes(StandardCharsets.UTF_8), // 轉 byte[] 
					StandardOpenOption.CREATE, // 若 log.txt 不存在就自動建立檔案
					StandardOpenOption.APPEND); // 在 log.txt 文件末端添加資料
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
