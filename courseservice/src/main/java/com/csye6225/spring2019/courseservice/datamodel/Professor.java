package com.csye6225.spring2019.courseservice.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "professor")
public class Professor {
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;

	public Professor() {

	}

	public Professor(String firstName, String lastName, String department, String professorId, String joiningDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.professorId = professorId;
		this.joiningDate = joiningDate;
	}

	@DynamoDBHashKey(attributeName = "professorId")
	@DynamoDBAutoGeneratedKey
	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	@DynamoDBAttribute(attributeName = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute(attributeName = "department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@DynamoDBAttribute(attributeName = "joiningDate")
	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@DynamoDBIgnore
	@Override
	public String toString() {
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department
				+ ", professorId=" + professorId + ", joiningDate=" + joiningDate + "]";
	}
}
