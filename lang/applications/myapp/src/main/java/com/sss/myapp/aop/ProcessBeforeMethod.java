package com.sss.myapp.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import org.apache.log4j.Logger;

public class ProcessBeforeMethod implements MethodBeforeAdvice {
	
	
	private static final Logger logger = Logger.getLogger(ProcessBeforeMethod.class);
	
	public void before(Method method, Object[] orgs, Object target){
		

		//System.out.println("Before method "+method.getName()+" target "+target.toString());
		logger.info("Before method: "+method.getName()+" target:"+target.toString());
	}

}
