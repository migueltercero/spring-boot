package es.jccm.curso.spring.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class LogAspect {
	
	@Before("execution(* es.jccm.curso.spring.boot.view.*.*(..))")
	public void before(JoinPoint joinPoint){
		//Advice
		log.info("antes de invocar");
	}
	
	@After("execution(* es.jccm.curso.spring.boot.view.*.*(..))")
	public void after(JoinPoint joinPoint){
		//Advice
		log.info("despues de invocar");
	}
}