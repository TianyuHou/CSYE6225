package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.Professor;

public class ProfessorService {
	static Map<Long, Professor> db = InMemoryDB.getProfessorDB();
	
	public ProfessorService() {
	}
	
	public List<Professor> getAllProfessors() {
		List<Professor> list = new ArrayList<>();
		db.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public List<Professor> getProfessorsByDepartment(String department) {
		List<Professor> list = new ArrayList<>();
		db.values().stream()
			.filter(e -> e.getDepartment().equalsIgnoreCase(department))
			.forEach(e -> list.add(e));
		return list;
	}

	public Professor getProfessor(String profId) {
		if(db.containsKey(Long.parseLong(profId))) {
			return db.get(Long.parseLong(profId));
		}
		return null;
	}

	public Professor deleteProfessor(long profId) {
		if(db.containsKey(profId)) {
			Professor professor = db.get(profId);
			db.remove(profId);
			return professor;
		}
		return null;
	}
	
	public Professor addProfessor(Professor prof) {
		long nextAvailableId = db.size() + 1;
		db.put(nextAvailableId, prof);
		return prof;
	}

	public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
		long nextAvailableId = db.size() + 1;
		Professor prof = new Professor(firstName , lastName, 
				department, firstName + lastName, joiningDate.toString());
		db.put(nextAvailableId, prof);
	}

	public Professor updateProfessorInformation(long profId, Professor prof) {
		if(db.containsKey(profId)) {
			db.put(profId, prof);
			return prof;
		}
		return null;
	}
}
