package com.apps.studentms.frontend;

import com.apps.studentms.dto.AddStudent;
import com.apps.studentms.dto.UpdateStudent;
import com.apps.studentms.entities.Student;
import com.apps.studentms.service.IService;
import com.apps.studentms.service.ServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleFront {

	private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private IService service;

	public ConsoleFront() {
		service = new ServiceImpl();
	}

	public void runUI() {
		printSnippet();
		while (true) {
			try {
				System.out.print("\nEnter  your choice here: ");
				String choice = reader.readLine();
				Student student;
				List<Student> studentsList;
				switch (choice) {
				case "0":
					System.exit(0);
				case "1":
					student = service.addStudent(getAddStudent());
					if (student != null)
						System.out.println("Student added with details: " + student);
					break;
				case "2":
					System.out.print("Enter id of student to fetch: ");
					student = service.getStudent(Integer.valueOf(reader.readLine()));
					if (student != null)
						System.out.println("Student details of id: " + student);
					break;
				case "3":
					System.out.print("Enter id of student to be removed: ");
					student = service.removeStudent(Integer.valueOf(reader.readLine()));
					if (student != null)
						System.out.println("Student details removed: " + student);
					break;
				case "4":
					System.out.print("Enter id of student to update: ");
					System.out.println("Student detailes replaced for: "
							+ service.updateStudent(Integer.valueOf(reader.readLine()), getUpdateStudent()));
					break;
				case "5":
					System.out.println("List of all students: ");
					studentsList = service.getAllStudents();
					if (!studentsList.isEmpty())
						studentsList.stream().forEach(System.out::println);
					break;
				case "6":
					System.out.println("List of students by age: ");
					studentsList = service.getStudentsByAge();
					studentsList.stream().forEach(System.out::println);
					break;
				case "7":
					System.out.println("List of students by name: ");
					studentsList = service.getStudentsByAge();
					studentsList.stream().forEach(System.out::println);
					break;
				case "8":
					System.out.print("Enter stream of students to fetch: ");
					System.out.println("List of students by stream: ");
					studentsList = service.getStudentsBySubject(reader.readLine());
					studentsList.stream().forEach(System.out::println);
					break;
				case "9":
					printSnippet();
				default:
					continue;
				}
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			} catch (NumberFormatException ex) {
				System.err.println("Invalid input: " + ex.getMessage());
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.err.println(ex.getMessage());
			} catch (Exception ex) {
				System.err.println("Invalid input: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	private static void printSnippet() {
		System.out.println();
		System.out.println("***************************************");
		System.out.println("WELCOME to Student MS terminal toolkit");
		System.out.println("***************************************");

		System.out.println("Choices:-");
		System.out.println("0 - Exit");
		System.out.println("1 - Add Student");
		System.out.println("2 - Get Student");
		System.out.println("3 - Remove Student");
		System.out.println("4 - Update Student");
		System.out.println("5 - Get all Students");
		System.out.println("6 - Get Students list by age");
		System.out.println("7 - Get Students list by firstName");
		System.out.println("8 - Get Students list by stream");
		System.out.println("9 - Get choice inputs");
	}

	private static AddStudent getAddStudent() throws IOException, ArrayIndexOutOfBoundsException {
		System.out.println();
		System.out.println("*******Enter Student Details*******");
		System.out.println("Enter stream by subject choice {PCMB, PCM, PCB, COMM, ARTS}");
		System.out.print("Enter firstName, lastName, age, emailID, stream: ");
		String[] inputs = reader.readLine().split(" ");
		if (inputs.length != 5)
			throw new ArrayIndexOutOfBoundsException(
					"Input argument size should be of 5. Invalid size of: " + inputs.length);
		return new AddStudent(inputs[0], inputs[1], Integer.valueOf(inputs[2]), inputs[3], inputs[4]);
	}

	private static UpdateStudent getUpdateStudent() throws IOException, ArrayIndexOutOfBoundsException {
		System.out.println();
		System.out.println("*******Enter Student Details to be Updated*******");
		System.out.println("Enter stream by subject choice {PCMB, PCM, PCB, COMM, ARTS}");
		System.out.print("Enter firstName, lastName, age, emailID, stream: ");
		String[] inputs = reader.readLine().split(" ");
		if (inputs.length != 5)
			throw new ArrayIndexOutOfBoundsException(
					"Input argument size should be of 5. Invalid size of: " + inputs.length);
		return new UpdateStudent(inputs[0], inputs[1], Integer.valueOf(inputs[2]), inputs[3], inputs[4]);
	}
}
