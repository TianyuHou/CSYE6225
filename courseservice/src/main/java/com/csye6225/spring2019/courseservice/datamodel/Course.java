package com.csye6225.spring2019.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseName;
	private String courseId;
	private String professor;
	private String ta;
	private String board;
	private String programName;
	private List<String> lectures;
	private List<String> roster;

	public Course() {

	}

	public Course(String courseName, String courseId, String professor, String ta, String board, String programName,
			List<String> lectures, List<String> roster) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.professor = professor;
		this.ta = ta;
		this.board = board;
		this.programName = programName;
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

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public List<String> getLectures() {
		return lectures;
	}

	public void setLectures(List<String> lectures) {
		this.lectures = lectures;
	}

	public void setRoster(List<String> roster) {
		this.roster = roster;
	}

	public void registerLecture(Lecture lecture) {
		if (lectures == null || lectures.size() == 0) {
			lectures = new ArrayList<>();
		}
		lectures.add(lecture.getLectureId());
	}

	public void removeLecture(Lecture lecture) {
		if (lectures != null && lectures.size() != 0) {
			int idx = -1;
			for (int i = 0; i < lectures.size(); i++) {
				if (lectures.get(i).equalsIgnoreCase(lecture.getLectureId())) {
					idx = i;
					break;
				}
			}
			if (idx != -1) {
				lectures.remove(idx);
			}
		}
	}

	public void registerStudent(Student student) {
		if (roster == null || roster.size() == 0) {
			roster = new ArrayList<String>();
		}
		roster.add(student.getStudentId());
	}

	public void removeStudent(Student student) {
		if (roster != null && roster.size() != 0) {
			int idx = -1;
			for (int i = 0; i < roster.size(); i++) {
				if (roster.get(i).equalsIgnoreCase(student.getStudentId())) {
					idx = i;
					break;
				}
			}
			if (idx != -1) {
				roster.remove(idx);
			}
		}
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", professor=" + professor + ", ta=" + ta
				+ ", board=" + board + ", programName=" + programName + ", lectures=" + lectures + ", roster=" + roster
				+ "]";
	}
}
