package com.csye6225.spring2019.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Program {
	private String programId;
	private String programName;
	private List<Course> courseList;
	
	public Program() {
	}
	
	public Program(String programId, String programName, List<Course> courseList) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.courseList = courseList;
	}
	
	public void addCourse(Course course) {
		if(courseList == null) {
			courseList = new ArrayList<Course>();
		}
		courseList.add(course);
	}
	
	public void removeCourse(String courseId) {
		if(courseList == null || courseList.size() == 0) {
			return;
		}
		int idx = -1;
		for(int i = 0; i<courseList.size(); i++) {
			if(courseList.get(i).getCourseId().equals(courseId)) {
				idx = i;
				break;
			}
		}
		
		if(idx != -1) {
			courseList.remove(idx);
		}
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", courseList=" + courseList + "]";
	}
}
