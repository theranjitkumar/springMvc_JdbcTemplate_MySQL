package com.rk.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rk.model.Student;

@Repository
public class StudentImpl implements Istudent {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addStudent(Student student) {
		String sql = "INSERT INTO student (id, name, city)"
                + " VALUES (?, ?, ?)";
		this.jdbcTemplate.update(sql,student.getId(), student.getName(),student.getCity());

	}

	@Override
	public void updateStudent(Student student) {
		String sql = "UPDATE student SET id=?, name=?, city=?, WHERE id=?";
		this.jdbcTemplate.update(sql,student.getId(), student.getName(),student.getCity());

	}

	@Override
	public void deleteStudent(int id) {
		String sql = "DELETE FROM student WHERE id=?";
	    jdbcTemplate.update(sql, id);
	}

	@Override
	public Student studentById(int sid) {
		String sql = "SELECT * FROM student WHERE id=" + sid;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
	 
	        @Override
	        public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
	            if (rs.next()) {
	                Student student = new Student();
	                student.setId(rs.getInt("id"));
	                student.setName(rs.getString("name"));
	                student.setCity(rs.getString("city"));
	                return student;
	            }	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Student> list() {
		   String sql = "SELECT * FROM student";
		    List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {
		 
		        @Override
		        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	Student aStudent = new Student();
		 
		        	aStudent.setId(rs.getInt("id"));
		        	aStudent.setName(rs.getString("name"));
		        	aStudent.setCity(rs.getString("city"));
		 
		            return aStudent;
		        }
		 
		    });
		 
		    return listStudent;
	}

}
