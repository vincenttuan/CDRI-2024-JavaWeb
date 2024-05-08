package session06.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	
	@Pointcut(value = "execution(* session06.aop.ComputerImpl.div(..))")
	public void pt2() {}
	
	@Pointcut(value = "execution(* session06.aop.*.*(..))")
	public void pt3() {}
	
	@Pointcut(value = "execution(* *(..))")
	public void pt4() {}
	
	//@Before(value = "execution(public Integer session06.aop.ComputerImpl.add(Integer, Integer))")
	//@Before(value = "execution(* session06.aop.ComputerImpl.add(..))")
	//@Before(value = "execution(* session06.aop.ComputerImpl.*(..))")
	//@Before(value = "pt1()")
	//@Before(value = "pt2()")
	@Before(value = "pt1() && !pt2()") // &&, ||, !
	public void beforeAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 取得方法名稱
		Object[] args = joinPoint.getArgs();
		System.out.printf("前置通知: 寫入 Log %s %s%n", methodName, Arrays.toString(args));
	}
	
	@After(value = "pt2()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.printf("後置通知: %s %n", joinPoint.getSignature().getName());
	}
	
}
