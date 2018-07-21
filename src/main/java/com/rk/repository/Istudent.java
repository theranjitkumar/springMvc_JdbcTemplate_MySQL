package com.rk.repository;

import java.util.List;

import com.rk.model.Student;


public interface Istudent {
	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int id);
	public Student studentById(int sid);
	public List<Student> list();
}
