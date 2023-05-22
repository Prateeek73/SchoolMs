package com.apps.studentms.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.apps.studentms.dao.DAOMapImpl;
import com.apps.studentms.dao.IDAO;
import com.apps.studentms.dto.AddStudent;
import com.apps.studentms.dto.UpdateStudent;
import com.apps.studentms.entities.InvalidEmailException;
import com.apps.studentms.entities.InvalidStreamException;
import com.apps.studentms.entities.Student;
import com.apps.studentms.entities.StudentNotFoundException;
import com.apps.studentms.utilities.Utils;

public class ServiceImpl implements IService {

	private IDAO studentRepository;

	public ServiceImpl() {
		studentRepository = new DAOMapImpl();
	}

	@Override
	public Student addStudent(AddStudent addStudent) {
		try {
			String firstName = addStudent.getFirstName();
			String lastName = addStudent.getLastName();
			Integer age = addStudent.getAge();
			String emailId = addStudent.getEmailId();
			String subject = addStudent.getStream();

			Student.Subjects stream = Utils.getSubjectEnum(subject);
			if (!Utils.validateEmailId(emailId))
				throw new InvalidEmailException("The provided email id is invalid: " + emailId);
			Student student = new Student(firstName, lastName, age, emailId, stream);
			return studentRepository.addStudent(student);
		} catch (InvalidStreamException ex) {
			System.err.println(ex.getMessage());
		} catch (InvalidEmailException ex) {
			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getStudent(Integer id) {
		try {
			Student student = studentRepository.getStudent(id);
			if (student == null)
				throw new StudentNotFoundException("No student found for id: " + id);
			return student;
		} catch (StudentNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Student removeStudent(Integer id) {
		try {
			Student student = studentRepository.removeStudent(id);
			if (student == null)
				throw new StudentNotFoundException("No student found for id: " + id);
			return student;
		} catch (StudentNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Student updateStudent(Integer id, UpdateStudent updateStudent) {
		try {
			getStudent(id);
			
			String firstName = updateStudent.getFirstName();
			String lastName = updateStudent.getLastName();
			Integer age = updateStudent.getAge();
			String emailId = updateStudent.getEmailId();
			String subject = updateStudent.getStream();

			Student.Subjects stream = Utils.getSubjectEnum(subject);
			if (!Utils.validateEmailId(emailId))
				throw new InvalidEmailException("The provided email id is invalid: " + emailId);

			Student studentUpdated = new Student(firstName, lastName, age, emailId, stream);
			studentUpdated.setId(id);
			return studentRepository.updateStudent(id, studentUpdated);
		} catch (InvalidStreamException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		} catch (InvalidEmailException ex) {
			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.fetchAll().stream().collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsByAge() {
		Collection<Student> studentList = Collections.unmodifiableCollection(studentRepository.fetchAll());
		return studentList.stream().sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentByName() {
		Collection<Student> studentList = Collections.unmodifiableCollection(studentRepository.fetchAll());
		return studentList.stream().sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsBySubject(String subjectCode) {
		try {
			Student.Subjects stream = Utils.getSubjectEnum(subjectCode);
			Collection<Student> studentList = Collections.unmodifiableCollection(studentRepository.fetchAll());
			return studentList.stream().filter(student -> student.getStream() == stream).collect(Collectors.toList());
		} catch (InvalidStreamException ex) {
			System.err.println(ex.getMessage());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		return Collections.emptyList();
	}

}
