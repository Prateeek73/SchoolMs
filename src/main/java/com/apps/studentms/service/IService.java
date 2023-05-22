package com.apps.studentms.service;

import java.util.List;

import com.apps.studentms.dto.AddStudent;
import com.apps.studentms.dto.UpdateStudent;
import com.apps.studentms.entities.Student;

public interface IService {

	Student addStudent(AddStudent id);

	Student getStudent(Integer id);

	Student removeStudent(Integer id);

	Student updateStudent(Integer id, UpdateStudent updateStudent);

	List<Student> getAllStudents();

	List<Student> getStudentsByAge();

	List<Student> getStudentByName();

	List<Student> getStudentsBySubject(String subjectCode);

}
