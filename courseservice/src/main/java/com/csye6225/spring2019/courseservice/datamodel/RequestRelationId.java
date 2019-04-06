package com.csye6225.spring2019.courseservice.datamodel;

public class RequestRelationId {
	private String boardId;
	private String courseId;
	private String professorId;
	private String studentId;
	private String announcementId;
	
	public RequestRelationId() {
		
	}
	
	public RequestRelationId(String boardId, String courseId, String professorId, String studentId, String announcementId) {
		super();
		this.boardId = boardId;
		this.courseId = courseId;
		this.professorId = professorId;
		this.studentId = studentId;
		this.announcementId = announcementId;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}

	@Override
	public String toString() {
		return "RequestRelationId [boardId=" + boardId + ", courseId=" + courseId + ", professorId=" + professorId
				+ ", studentId=" + studentId + ", announcementId=" + announcementId + "]";
	}
}
