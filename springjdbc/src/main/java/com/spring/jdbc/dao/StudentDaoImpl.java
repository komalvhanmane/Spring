package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;
import org.springframework.stereotype.Component;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
        String query="insert into student values(?,?,?)";
        int r =this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int uchange(Student student) {
		// update
		String query="update student set name=? , city=? where id=?";
		int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}

	public int delete(int id) {
		String query="delete from student where id = ?";
		int result = this.jdbcTemplate.update(query,id);
		return result;
	}

	public Student getStudent(int id) {
		//select single student data
		String query = " select * from student where id = ?";
//		RowMapper<Student> rowMapper=new RowMapperImp();
//		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,id);
		//if we use anormous class
		Student student = this.jdbcTemplate.queryForObject(query,new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s2=new Student();
				s2.setId(rs.getInt(1));
				s2.setName(rs.getString(2));
				s2.setCity(rs.getString(3));
				return s2;
			}
			
		},id);

		return student;
	}

	public List<Student> getAllStudent() {
		// selecting multiple students
		String query = "select * from Student";
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImp());
		return students;
	}
}
