package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.InMemoryDB;
import com.csye6225.spring2019.courseservice.datamodel.Lecture;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;

public class LectureService {
	static Map<Long, Lecture> lectureDB = InMemoryDB.getLectureDB();
	static Map<Long, Course> courseDB = InMemoryDB.getCourseDB();

	public LectureService() {
	}

	public List<Lecture> getAllLectures() {
		List<Lecture> list = new ArrayList<>();
		lectureDB.values().stream().forEach(e -> list.add(e));
		return list;
	}

	public Lecture getLecture(String lectureId) {
		if (lectureDB.containsKey(Long.parseLong(lectureId))) {
			return lectureDB.get(Long.parseLong(lectureId));
		}
		return null;
	}

	public Lecture deleteLecture(long lectureId) {
		if (lectureDB.containsKey(lectureId)) {
			Lecture lecture = lectureDB.get(lectureId);
			lectureDB.remove(lectureId);
			return lecture;
		}
		return null;
	}

	public Lecture addLecture(Lecture lecture) {
		long nextAvailableId = lectureDB.size() + 1;
		lecture.setLectureId(String.valueOf(nextAvailableId));
		lectureDB.put(nextAvailableId, lecture);
		return lecture;
	}

	public Lecture updateLectureInformation(long lectureId, Lecture lecture) {
		if (lectureDB.containsKey(lectureId)) {
			lecture.setLectureId(String.valueOf(lectureId));
			lectureDB.put(lectureId, lecture);
			return lecture;
		}
		return null;
	}
	
	public Lecture registerLecture(RequestRelationId requestRelationId) {
		long lectureId = requestRelationId.getLectureId();
		long courseId = requestRelationId.getCourseId();
		
		if(lectureDB.containsKey(lectureId) && courseDB.containsKey(courseId)) {
			Course course = courseDB.get(courseId);
			Lecture lecture = lectureDB.get(lectureId);
			course.registerLecture(lecture);
			lecture.setCourse(course.getCourseId());
			lectureDB.put(lectureId, lecture);
			courseDB.put(courseId, course);
			
			return lecture; 
		}
		
		return null;
	}
	
	public Lecture removeLecture(RequestRelationId requestRelationId) {
		long lectureId = requestRelationId.getLectureId();
		long courseId = requestRelationId.getCourseId();
		
		if(lectureDB.containsKey(lectureId) && courseDB.containsKey(courseId)) {
			Course course = courseDB.get(courseId);
			Lecture lecture = lectureDB.get(lectureId);
			course.removeLecture(lecture);
			lecture.setCourse("");
			lectureDB.put(lectureId, lecture);
			courseDB.put(courseId, course);
			
			return lecture;
		}
		
		return null;
	}
}
