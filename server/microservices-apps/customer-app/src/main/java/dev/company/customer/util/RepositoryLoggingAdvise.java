package dev.company.customer.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dev.company.customer.repository.CartItemRepository;
import dev.company.customer.repository.CartRepository;
import dev.company.customer.repository.RegisteredCustomerRepository;

@Order(1)
@Aspect
@Component
public class RepositoryLoggingAdvise<T> {

	private final Logger registeredCustomerRepositoryLogger = LoggerFactory
			.getLogger(RegisteredCustomerRepository.class);

	private final Logger cartRepositoryLogger = LoggerFactory.getLogger(CartRepository.class);

	private final Logger cartItemRepositoryLogger = LoggerFactory.getLogger(CartItemRepository.class);

	// THESE ARE POINTCUT EXPRESSIONS FOR REUSE

	// REPO LAYER POINTCUTS
	@Pointcut("execution(public * dev.company.*.repository.RegisteredCustomerRepository.*(..))")
	public void pointCutTemplateRegisteredCustomerRepository() {
	}

	@Pointcut("execution(public * dev.company.*.repository.CartRepository.*(..))")
	public void pointCutTemplateCartRepository() {
	}

	@Pointcut("execution(public * dev.company.*.repository.CartItemRepository.*(..))")
	public void pointCutTemplateCartItemRepository() {
	}

	// REPO LAYER ADVISES
	@AfterThrowing(pointcut = "pointCutTemplateRegisteredCustomerRepository()", throwing = "throwingException")
	public void afterRegisteredCustomerRepositoryMethodExceptionCall(Throwable throwingException) {

		registeredCustomerRepositoryLogger
				.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@AfterThrowing(pointcut = "pointCutTemplateCartRepository()", throwing = "throwingException")
	public void afterCartRepositoryMethodExceptionCall(Throwable throwingException) {

		cartRepositoryLogger.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@AfterThrowing(pointcut = "pointCutTemplateCartItemRepository()", throwing = "throwingException")
	public void afterCartItemRepositoryMethodExceptionCall(Throwable throwingException) {

		cartItemRepositoryLogger.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateRegisteredCustomerRepository()")
	public T aroundRegisteredCustomerRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		registeredCustomerRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		registeredCustomerRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateCartRepository()")
	public T aroundCartRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		cartRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		cartRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateCartItemRepository()")
	public T aroundCartItemRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		cartItemRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		cartItemRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

}