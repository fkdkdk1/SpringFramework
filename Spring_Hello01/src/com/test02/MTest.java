package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Emp emp = (Emp)factory.getBean("constractor-arg");
		System.out.println(emp);
		
		emp = (Emp) factory.getBean("setter");
		System.out.println(emp);
		
	}

}
