package io.mtech.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	// this is where we add all our related advices for logging

	// lets start with an @Before advice
//	@Before("execution(public void io.mtech.aop.dao.AccountDAO.addAccount())")
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n========Executing @Before advice on addAccount()");
	}
}
