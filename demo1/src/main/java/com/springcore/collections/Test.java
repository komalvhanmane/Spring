package com.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap =new ClassPathXmlApplicationContext("com/springcore/collections/collectionconfig.xml");
		Employee  emp=(Employee) ap.getBean("emp1");
		System.out.println(emp);
	}

}
