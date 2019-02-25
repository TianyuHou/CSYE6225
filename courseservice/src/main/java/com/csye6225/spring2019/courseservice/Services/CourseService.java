package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;

public class CourseService {
	static Map<Long, Course> db = InMemoryDB.getCourseDB();

	public CourseService() {
	}

	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<>();
		db.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public Course getCourse(String courseId) {
		if (db.containsKey(Long.parseLong(courseId))) {
			return db.get(Long.parseLong(courseId));
		}
		return null;
	}

	public Course deleteCourse(long courseId) {
		if (db.containsKey(courseId)) {
			Course course = db.get(courseId);
			db.remove(courseId);
			return course;
		}
		return null;
	}

	public Course addCourse(Course course) {
		long nextAvailableId = db.size() + 1;
		course.setCourseId(String.valueOf(nextAvailableId));
		db.put(nextAvailableId, course);
		return course;
	}

	public Course updateCourseInformation(long courseId, Course course) {
		if (db.containsKey(courseId)) {
			course.setCourseId(String.valueOf(courseId));
			db.put(courseId, course);
			return course;
		}
		return null;
	}
}
