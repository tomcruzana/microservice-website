package dev.company.employee.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dev.company.employee.repository.EmployeeRepository;
import dev.company.employee.repository.UserRoleRepository;

@Order(2)
@Aspect
@Component
public class RepositoryLoggingAdvise<T> {

	private final Logger employeeRepositoryLogger = LoggerFactory.getLogger(EmployeeRepository.class);

	private final Logger userRoleRepositoryLogger = LoggerFactory.getLogger(UserRoleRepository.class);

	// THESE ARE POINTCUT EXPRESSIONS FOR REUSE

	// REPO LAYER POINTCUTS
	@Pointcut("execution(public * dev.company.*.repository.EmployeeRepository.*(..))")
	public void pointCutTemplateEmployeeRepository() {
	}

	@Pointcut("execution(public * dev.company.*.repository.UserRoleRepository.*(..))")
	public void pointCutTemplateUserRoleRepository() {
	}

	// REPO LAYER ADVISES
	@AfterThrowing(pointcut = "pointCutTemplateEmployeeRepository()", throwing = "throwingException")
	public void afterEmployeeRepositoryMethodExceptionCall(Throwable throwingException) {
		employeeRepositoryLogger.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@AfterThrowing(pointcut = "pointCutTemplateUserRoleRepository()", throwing = "throwingException")
	public void afterUserRoleRepositoryMethodExceptionCall(Throwable throwingException) {
		userRoleRepositoryLogger.error("an exception occured when invoking a repository method -" + throwingException);
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateEmployeeRepository()")
	public T aroundRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		employeeRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		employeeRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateUserRoleRepository()")
	public T aroundUserRoleRepositoryMethodCall(ProceedingJoinPoint jp) throws Throwable {
		// get method signature of the current method
		String methodName = jp.getSignature().getName();

		// get method args size of the current method
		int argSize = jp.getArgs().length;

		userRoleRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call start.");

		T result = (T) jp.proceed();

		userRoleRepositoryLogger.info(methodName + " method with " + argSize + " arg(s) call end.");

		return (T) result;
	}

}