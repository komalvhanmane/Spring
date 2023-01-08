package com.springcore1.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Student s=(Student) context.getBean("student1");
        Student s1=(Student) context.getBean("student2");
        System.out.println(s);
        System.out.println(s1);
        System.out.println();
    }
}
