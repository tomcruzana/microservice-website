package dev.company.aboutus.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import dev.company.aboutus.service.AboutUsServiceImpl;

@Aspect
@Component
public class LoggingAdvise<T> {

	private final Logger serviceLogger = LoggerFactory.getLogger(AboutUsServiceImpl.class);

	// THESE ARE POINTCUT EXPRESSIONS FOR REUSE

	// SERVICE LAYER POINTCUTS
	@Pointcut("execution(public * dev.company.*.service.*.*(..))")
	public void pointCutTemplateService() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.post*(..))")
	public void pointCutTemplateServiceForPost() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.create*(..))")
	public void pointCutTemplateServiceForCreate() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.get*(..))")
	public void pointCutTemplateServiceForGet() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.read*(..))")
	public void pointCutTemplateServiceForRead() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.put*(..))")
	public void pointCutTemplateServiceForPut() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.patch*(..))")
	public void pointCutTemplateServiceForPatch() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.update*(..))")
	public void pointCutTemplateServiceForUpdate() {
	}

	@Pointcut("execution(public * dev.company.*.service.*.delete*(..))")
	public void pointCutTemplateServiceForDelete() {
	}

	// SERVICE LAYER ADVISES
	@SuppressWarnings("unchecked")
	@Around("pointCutTemplateService()")
	public T beforeServiceMethodCall(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();

		serviceLogger.info(methodName + " method call start.");

		T result = (T) jp.proceed();

		serviceLogger.info(methodName + " method call end.");

		return (T) result;
	}

}