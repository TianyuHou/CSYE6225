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

import com.csye6225.spring2019.courseservice.Services.ProgramService;
import com.csye6225.spring2019.courseservice.datamodel.Program;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;

@Path("programs")
public class ProgramResource {
	ProgramService programService = new ProgramService();
	
	@GET
	public List<Program> getAllPrograms() {
		return programService.getAllPrograms();
	}
	 
	// ... webapi/programs/1
	@GET
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program getProgram(@PathParam("programId") String programId) {
		return programService.getProgram(programId);
	}
	
	@DELETE
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program deleteProgram(@PathParam("programId") long programId) {
		return programService.deleteProgram(programId);
	}
	
	@POST
	@Path("/registerCourse")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program registerCourse(RequestRelationId requestRelationId) {
		return programService.registerCourse(requestRelationId);
	}
	
	@POST
	@Path("/removeCourse")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program removeCourse(RequestRelationId requestRelationId) {
		return programService.removeCourse(requestRelationId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program addProgram(Program program) {
		return programService.addProgram(program);
	}
	
	@PUT
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program updateProgram(@PathParam("programId") long programId, 
			Program program) {
		return programService.updateProgramInformation(programId, program);
	}
}
