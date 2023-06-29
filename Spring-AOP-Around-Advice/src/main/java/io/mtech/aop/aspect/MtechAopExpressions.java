package io.mtech.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MtechAopExpressions {

	@Pointcut("execution(* io.mtech.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create pointcut for getter methods
	@Pointcut("execution (* io.mtech.aop.dao.*.get*(..))")
	public void getter() {

	}

	// create pointcut for setter methods
	@Pointcut("execution( * io.mtech.aop.dao.*.set*(..))")
	public void setter() {

	}

	// Combine pointcut: include package....exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {

	}
}
