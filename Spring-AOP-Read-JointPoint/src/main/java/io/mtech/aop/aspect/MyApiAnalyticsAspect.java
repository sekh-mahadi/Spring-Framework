package io.mtech.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {

	@Before("io.mtech.aop.aspect.MtechAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalylics() {
		System.out.println("\n===========>> Performing API Analytics.");
	}
}
