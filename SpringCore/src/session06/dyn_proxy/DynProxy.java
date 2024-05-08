package session06.dyn_proxy;

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
		
		return proxyObj;
	}
	
}
