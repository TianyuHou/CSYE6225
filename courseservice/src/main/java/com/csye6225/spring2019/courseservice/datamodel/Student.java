package com.csye6225.spring2019.courseservice.datamodel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String studentId;
	private String programName;
	private File image;
	private List<String> courses;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String studentId, String programName, File image,
			List<String> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.programName = programName;
		this.image = image;
		this.courses = courses;
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

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public void registerCourse(Course course) {
		if(courses == null || courses.size() == 0) {
			courses = new ArrayList<String>();
		}
		courses.add(course.getCourseId());
	}
	
	public void removeCourse(Course course) {
		if(courses != null && courses.size() != 0) {
			int idx = -1;
			
			for(int i = 0; i<courses.size(); i++) {
				if(courses.get(i).equalsIgnoreCase(course.getCourseId())) {
					idx = i;
					break;
				}
			}
			
			if(idx != -1) {
				courses.remove(idx);
			}
		}
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentId=" + studentId
				+ ", programName=" + programName + ", image=" + image + ", courses=" + courses + "]";
	}
}
