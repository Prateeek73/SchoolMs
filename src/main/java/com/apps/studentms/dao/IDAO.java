package com.apps.studentms.dao;

import java.util.Collection;

import com.apps.studentms.entities.Student;

public interface IDAO{
	 
	Student addStudent(Student addStudent);
    Student getStudent(Integer id);
	Student removeStudent(Integer id);
	Student updateStudent(Integer id, Student student);
	Collection<Student> fetchAll(); 
	
}