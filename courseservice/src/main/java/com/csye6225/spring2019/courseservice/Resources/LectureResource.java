package com.csye6225.spring2019.courseservice.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2019.courseservice.Services.LectureService;
import com.csye6225.spring2019.courseservice.datamodel.Lecture;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;

@Path("lectures")
public class LectureResource {
	LectureService lectureService = new LectureService();
	
	@GET
	public List<Lecture> getAlllectures() {
		return lectureService.getAllLectures();
	}
	 
	// ... webapi/lectures/1
	@GET
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture getlecture(@PathParam("lectureId") String lectureId) {
		return lectureService.getLecture(lectureId);
	}
	
	@DELETE
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture deletelecture(@PathParam("lectureId") long lectureId) {
		return lectureService.deleteLecture(lectureId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture addlecture(Lecture lecture) {
		return lectureService.addLecture(lecture);
	}
	
	@POST
	@Path("/registerLecture")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture registerLecture(RequestRelationId requestRelationId) {
		return lectureService.registerLecture(requestRelationId);
	}
	
	@POST
	@Path("/removeLecture")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture removeLecture(RequestRelationId requestRelationId) {
		return lectureService.removeLecture(requestRelationId);
	}
	
	@PUT
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture updatelecture(@PathParam("lectureId") long lectureId, 
			Lecture lecture) {
		return lectureService.updateLectureInformation(lectureId, lecture);
	}
}
