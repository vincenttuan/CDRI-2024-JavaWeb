package session06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggerRoundAspect {
	
	// 切點
	@Pointcut(value = "execution(* session06.aop.ComputerImpl.div(..))")
	public void pt() {};
	
	// 環繞通知
	@Around(value = "pt()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
		Object result = null;
		
		try {
			// 1. 前置通知
			System.out.printf("環繞通知-前置通知: %s%n", joinPoint.getSignature().getName());
			
			// 2. 代理執行業務方法
			result = joinPoint.proceed();
			
			// 3. 返回通知
			System.out.printf("環繞通知-返回通知: %s result=%s%n", joinPoint.getSignature().getName(), result);
			
		} catch (Throwable e) {
			// 4. 例外通知
			System.out.printf("環繞通知-例外通知: %s e=%s%n", joinPoint.getSignature().getName(), e);
			
		} finally {
			// 5. 後置通知
			System.out.printf("環繞通知-後置通知: %s%n", joinPoint.getSignature().getName());
		}
		
		return result;
	}
	
}
