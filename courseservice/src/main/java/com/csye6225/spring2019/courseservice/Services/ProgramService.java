package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.Program;

public class ProgramService {
	static Map<Long, Program> db = InMemoryDB.getProgramDB();
	
	public ProgramService() {
	}
	
	public List<Program> getAllPrograms() {
		List<Program> list = new ArrayList<>();
		db.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public Program getProgram(String proId) {
		if(db.containsKey(Long.parseLong(proId))) {
			return db.get(Long.parseLong(proId));
		}
		return null;
	}

	public Program deleteProgram(long proId) {
		if(db.containsKey(proId)) {
			Program program = db.get(proId);
			db.remove(proId);
			return program;
		}
		return null;
	}
	
	public Program addProgram(Program program) {
		long nextAvailableId = db.size() + 1;
		program.setProgramId(String.valueOf(nextAvailableId));
		db.put(nextAvailableId, program);
		return program;
	}

	public Program updateProgramInformation(long proId, Program program) {
		if(db.containsKey(proId)) {
			program.setProgramId(String.valueOf(proId));
			db.put(proId, program);
			return program;
		}
		return null;
	}
}
