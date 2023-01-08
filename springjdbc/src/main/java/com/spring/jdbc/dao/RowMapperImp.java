package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class RowMapperImp implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s2=new Student();
		s2.setId(rs.getInt(1));
		s2.setName(rs.getString(2));
		s2.setCity(rs.getString(3));
		return s2;
	}

}
