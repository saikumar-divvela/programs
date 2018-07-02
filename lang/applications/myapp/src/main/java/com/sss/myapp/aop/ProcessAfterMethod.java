package com.sss.myapp.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class ProcessAfterMethod implements  AfterReturningAdvice{
	
	private static final Logger logger = Logger.getLogger(ProcessAfterMethod.class);

public void afterReturning(Object x,Method method, Object[] orgs, Object target){
		
		//System.out.println("After method "+method.getName()+" target "+target.toString());
		logger.info("After method: "+method.getName()+" target:"+target.toString());
	}
}
