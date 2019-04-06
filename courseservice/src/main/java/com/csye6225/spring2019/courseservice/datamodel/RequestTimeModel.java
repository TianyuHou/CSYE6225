package com.csye6225.spring2019.courseservice.datamodel;

import java.util.Date;

public class RequestTimeModel {
	private Date startDate;
	private Date endDate;
	
	public RequestTimeModel() {
		
	}

	public RequestTimeModel(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "RequestTimeModel [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
