package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.Student;

public class StudentService {
	static Map<Long, Student> db = InMemoryDB.getStudentDB();
	
	public StudentService() {
	}
	
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		db.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public List<Student> getStudentsByProgram(String program) {
		List<Student> list = new ArrayList<>();
		db.values().stream()
			.filter(e -> e.getProgram().getProgramName().equalsIgnoreCase(program))
			.forEach(e -> list.add(e));
		return list;
	}

	public Student getStudent(String stuId) {
		if(db.containsKey(Long.parseLong(stuId))) {
			return db.get(Long.parseLong(stuId));
		}
		return null;
	}

	public Student deleteStudent(long stuId) {
		if(db.containsKey(stuId)) {
			Student student = db.get(stuId);
			db.remove(stuId);
			return student;
		}
		return null;
	}
	
	public Student addStudent(Student student) {
		long nextAvailableId = db.size() + 1;
		student.setStudentId(String.valueOf(nextAvailableId));
		db.put(nextAvailableId, student);
		return student;
	}

	public Student updateStudentInformation(long stuId, Student student) {
		if(db.containsKey(stuId)) {
			student.setStudentId(String.valueOf(stuId));
			db.put(stuId, student);
			return student;
		}
		return null;
	}
}
