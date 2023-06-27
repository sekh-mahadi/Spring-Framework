package io.mtech.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class DemoLoggingAspect {
	// this is where we add all our related advices for logging

	@Before("io.mtech.aop.aspect.MtechAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n========Executing @Before advice on addAccount()");
	}

}
