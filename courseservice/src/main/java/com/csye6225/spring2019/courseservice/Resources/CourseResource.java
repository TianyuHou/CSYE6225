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

import com.csye6225.spring2019.courseservice.Services.CourseService;
import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;

@Path("courses")
public class CourseResource {
	CourseService courseService = new CourseService();
	
	@GET
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	 
	// ... webapi/courses/1
	@GET
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourse(@PathParam("courseId") String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@DELETE
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("courseId") long courseId) {
		return courseService.deleteCourse(courseId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
		return courseService.addCourse(course);
	}
	
	@POST
	@Path("/registerTA")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course registerTA(RequestRelationId requestRelationId) {
		return courseService.registerTA(requestRelationId);
	}
	
	@PUT
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("courseId") long courseId, 
			Course course) {
		return courseService.updateCourseInformation(courseId, course);
	}
}
