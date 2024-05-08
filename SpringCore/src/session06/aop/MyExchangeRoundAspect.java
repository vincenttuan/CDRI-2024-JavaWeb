package session06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyExchangeRoundAspect {
	
	// 切點
	@Pointcut(value = "execution(* session06.aop.Product.getPrice(..))")
	public void pt() {};
	
	// 環繞通知
	@Around(value = "pt()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		
		// 2. 代理執行業務方法
		result = joinPoint.proceed();
		// 改變 result 的結果
		result = Double.parseDouble(result.toString()) * 30.5; // * 30.5 匯率
		
		return result;
	}
	
}
