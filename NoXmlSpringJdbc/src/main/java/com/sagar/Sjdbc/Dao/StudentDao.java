package com.sagar.Sjdbc.Dao;

import java.util.List;

import com.sagar.Sjdbc.Entity.Student;

public interface StudentDao {

	public int insert(Student student);
	public int change(Student student);
	public int remove(Student student);
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();
	
	
	
	
	
	
	
	
}
