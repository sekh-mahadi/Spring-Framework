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

	// create pointcut for getter methods
	@Pointcut("execution (* io.mtech.aop.dao.*.get*(..))")
	private void getter() {

	}

	// create pointcut for setter methods
	@Pointcut("execution( * io.mtech.aop.dao.*.set*(..))")
	private void setter() {

	}

	// Combine pointcut: include package....exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {

	}

	// this is where we add all our related advices for logging

	// @Before("forDaoPackage()") // specific package, any // method any class
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n========Executing @Before advice on addAccount()");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalylics() {
		System.out.println("\n===========>> Performing API Analytics.");
	}
}
