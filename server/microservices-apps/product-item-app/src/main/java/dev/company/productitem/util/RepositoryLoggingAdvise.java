package dev.company.productitem.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dev.company.productitem.repository.ProductCategoryRepository;
import dev.company.productitem.repository.ProductItemRepository;

@Order(1)
@Aspect
@Component
public class RepositoryLoggingAdvise<T> {

	private final Logger productCategoryRepositoryLogger = LoggerFactory.getLogger(ProductCategoryRepository.class);

	private final Logger productItemRepositoryLogger = LoggerFactory.getLogger(ProductItemRepository.class);

	// THESE ARE POINTCUT EXPRESSIONS FOR REUSE

	// REPO LAYER POINTCUTS
	@Pointcut("execution(public * dev.company.*.repository.ProductCategoryRepository.*(..))")
	public void pointCutTemplateProductCategoryRepository() {
	}

	@Pointcut("execution(public * dev.company.*.repository.ProductItemRepository.*(..))")
	public void pointCutTemplateProductItemRepository() {
	}

	// REPO LAYER ADVISES
	@AfterThrowing(pointcut = "pointCutTemplateProductCategoryRepository()", throwing = "throwingException")
	public void afterProductCategoryRepositoryMethodExceptionCall(Throwable throwingException) {
		productCategoryRepositoryLogger
				.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@AfterThrowing(pointcut = "pointCutTemplateProductItemRepository()", throwing = "throwingException")
	public void afterProductItemRepositoryMethodExceptionCall(Throwable throwingException) {
		productItemRepositoryLogger
				.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateProductCategoryRepository()")
	public T aroundPointCutProductCategoryRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		productCategoryRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		productCategoryRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateProductItemRepository()")
	public T aroundPointCutProductItemRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		productItemRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		productItemRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

}