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
import com.csye6225.spring2019.courseservice.datamodel.RequestTimeModel;
import com.csye6225.spring2019.courseservice.datamodel.Student;

@Path("students")
public class StudentResource {
	StudentService studentService = new StudentService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentsByDeparment(@QueryParam("department") String department) {
		if (department == null) {
			return studentService.getAllStudents();
		}
		return studentService.getStudentsByDepartment(department);
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
	public Student deleteStudent(@PathParam("studentId") String stuId) {
		return studentService.deleteStudent(stuId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) {
		return studentService.addStudent(student);
	}
	
	@POST
	@Path("/getStudentByTimePeriod")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Student> getStudentWithinTimePeriod(RequestTimeModel requestTimeModel) {
		return studentService.getStudentWithinTimePeriod(requestTimeModel);
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

	@PUT
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("studentId") String stuId, Student student) {
		return studentService.updateStudent(stuId, student);
	}
}
