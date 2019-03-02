package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.Professor;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;

public class ProfessorService {
	static Map<Long, Professor> professorDb = InMemoryDB.getProfessorDB();
	static Map<Long, Course> courseDb = InMemoryDB.getCourseDB();
	
	public ProfessorService() {
	}
	
	public List<Professor> getAllProfessors() {
		List<Professor> list = new ArrayList<>();
		professorDb.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public List<Professor> getProfessorsByDepartment(String department) {
		List<Professor> list = new ArrayList<>();
		professorDb.values().stream()
			.filter(e -> e.getDepartment().equalsIgnoreCase(department))
			.forEach(e -> list.add(e));
		return list;
	}

	public Professor getProfessor(String profId) {
		if(professorDb.containsKey(Long.parseLong(profId))) {
			return professorDb.get(Long.parseLong(profId));
		}
		return null;
	}

	public Professor deleteProfessor(long profId) {
		if(professorDb.containsKey(profId)) {
			Professor professor = professorDb.get(profId);
			professorDb.remove(profId);
			return professor;
		}
		return null;
	}
	
	public Professor addProfessor(Professor prof) {
		long nextAvailableId = professorDb.size() + 1;
		prof.setProfessorId(String.valueOf(nextAvailableId));
		prof.setJoiningDate(new Date().toString());
		professorDb.put(nextAvailableId, prof);
		return prof;
	}

	public Professor updateProfessorInformation(long profId, Professor prof) {
		if(professorDb.containsKey(profId)) {
			Professor oldProfessor = professorDb.get(profId);
			if(prof.getJoiningDate() == null || prof.getJoiningDate().equalsIgnoreCase("")) {
				prof.setJoiningDate(oldProfessor.getJoiningDate());
			}
			
			prof.setProfessorId(String.valueOf(profId));
			professorDb.put(profId, prof);
			
			return prof;
		}
		return null;
	}
	
	public Professor registerProfessor(RequestRelationId requestRelationId) {
		long proId = requestRelationId.getProfessorId();
		long courseId = requestRelationId.getCourseId();
		
		if(professorDb.containsKey(proId) && courseDb.containsKey(courseId)) {
			Course course = courseDb.get(courseId);
			Professor professor = professorDb.get(proId);
			course.setProfessor(professor.getProfessorId());
			professor.registCourse(course);
			
			courseDb.put(courseId, course);
			professorDb.put(proId, professor);
			
			return professor;
		}
		
		return null;
	}
	
	public Professor removeProfessor(RequestRelationId requestRelationId) {
		long proId = requestRelationId.getProfessorId();
		long courseId = requestRelationId.getCourseId();
		
		if(professorDb.containsKey(proId) && courseDb.containsKey(courseId)) {
			Course course = courseDb.get(courseId);
			Professor professor = professorDb.get(proId);
			course.setProfessor("");
			professor.removeCourse(course);
			
			courseDb.put(courseId, course);
			professorDb.put(proId, professor);
			
			return professor;
		}
		
		return null;
	}
}
