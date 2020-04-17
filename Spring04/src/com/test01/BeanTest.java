package com.test01;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {
	
	private MyClass myclass;
	
	public void setDate(Date date) {
		System.out.println("setDate(Date date) ȣ�� : " + date);
	} 
	
	public void setMyclass(MyClass myclass) {
		this.myclass = myclass;
		System.out.println("setMyclass(MyClass myclass) ȣ��");
	}
	
	public BeanTest() { 
		
		System.out.println("�⺻ ������()"); 
		
	}
	
	public BeanTest(Date date) {
		
		System.out.println("�Ķ���� 1�� ������(Date date)" + date);
		
	}
	 
	public void setNumber(int i) {
		
		System.out.println("setNumber(int i) ȣ�� : " + i);
		
	}
	
	public void setArray(String[] arr) {
		System.out.println("seyArray(String[] arr) ȣ�� : ");
		for(String str : arr) {
			System.out.println(str);
		}
	}
	
	public void setList(List<String> list) {
		System.out.println("setList(List<String> list) ȣ��");
		for(String str : list) { 
			System.out.println(str);
		}
	}
	
	public void setMyset(Set<String> set) {
		System.out.println("setMyset(Set<String> set) ȣ�� : ");
		for(String str : set) {
			System.out.println(str);
		}
	}
	
	public void setMap(Map<String, String> map) {
		System.out.println("setMap(Map<String, String> map) ȣ�� : ");
		Collection<String> values = map.values();
		for(String value : values) {
			System.out.println(value);
		}
	}
	
	public void setScore(List<Score> score) {
		System.out.println("setScore(List<Score> score) ȣ�� : ");
		for(Score sc : score) {
			System.out.println(sc);
		}
	}
	
	
}