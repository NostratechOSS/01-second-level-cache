package com.nostratech.academy.slc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LoggingAspect {
	
	@Pointcut("execution(* com.nostratech.academy.slc.web.*.*(..))")
	private void restAPI() {}

	@Around("restAPI()")
	public Object processingTimeLogging(ProceedingJoinPoint jointPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();

		try {
			log.info("********** start {}.{} **********", jointPoint.getTarget().getClass().getName(),
					jointPoint.getSignature().getName());
			stopWatch.start();
			return jointPoint.proceed();
		} finally {
			stopWatch.stop();
			log.info("********** finish {}.{}  execution time = {} **********",
					jointPoint.getTarget().getClass().getName(), jointPoint.getSignature().getName(),
					stopWatch.getTotalTimeMillis());
		}

	}
}
