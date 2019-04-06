package com.csye6225.spring2019.courseservice.Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.spring2019.courseservice.datamodel.DynamoDB;
import com.csye6225.spring2019.courseservice.datamodel.Professor;
import com.csye6225.spring2019.courseservice.datamodel.RequestTimeModel;

public class ProfessorService {
	private static DynamoDB dynamoDb;
	private static DynamoDBMapper mapper;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
	public ProfessorService() {
		dynamoDb = new DynamoDB();
		dynamoDb.init();
	
		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}

	public List<Professor> getAllProfessors() {
		List<Professor> list = mapper.scan(Professor.class, new DynamoDBScanExpression());
		return list;
	}

	public List<Professor> getProfessorsByDepartment(String department) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(department));
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression("department = :v1")
				.withExpressionAttributeValues(eav);

		List<Professor> list = mapper.scan(Professor.class, scanExpression);
		return list;
	}
	
	public List<Professor> getProfessorWithinTimePeriod(RequestTimeModel requestTimeModel) {
		String startDate = dateFormatter.format(requestTimeModel.getStartDate());
        String endDate = dateFormatter.format(requestTimeModel.getEndDate());
        
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(startDate));
        eav.put(":val2", new AttributeValue().withS(endDate));
        
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("joiningDate between :val1 and :val2")
                .withExpressionAttributeValues(eav);
        
        List<Professor> professors = mapper.scan(Professor.class, scanExpression);
        
        return professors;
	}

   	public Professor getProfessor(String profId) {
		Professor prof = mapper.load(Professor.class, profId);
		return prof;
	}

	public Professor deleteProfessor(String profId) {
		Professor prof = getProfessor(profId);
		mapper.delete(prof);
		return prof;
	}

	public Professor addProfessor(Professor prof) {
		prof.setJoiningDate(dateFormatter.format(new Date()));
		mapper.save(prof);
		return prof;
	}

	public Professor updateProfessorInformation(String profId, Professor prof) {
		Professor oldProf = getProfessor(profId);
		DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
				.withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE).build();
		
		if(prof.getJoiningDate() == null || prof.getJoiningDate().length() == 0) {
			prof.setJoiningDate(oldProf.getJoiningDate());
		}
		prof.setProfessorId(profId);
		mapper.save(prof, dynamoDBMapperConfig);

		return prof;
	}
}
