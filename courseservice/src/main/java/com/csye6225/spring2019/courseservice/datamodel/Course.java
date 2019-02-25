package com.csye6225.spring2019.courseservice.datamodel;

import java.util.List;

public class Course {
	private String courseName;
	private String courseId;
	private Professor professor;
	private Student ta;
	private String board;
	private List<Lecture> lectures;
	private List<Student> roster;
	
	public Course() {
		
	}
	
	public Course(String courseName, String courseId, Professor professor, Student ta, String board,
			List<Lecture> lectures, List<Student> roster) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.professor = professor;
		this.ta = ta;
		this.board = board;
		this.lectures = lectures;
		this.roster = roster;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Student getTa() {
		return ta;
	}

	public void setTa(Student ta) {
		this.ta = ta;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	public List<Student> getRoster() {
		return roster;
	}

	public void setRoster(List<Student> roster) {
		this.roster = roster;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", professor=" + professor + ", ta=" + ta
				+ ", board=" + board + ", lectures=" + lectures + ", roster=" + roster + "]";
	}
}
