package com.csye6225.spring2019.courseservice.datamodel;

import java.io.File;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String studentId;
	private File image;
	private List<Course> courses;
	private Program program;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String studentId, File image, List<Course> courses,
			Program program) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.image = image;
		this.courses = courses;
		this.program = program;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentId=" + studentId + ", image="
				+ image + ", courses=" + courses + ", program=" + program + "]";
	}
}
