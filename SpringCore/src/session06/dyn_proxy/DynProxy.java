package session06.dyn_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

// 動態代理
public class DynProxy {
	
	// 被代理的對象
	private Object object;
	
	public DynProxy(Object object) {
		this.object = object;
	}
	
	// 取得 Proxy 物件
	public Object getProxy() {
		Object proxyObj = null;
		
		// 1. 載入類別器
		ClassLoader loader = object.getClass().getClassLoader();
		
		// 2. 被代理的物件所實作的介面
		Class<?>[] interfaces = object.getClass().getInterfaces();
		
		// 3. 處理代理的實現
		InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
			Object result = null; // 被代理物件的業務方法的回傳值 
			
			// before -------------------------------------------
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
			
			// 調用業務方法
			result = method.invoke(object, args); 
			
			return result;
		};
		
		// 4. 得到代理物件
		proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
	
}
