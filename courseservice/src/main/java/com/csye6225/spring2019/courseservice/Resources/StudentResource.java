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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2019.courseservice.Services.StudentService;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;
import com.csye6225.spring2019.courseservice.datamodel.Student;

@Path("students")
public class StudentResource {
	StudentService studentService = new StudentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByDeparment(@QueryParam("program") String program) {
		if (program == null) {
			return studentService.getAllStudents();
		}
		return studentService.getStudentsByProgram(program);
	}
	 
	// ... webapi/students/1
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("studentId") String stuId) {
		return studentService.getStudent(stuId);
	}
	
	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("studentId") long stuId) {
		return studentService.deleteStudent(stuId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) {
		return studentService.addStudent(student);
	}
	
	@POST
	@Path("/registerStudentToCourse")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student registerStudentToCourse(RequestRelationId requestRelationId) {
		return studentService.registerStudentToCourse(requestRelationId);
	}
	
	@POST
	@Path("/removeStudentToCourse")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student removeStudentToCourse(RequestRelationId requestRelationId) {
		return studentService.removeStudentToCourse(requestRelationId);
	}
	
	@POST
	@Path("/registerStudentToProgram")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student registerStudentToProgram(RequestRelationId requestRelationId) {
		return studentService.registerStudentToProgram(requestRelationId);
	}
	
	@POST
	@Path("/removeStudentToProgram")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student removeStudentToProgram(RequestRelationId requestRelationId) {
		return studentService.removeStudentToProgram(requestRelationId);
	}
	
	@PUT
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("studentId") long stuId, 
			Student student) {
		return studentService.updateStudentInformation(stuId, student);
	}
}
