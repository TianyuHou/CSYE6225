package com.csye6225.spring2019.courseservice.datamodel;

import java.util.List;

public class Lecture {
	private String lectureName;
	private String lectureId;
	private List<String> notes;
	private List<String> materials;
	
	public Lecture() {
		
	}
	
	public Lecture(String lectureName, String lectureId, List<String> notes, List<String> materials) {
		super();
		this.lectureName = lectureName;
		this.lectureId = lectureId;
		this.notes = notes;
		this.materials = materials;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureId() {
		return lectureId;
	}

	public void setLectureId(String lectureId) {
		this.lectureId = lectureId;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public List<String> getMaterials() {
		return materials;
	}

	public void setMaterials(List<String> materials) {
		this.materials = materials;
	}

	@Override
	public String toString() {
		return "Lecture [lectureName=" + lectureName + ", lectureId=" + lectureId + ", notes=" + notes + ", materials="
				+ materials + "]";
	}
}
