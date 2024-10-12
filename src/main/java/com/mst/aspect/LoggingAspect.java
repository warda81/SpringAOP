package com.mst.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	//advise
	private void accountMethods() {
		System.out.println("*************************");
	}
	
	@Before("execution( * com.mst.beans.Account.deposit(..))")
	private void logBefore(JoinPoint joinPoint) {
		System.out.println("!!!!!!!!!!!!!!!!!!!");
		System.out.println("This will run before deposit");
		System.out.println("!!!!!!!!!!!!!!!!!!!");
	}
	
	@After("execution( * com.mst.beans.Account.*(..))")
	private void logAfter(JoinPoint joinPoint) {
		System.out.println("########################");
		System.out.println("This will run after deposit");
		System.out.println("########################");
	}
	
	@AfterReturning(pointcut = "execution( * com.mst.beans.Account.getAccNumber(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("----------------------------");
		System.out.println("logAfterReturning() is running!");
		System.out.println("the: "+joinPoint.getSignature().getName());
		System.out.println("Method returned value is: "+ result);
		System.out.println("----------------------------");
	}
	
	@AfterThrowing(pointcut = "execution( * com.mst.beans.Account.deposit(..))", throwing = "error")
	public void logAfterThrowException(JoinPoint joinPoint, Throwable error) {
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("logAfterThrowException() is running!");
		System.out.println("the: "+joinPoint.getSignature().getName());
		System.out.println("The Exception is: "+ error);
		System.out.println("+++++++++++++++++++++++++++++");
	}
	
	@Around("execution( * com.mst.beans.Account.withdraw(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("logAround() is running!");
		System.out.println("Around before is running");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
	}
}
