/**
 * 
 */
package com.javatpoint.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author asingha6
 *
 */
@Component
@Aspect
public class LoggingAspect {
	@Before("allCircleMethods()")
	public void LoggingAdvice(){
		System.out.println("Advice Run,Get method called");
	}
	@AfterReturning("args(name)")
	public void LoggingAdviceOne(String name){
		System.out.println("A method that takes String argument has been called. The value is "+name);
	}
	
	@AfterThrowing("args(name)")
	public void LoggingAdviceTwo(String name){
		System.out.println("A Exception has been thrown "+name);
	}
	
	@Around("allGetters()")
	public void AroundAdvice(ProceedingJoinPoint pjp){
		Object returnValue=null;
		try {
			System.out.println("Before Method");
			returnValue=pjp.proceed();
			System.out.println("After Method");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
			e.printStackTrace();
		}
		System.out.println("Finally");
		
	}
	
	@Pointcut("execution( (*) get*())")
	public void allGetters(){
		
	}
	@Pointcut("within(com.javatpoint.model.*)")
	public void allCircleMethods(){
		
	}
//	@Pointcut("execution(* * com.javatpoint.model.Triangle.*(..))")
//	public void allTraingleMethods(){
//		
//	}
}
