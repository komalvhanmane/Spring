package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.*;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program started............" );
        //jdbc template
//        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(jdbcConfig.class);
        //as we are using annotation based configuration
        StudentDaoImpl studentdao = context.getBean("studentDao",StudentDaoImpl.class);
        //Insert
        Student s=new Student();
        s.setId(1344);
        s.setName("John John");
        s.setCity("Delhi");
        
        int result = studentdao.insert(s);
        System.out.println("Student added  "+ result);
        
//        Student s1=new Student();
//        s1.setName("Chetan");
//        s1.setCity("Solapur");
//        s1.setId(12);
//        
//        int result = studentdao.uchange(s1);
//        System.out.println("Result updated :: "+result);
        
//        int id=12;
//        int result=studentdao.delete(id);
//        System.out.println("deleted ... "+result);
        
//         Student student = studentdao.getStudent(14);
//         System.out.println(student);
        
         List<Student> allStudent = studentdao.getAllStudent();
         System.out.println(allStudent);
    }
}
