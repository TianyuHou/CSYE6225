package com.csye6225.spring2019.courseservice.datamodel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
	private static Map<Long, Professor> professorDB = new HashMap<> ();
	private static Map<Long, Student> studentDB = new HashMap<> ();
	private static Map<Long, Course> courseDB = new HashMap<> ();
	private static Map<Long, Program> programDB = new HashMap<> ();
	
	public static Map<Long, Professor> getProfessorDB() {
		return professorDB;
	}
	
	public static Map<Long, Student> getStudentDB() {
		return studentDB;
	}
	
	public static Map<Long, Course> getCourseDB() {
		return courseDB;
	}
	
	public static Map<Long, Program> getProgramDB() {
		return programDB;
	}
}
