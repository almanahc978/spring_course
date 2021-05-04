package org.kamil.service.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLoggerAspect {

	@Around("org.kamil.service.aspects.AspectUtil.allBookRepositoryMethod()")
	public Object measurExecTime(ProceedingJoinPoint pjp) throws Throwable {
		Instant before = Instant.now();
		// @Before
		try {
			Object result = pjp.proceed();
			// @After
			return result;
			/*
			 * } catch(Throwable e){
			 * 
			 * @AfterThrowing, gdyby nie bylo Throws }
			 */
		} finally {
			// @AfterReturning
			Instant after = Instant.now();
			Duration execTime = Duration.between(before, after);
			System.out.printf("%s execution took %d ms/n", pjp.toShortString(), execTime.toMillis());
		}
	}
}
