package com.csye6225.spring2019.courseservice.datamodel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
	private static Map<String, Professor> professorDB = new HashMap<>();
	private static Map<String, Student> studentDB = new HashMap<>();
	private static Map<String, Course> courseDB = new HashMap<>();
	private static Map<String, Board> boardDB = new HashMap<>();
	private static Map<String, Announcement> announcementDB = new HashMap<>();

	public static Map<String, Professor> getProfessorDB() {
		return professorDB;
	}

	public static Map<String, Student> getStudentDB() {
		return studentDB;
	}

	public static Map<String, Course> getCourseDB() {
		return courseDB;
	}

	public static Map<String, Board> getBoardDB() {
		return boardDB;
	}

	public static Map<String, Announcement> getAnnouncementDB() {
		return announcementDB;
	}
}
