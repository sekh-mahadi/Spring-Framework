package io.mtech.springmvc.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// setup Logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// Setup pointcut Declarations
	@Pointcut("execution(* io.mtech.springmvc.controller.*.*(..))")
	private void forControllerPackage() {

	}

	// do the same for service and dao
	@Pointcut("execution(* io.mtech.springmvc.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* io.mtech.springmvc.dao.*.*(..))")
	private void forDaoPackage() {

	}
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {

	}

	// Add @Before
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("=========> in @Before: calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop thru and display args

		for (Object tempArg : args) {
			logger.info("====>> Argument: " + tempArg);
		}

	}
	// add @afterReturing advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturing(JoinPoint theJoinPoint, Object theResult) {
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("=========> in @Before: calling method: " + theMethod);
		// display data returned

		logger.info("======>>> Result: " + theResult);

	}
}
