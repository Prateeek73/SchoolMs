package com.apps.studentms.entities;

public class Student {

	public enum Subjects {
		PCMB, PCM, PCB, COMM, ARTS
	}

	private Integer id;
	private final String firstName;
	private final String lastName;
	private final Integer age;
	private final String emailId;
	private final Subjects stream;

	public Student(String firstName, String lastName, Integer age, String emailId, Subjects stream) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.emailId = emailId;
		this.stream = stream;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getEmailId() {
		return emailId;
	}

	public Subjects getStream() {
		return stream;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", emailId=" + emailId + ", stream=" + stream + "]";
	}
}
