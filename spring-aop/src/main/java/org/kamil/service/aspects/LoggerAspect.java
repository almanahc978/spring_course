package org.kamil.service.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.kamil.model.Book;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	@Before("org.kamil.service.aspects.AspectUtil.allBookRepositoryMethod()")
	public void logInfoBefore(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.printf("Log before %s with args: %s \n", joinPoint.getSignature(), Arrays.toString(args));
	}

	@After("org.kamil.service.aspects.AspectUtil.allBookRepositoryMethod()")
	public void logInfoAfter(JoinPoint joinPoint) {
		System.out.printf("Method %s executed \n", joinPoint.getSignature());
	}

	@AfterReturning(pointcut = "execution(* org.kamil.service.BookRepository.get(..)) && args(isbn)", returning = "result")
	public void logSuccess(JoinPoint joinPoint, String isbn, Book result) {
		if (result != null) {
			System.out.printf("Method get() successfuly returned value %s for isbn %s\n", result, isbn);
		}
	}
	
	@AfterThrowing(pointcut = "org.kamil.service.aspects.AspectUtil.allBookRepositoryMethod()",throwing = "error")
	public void logError(JoinPoint joinPoint, Throwable error) {
		System.out.printf("Method %s finished with error %s", joinPoint.getSignature(), error.getMessage());
	}
}
