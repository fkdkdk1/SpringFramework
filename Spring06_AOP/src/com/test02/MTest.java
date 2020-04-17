package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Person w = factory.getBean("woman", Person.class);
		Person m = (Person)factory.getBean("man");
		
		// 호출하는 시점 : JoinPoint
		
		System.out.println("여학생 입장");
		w.classWork();	//target
		System.out.println("-------");
		System.out.println("남학생 입장"); 
		m.classWork();	//target
		
	}
}
