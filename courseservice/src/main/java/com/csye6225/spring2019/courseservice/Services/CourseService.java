package com.csye6225.spring2019.courseservice.Services;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.spring2019.courseservice.datamodel.Course;
import com.csye6225.spring2019.courseservice.datamodel.DynamoDB;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;

public class CourseService {
	private static DynamoDB dynamoDb;
	private static DynamoDBMapper mapper;

	public CourseService() {
		dynamoDb = new DynamoDB();
		dynamoDb.init();

		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}

	public List<Course> getAllCourses() {
		List<Course> list = mapper.scan(Course.class, new DynamoDBScanExpression());
		return list;
	}

	public Course getCourse(String courseId) {
		Course course = mapper.load(Course.class, courseId);
		return course;
	}

	public Course deleteCourse(String courseId) {
		Course course = getCourse(courseId);
		mapper.delete(course);
		return course;
	}

	public Course addCourse(Course course) {
		mapper.save(course);
		return course;
	}

	public Course updateCourseInformation(String courseId, Course course) {
		DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
				.withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE).build();
		course.setCourseId(courseId);
		mapper.save(course, dynamoDBMapperConfig);

		return course;
	}
	
	public Course registerBoard(RequestRelationId requestRelationId) {
		String boardId = requestRelationId.getBoardId();
		String courseId = requestRelationId.getCourseId();
		
		Course course = mapper.load(Course.class, courseId);
		course.setBoardId(boardId);
		
		return updateCourseInformation(courseId, course);
	}

	public Course registerTA(RequestRelationId requestRelationId) {
		String stuId = requestRelationId.getStudentId();
		String courseId = requestRelationId.getCourseId();
		Course course = mapper.load(Course.class, courseId);
		course.setTaId(stuId);
		return updateCourseInformation(courseId, course);
	}

	public Course registerStudent(RequestRelationId requestRelationId) {
		String stuId = requestRelationId.getStudentId();
		String courseId = requestRelationId.getCourseId();

		Course course = mapper.load(Course.class, courseId);
		List<String> roster = course.getRoster();
		if (roster == null) {
			roster = new ArrayList<String>();
		}
		roster.add(stuId);
		course.setRoster(roster);
		return updateCourseInformation(courseId, course);
	}

	public Course removeStudent(RequestRelationId requestRelationId) {
		String stuId = requestRelationId.getStudentId();
		String courseId = requestRelationId.getCourseId();

		Course course = mapper.load(Course.class, courseId);
		List<String> roster = course.getRoster();

		if (roster != null && roster.size() > 0) {
			int idx = -1;
			for (int i = 0; i < roster.size(); i++) {
				if (roster.get(i).equalsIgnoreCase(stuId)) {
					idx = i;
					break;
				}
			}

			if (idx != -1) {
				roster.remove(idx);
			}
		}

		course.setRoster(roster);
		return updateCourseInformation(courseId, course);
	}
}
