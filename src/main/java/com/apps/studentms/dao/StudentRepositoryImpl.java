package com.apps.studentms.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

import com.apps.studentms.entities.Student;
import com.apps.studentms.utilities.Utils;

@Repository("studentRepository")
public class StudentRepositoryImpl implements IDAO {

	private Map<Integer, Student> studentsDB;

	public StudentRepositoryImpl() {
		studentsDB = new HashMap<Integer, Student>(5);
	}

	@Override
	public Student addStudent(Student student) {
		Integer key;
		do {
			key = Utils.generateKey();
		} while (studentsDB.containsKey(key));
		student.setId(key);
		return studentsDB.put(key, student);
	}

	@Override
	public Student getStudent(Integer id) {
		return studentsDB.get(id);
	}

	@Override
	public Student removeStudent(Integer id) {
		return studentsDB.remove(id);
	}

	@Override
	public Student updateStudent(Integer id, Student student) {
		return studentsDB.replace(id, student);
	}

	@Override
	public Collection<Student> fetchAll() {
		return studentsDB.values();
	}

}
