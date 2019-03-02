package com.csye6225.spring2019.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;
	private List<String> courses;
	
	public Professor() {

	}

	public Professor(String firstName, String lastName, String department, String professorId, String joiningDate,
			List<String> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.professorId = professorId;
		this.joiningDate = joiningDate;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public void registCourse(Course course) {
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
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department
				+ ", professorId=" + professorId + ", joiningDate=" + joiningDate + ", courses=" + courses + "]";
	}
}
