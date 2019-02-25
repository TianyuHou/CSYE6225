package com.csye6225.spring2019.courseservice.datamodel;

import java.io.File;
import java.util.List;

public class Student {
	private String name;
	private String studentId;
	private File image;
	private List<Course> courses;
	private Program program;
	
	public Student() {
		
	}

	public Student(String name, String studentId, File image, List<Course> courses, Program program) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.image = image;
		this.courses = courses;
		this.program = program;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
