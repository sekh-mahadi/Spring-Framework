package io.mtech.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	@Pointcut("execution(* io.mtech.aop.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// this is where we add all our related advices for logging

	@Before("forDaoPackage()") // specific package, any // method any class 
	public void beforeAddAccountAdvice() {
		System.out.println("\n========Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()") 
	public void performApiAnalylics() {
		System.out.println("\n===========>> Performing API Analytics.");
	}
}
