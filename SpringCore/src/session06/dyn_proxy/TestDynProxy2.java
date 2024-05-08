package session06.dyn_proxy;

public class TestDynProxy2 {
	public static void main(String[] args) {
		// 透過代理程式來執行 CalcImpl 的方法
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		// pointCut(切點) => session06.dyn_proxy.CalcImpl.add(int x, int y)
		// pointCut(切點) => session06.dyn_proxy.CalcImpl.*(int x, int y)
		// joinPoint(連接點) => add() 方法
		// 切點對應到連接點 => 縫合
		System.out.println(calc.add(10, 20));
		
	}
}
