package com.apps.studentms.utilities;

import java.util.regex.Pattern;

import com.apps.studentms.entities.InvalidStreamException;
import com.apps.studentms.entities.Student;
import com.apps.studentms.entities.Student.Subjects;

public class Utils {

	public static Integer generateKey() {
		return (int) (Math.random() * 100);
	}

	public static Subjects getSubjectEnum(String subject) throws InvalidStreamException {
		for (Subjects value : Student.Subjects.values())
			if (subject.equals(value.toString()))
				return value;
		throw new InvalidStreamException("The provided stream is invalid: " + subject);
	}

	public static boolean validateEmailId(String emailId) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		if (emailId == null)
			return false;
		return pattern.matcher(emailId).matches();

	}

}
