package com.apps.studentms.dto;

public class UpdateStudent {
	private String firstName;
	private String lastName;
	private Integer age;
	private String emailId;
	private String stream;

	public UpdateStudent(String firstName, String lastName, Integer age, String emailId, String stream) {
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

	public String getStream() {
		return stream;
	}
}
