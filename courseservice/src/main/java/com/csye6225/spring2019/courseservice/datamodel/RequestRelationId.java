package com.csye6225.spring2019.courseservice.datamodel;

public class RequestRelationId {
	private long lectureId;
	private long courseId;
	private long professorId;
	private long studentId;
	private long programId;
	
	public RequestRelationId() {
		
	}
	
	public RequestRelationId(long lectureId, long courseId, long professorId, long studentId, long programId) {
		super();
		this.lectureId = lectureId;
		this.courseId = courseId;
		this.professorId = professorId;
		this.studentId = studentId;
		this.programId = programId;
	}

	public long getLectureId() {
		return lectureId;
	}

	public void setLectureId(long lectureId) {
		this.lectureId = lectureId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	@Override
	public String toString() {
		return "RequestRelationId [lectureId=" + lectureId + ", courseId=" + courseId + ", professorId=" + professorId
				+ ", studentId=" + studentId + ", programId=" + programId + "]";
	}
}
