package session06.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 可被 Spring 直接管理的物件
@Aspect // 告訴 Spring 此為切面程式
//@Order(1) // 執行順序(數字越小越先執行)
public class MyLoggerAspect {
	// 切點的方法
	@Pointcut(value = "execution(* session06.aop.ComputerImpl.*(..))")
	public void pt1() {}
	
	//@Before(value = "execution(public Integer session06.aop.ComputerImpl.add(Integer, Integer))")
	//@Before(value = "execution(* session06.aop.ComputerImpl.add(..))")
	//@Before(value = "execution(* session06.aop.ComputerImpl.*(..))")
	@Before(value = "pt1()")
	public void beforeAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 取得方法名稱
		Object[] args = joinPoint.getArgs();
		System.out.printf("前置通知: 寫入 Log %s %s%n", methodName, Arrays.toString(args));
	}
	
}
