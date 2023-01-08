package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
	public static void main( String[] args )
	{
		Scanner sc=new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao st=context.getBean("studentdao",StudentDao.class);
		//menu driven program
		System.out.println("----------Welcone to Spring-Orm project--------");
		do{
			System.out.println("Enter choice \n1-Insert \n2-update\n3-delete\n4-retrive by Id\n5-retrive all");
			switch(sc.nextInt()) {
			case 1:{
				System.out.println("Enter student id,name,city");
				Student st1=new Student(sc.nextInt(),sc.next(),sc.next());
				int insert = st.insert(st1);
				if(insert>0) {
					System.out.println("Record inserted succefully");
				}
				break;
			}
			case 2:{
				System.out.println("Enter student id for updating values of name,city ");
				Student st1=new Student(sc.nextInt(),sc.next(),sc.next());
				st.updateStudent(st1);
				System.out.println("record updated");
				break;
			}
			case 3:{
				System.out.println("Enter student id for deletion");
				st.deleteStudent(sc.nextInt());
				System.out.println("student record deleted");
				break;
			}
			case 4:{
				System.out.println("Enter Id for retrival data");
				Student student = st.getStudent(sc.nextInt());
				System.out.println(student);
				break;
			}
			case 5:{
				System.out.println("-----------All Records-----------");
				List<Student> allStudent = st.getAllStudent();
				for(Student s:allStudent) {
					System.out.println(s);
				}
				System.out.println("------------------------------------");
				break;
			}
			}
			System.out.println("Enter 1 for continue else press 0");
		}while(sc.nextInt()==1);
		
		System.out.println("---------------------------Thank you-----------------------");
	}
}
