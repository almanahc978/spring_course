package org.kamil.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUtil {

	@Pointcut("execution(* org.kamil.service.BookRepository.*(..))")
	public void allBookRepositoryMethod() {

	}
}
