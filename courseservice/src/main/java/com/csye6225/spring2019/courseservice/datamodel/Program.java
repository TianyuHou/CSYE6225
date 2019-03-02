package com.csye6225.spring2019.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Program {
	private String programId;
	private String programName;
	private List<String> courseList;
	
	public Program() {
	}
	
	public Program(String programId, String programName, List<String> courseList) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.courseList = courseList;
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

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}

	public void registerCourse(Course course) {
		if(courseList == null || courseList.size() == 0) {
			courseList = new ArrayList<String>();
		}
		courseList.add(course.getCourseId());
	}
	
	public void removeCourse(Course course) {
		if(courseList != null && courseList.size() != 0) {
			int idx = -1;
			for(int i = 0; i<courseList.size(); i++) {
				if(courseList.get(i).equalsIgnoreCase(course.getCourseId())) {
					idx = i;
					break;
				}
			}
			
			if(idx != -1) {
				courseList.remove(idx);
			}
		}
	}

	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", courseList=" + courseList + "]";
	}
}
