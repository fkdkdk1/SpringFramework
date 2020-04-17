package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect {
	
	public void before(JoinPoint join) {
		System.out.println("출석카드를 찍는다.");
	}
	
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
}
