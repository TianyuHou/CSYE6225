package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.Program;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;
import com.csye6225.spring2019.courseservice.datamodel.Student;

public class StudentService {
	static Map<Long, Student> studentDb = InMemoryDB.getStudentDB();
	static Map<Long, Course> courseDb = InMemoryDB.getCourseDB();
	static Map<Long, Program> programDb = InMemoryDB.getProgramDB();
	
	public StudentService() {
	}
	
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		studentDb.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public List<Student> getStudentsByProgram(String program) {
		List<Student> list = new ArrayList<>();
		studentDb.values().stream()
			.filter(e -> e.getProgramName().equalsIgnoreCase(program))
			.forEach(e -> list.add(e));
		return list;
	}

	public Student getStudent(String stuId) {
		if(studentDb.containsKey(Long.parseLong(stuId))) {
			return studentDb.get(Long.parseLong(stuId));
		}
		return null;
	}

	public Student deleteStudent(long stuId) {
		if(studentDb.containsKey(stuId)) {
			Student student = studentDb.get(stuId);
			studentDb.remove(stuId);
			return student;
		}
		return null;
	}
	
	public Student addStudent(Student student) {
		long nextAvailableId = studentDb.size() + 1;
		student.setStudentId(String.valueOf(nextAvailableId));
		studentDb.put(nextAvailableId, student);
		return student;
	}

	public Student updateStudentInformation(long stuId, Student student) {
		if(studentDb.containsKey(stuId)) {
			student.setStudentId(String.valueOf(stuId));
			studentDb.put(stuId, student);
			return student;
		}
		return null;
	}
	
	public Student registerStudentToCourse(RequestRelationId requestRelationId) {
		long courseId = requestRelationId.getCourseId();
		long stuId = requestRelationId.getStudentId();
		
		if(courseDb.containsKey(courseId) && studentDb.containsKey(stuId)) {
			Course course = courseDb.get(courseId);
			Student student = studentDb.get(stuId);
			course.registerStudent(student);
			student.registerCourse(course);
			
			courseDb.put(courseId, course);
			studentDb.put(stuId, student);
			
			return student;
		}
		
		return null;
	}
	
	public Student removeStudentToCourse(RequestRelationId requestRelationId) {
		long courseId = requestRelationId.getCourseId();
		long stuId = requestRelationId.getStudentId();
		
		if(courseDb.containsKey(courseId) && studentDb.containsKey(stuId)) {
			Course course = courseDb.get(courseId);
			Student student = studentDb.get(stuId);
			course.removeStudent(student);
			student.removeCourse(course);
			
			courseDb.put(courseId, course);
			studentDb.put(stuId, student);
			
			return student;
		}
		
		return null;
	}
	
	public Student registerStudentToProgram(RequestRelationId requestRelationId) {
		long proId = requestRelationId.getProgramId();
		long stuId = requestRelationId.getStudentId();
		
		if(programDb.containsKey(proId) && studentDb.containsKey(stuId)) {
			Program program = programDb.get(proId);
			Student student = studentDb.get(stuId);
			
			student.setProgramName(program.getProgramId());
			studentDb.put(stuId, student);
			programDb.put(proId, program);
			
			return student;
		}
		
		return null;
	}
	
	public Student removeStudentToProgram(RequestRelationId requestRelationId) {
		long stuId = requestRelationId.getStudentId();
		
		if(studentDb.containsKey(stuId)) {
			Student student = studentDb.get(stuId);
			
			student.setProgramName("");
			studentDb.put(stuId, student);
			return student;
		}
		
		return null;
	}
}
