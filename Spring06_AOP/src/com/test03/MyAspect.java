package com.test03;

import org.aspectj.lang.JoinPoint;

//Aspect : Advice 와 pointCut을 합친 것

public class MyAspect {
	
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass()); 
		System.out.println(join.getSignature().getName());
		System.out.println("출석카드를 찍는다.");  
	}
	 
	public void after(JoinPoint join) { 
		 
		System.out.println("집에 간다"); 
		
	}
	

}
 