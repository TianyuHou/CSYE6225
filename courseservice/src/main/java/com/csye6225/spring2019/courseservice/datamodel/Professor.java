package com.csye6225.spring2019.courseservice.datamodel;

public class Professor {
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;
	
	public Professor() {
		
	}
	
	public Professor(String firstName, String lastName, String department, String professorId,
			String joiningDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.professorId = professorId;
		this.joiningDate = joiningDate;
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

	@Override
	public String toString() {
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", professorId=" + professorId + ", joiningDate=" + joiningDate + "]";
	}

	
	
}
