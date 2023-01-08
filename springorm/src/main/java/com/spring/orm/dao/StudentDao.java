package com.spring.orm.dao;
//ORM - Object relational mapping
import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hb;

	public HibernateTemplate getHb() {
		return hb;
	}

	public void setHb(HibernateTemplate hb) {
		this.hb = hb;
	}

	//save student
	@Transactional
	public int insert(Student student) {
		Serializable save = this.hb.save(student);
		return (Integer)save;
	}

	//get single object
	public Student getStudent(int id) {
		Student student = this.hb.get(Student.class, id);
		return student;
	}

	//get all student
	public List<Student> getAllStudent(){
		List<Student> list = this.hb.loadAll(Student.class);
		return list;
	}
	
	@Transactional
	public void deleteStudent(int id) {
		Student student = this.hb.get(Student.class, id);
		this.hb.delete(student);
	}
	
	//update
	@Transactional
	public void updateStudent(Student student) {
		this.hb.update(student);
	}
}
