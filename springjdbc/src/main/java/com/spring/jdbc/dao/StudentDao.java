package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;


public interface StudentDao {
	public int insert(Student student);
	public int uchange(Student student);
	public int delete(int id);
	//single row
	public Student getStudent(int id);
	//multiple row
	public List<Student> getAllStudent();
}
