package com.csye6225.spring2019.courseservice.Services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.spring2019.courseservice.datamodel.DynamoDB;
import com.csye6225.spring2019.courseservice.datamodel.RequestRelationId;
import com.csye6225.spring2019.courseservice.datamodel.RequestTimeModel;
import com.csye6225.spring2019.courseservice.datamodel.Student;

public class StudentService {
	private static DynamoDB dynamoDb;
	private static DynamoDBMapper mapper;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public StudentService() {
		dynamoDb = new DynamoDB();
		dynamoDb.init();
	
		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}

	public List<Student> getAllStudents() {
		List<Student> list = mapper.scan(Student.class, new DynamoDBScanExpression());
		return list;
	}

	public List<Student> getStudentsByDepartment(String department) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(department));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("department = :v1")
				.withExpressionAttributeValues(eav);

		List<Student> list = mapper.scan(Student.class, scanExpression);
		return list;
	}
	
	public List<Student> getStudentWithinTimePeriod(RequestTimeModel requestTimeModel) {
		String startDate = dateFormatter.format(requestTimeModel.getStartDate());
        String endDate = dateFormatter.format(requestTimeModel.getEndDate());
        
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(startDate));
        eav.put(":val2", new AttributeValue().withS(endDate));
        
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("joiningDate between :val1 and :val2")
                .withExpressionAttributeValues(eav);
        
        List<Student> students = mapper.scan(Student.class, scanExpression);
        
        return students;
	}

	public Student getStudent(String stuId) {
		Student student = mapper.load(Student.class, stuId);
		return student;
	}

	public Student deleteStudent(String stuId) {
		Student student = getStudent(stuId);
		mapper.delete(student);
		return student;
	}

	public Student addStudent(Student student) {
		student.setJoiningDate(dateFormatter.format(new Date()));
		mapper.save(student);
		return student;
	}

	public Student updateStudent(String stuId, Student student) {
		Student oldStu = getStudent(stuId);
		DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
				.withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE).build();
		
		if(student.getJoiningDate() == null || student.getJoiningDate().length() == 0) {
			student.setJoiningDate(oldStu.getJoiningDate());
		}
		student.setStudentId(stuId);
		mapper.save(student, dynamoDBMapperConfig);

		return student;
	}

	public Student registerStudentToCourse(RequestRelationId requestRelationId) {
		String courseId = requestRelationId.getCourseId();
		String stuId = requestRelationId.getStudentId();

		Student student = mapper.load(Student.class, stuId);
		List<String> registeredCourse = student.getRegisteredCourses();
		if (registeredCourse == null) {
			registeredCourse = new ArrayList<String>();
		}
		registeredCourse.add(courseId);
		return updateStudent(stuId, student);
	}

	public Student removeStudentToCourse(RequestRelationId requestRelationId) {
		String courseId = requestRelationId.getCourseId();
		String stuId = requestRelationId.getStudentId();

		Student student = mapper.load(Student.class, stuId);
		List<String> registeredCourse = student.getRegisteredCourses();
		if (registeredCourse != null && registeredCourse.size() > 0) {
			int idx = -1;
			for(int i = 0; i<registeredCourse.size(); i++) {
				if(registeredCourse.get(i).equalsIgnoreCase(courseId)) {
					idx = i;
					break;
				}
			}
			
			if(idx != -1) {
				registeredCourse.remove(idx);
			}
		}
		return updateStudent(stuId, student);
	}
}
