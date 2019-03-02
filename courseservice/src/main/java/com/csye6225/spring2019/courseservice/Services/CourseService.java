package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;
import com.csye6225.spring2019.courseservice.datamodel.Student;

public class CourseService {
	static Map<Long, Course> courseDb = InMemoryDB.getCourseDB();
	static Map<Long, Student> studentDb = InMemoryDB.getStudentDB();

	public CourseService() {
	}

	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<>();
		courseDb.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public Course getCourse(String courseId) {
		if (courseDb.containsKey(Long.parseLong(courseId))) {
			return courseDb.get(Long.parseLong(courseId));
		}
		return null;
	}

	public Course deleteCourse(long courseId) {
		if (courseDb.containsKey(courseId)) {
			Course course = courseDb.get(courseId);
			courseDb.remove(courseId);
			return course;
		}
		return null;
	}

	public Course addCourse(Course course) {
		long nextAvailableId = courseDb.size() + 1;
		course.setCourseId(String.valueOf(nextAvailableId));
		courseDb.put(nextAvailableId, course);
		return course;
	}

	public Course updateCourseInformation(long courseId, Course course) {
		if (courseDb.containsKey(courseId)) {
			course.setCourseId(String.valueOf(courseId));
			courseDb.put(courseId, course);
			return course;
		}
		return null;
	}
	
	public Course registerTA(RequestRelationId requestRelationId) {
		long stuId = requestRelationId.getStudentId();
		long courseId = requestRelationId.getCourseId();
		
		if(studentDb.containsKey(stuId) && courseDb.containsKey(courseId)) {
			Course course = courseDb.get(courseId);
			Student student = studentDb.get(stuId);
			course.setTa(student.getStudentId());
			
			courseDb.put(courseId, course);
			
			return course;
		}
		
		return null;
	}
}
