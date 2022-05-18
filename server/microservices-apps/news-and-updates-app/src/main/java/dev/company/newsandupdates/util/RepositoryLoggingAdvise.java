package dev.company.newsandupdates.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dev.company.newsandupdates.entity.NewsAndUpdates;

@Order(1)
@Aspect
@Component
public class RepositoryLoggingAdvise<T> {

	private final Logger newsAndUpdatesRepositoryLogger = LoggerFactory.getLogger(NewsAndUpdates.class);

	// THESE ARE POINTCUT EXPRESSIONS FOR REUSE

	// REPO LAYER POINTCUTS
	@Pointcut("execution(public * dev.company.*.repository.NewsAndUpdatesRepository.*(..))")
	public void pointCutTemplateNewsAndUpdatesRepository() {
	}

	// REPO LAYER ADVISES
	@AfterThrowing(pointcut = "pointCutTemplateNewsAndUpdatesRepository()", throwing = "throwingException")
	public void afterNewsAndUpdatesRepositoryMethodExceptionCall(Throwable throwingException) {
		newsAndUpdatesRepositoryLogger
				.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateNewsAndUpdatesRepository()")
	public T aroundRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		newsAndUpdatesRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		newsAndUpdatesRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

}