package com.csye6225.spring2019.courseservice.datamodel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
	private static Map<Long, Professor> professorDB = new HashMap<> ();
	private static Map<String, Student> studentDB = new HashMap<> ();
	private static Map<String, Course> courseDB = new HashMap<> ();
	private static Map<String, Program> programDB = new HashMap<> ();
	
	public static Map<Long, Professor> getProfessorDB() {
		return professorDB;
	}
	
	public static Map<String, Student> getStudentDB() {
		return studentDB;
	}
	
	public static Map<String, Course> getCourseDB() {
		return courseDB;
	}
	
	public static Map<String, Program> getProgramDB() {
		return programDB;
	}
}
