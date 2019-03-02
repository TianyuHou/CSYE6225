package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.Program;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;

public class ProgramService {
	static Map<Long, Program> programDb = InMemoryDB.getProgramDB();
	static Map<Long, Course> courseDb = InMemoryDB.getCourseDB();
	
	public ProgramService() {
	}
	
	public List<Program> getAllPrograms() {
		List<Program> list = new ArrayList<>();
		programDb.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public Program getProgram(String proId) {
		if(programDb.containsKey(Long.parseLong(proId))) {
			return programDb.get(Long.parseLong(proId));
		}
		return null;
	}

	public Program deleteProgram(long proId) {
		if(programDb.containsKey(proId)) {
			Program program = programDb.get(proId);
			programDb.remove(proId);
			return program;
		}
		return null;
	}
	
	public Program addProgram(Program program) {
		long nextAvailableId = programDb.size() + 1;
		program.setProgramId(String.valueOf(nextAvailableId));
		programDb.put(nextAvailableId, program);
		return program;
	}

	public Program updateProgramInformation(long proId, Program program) {
		if(programDb.containsKey(proId)) {
			program.setProgramId(String.valueOf(proId));
			programDb.put(proId, program);
			return program;
		}
		return null;
	}
	
	public Program registerCourse(RequestRelationId requestRelationId) {
		long proId = requestRelationId.getProgramId();
		long courseId = requestRelationId.getCourseId();
		
		if(programDb.containsKey(proId) && courseDb.containsKey(courseId)) {
			Program program = programDb.get(proId);
			Course course = courseDb.get(courseId);
			program.registerCourse(course);
			course.setProgramName(program.getProgramId());
			
			programDb.put(proId, program);
			courseDb.put(courseId, course);
			
			return program;
		}
		
		return null;
	}
	
	public Program removeCourse(RequestRelationId requestRelationId) {
		long proId = requestRelationId.getProgramId();
		long courseId = requestRelationId.getCourseId();
		
		if(programDb.containsKey(proId) && courseDb.containsKey(courseId)) {
			Program program = programDb.get(proId);
			Course course = courseDb.get(courseId);
			program.removeCourse(course);
			course.setProgramName("");
			
			programDb.put(proId, program);
			courseDb.put(courseId, course);
			
			return program;
		}
		
		return null;
	}
}
