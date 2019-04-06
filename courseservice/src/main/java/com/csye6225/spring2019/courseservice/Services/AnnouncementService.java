package com.csye6225.spring2019.courseservice.Services;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.spring2019.courseservice.datamodel.Announcement;
import com.csye6225.spring2019.courseservice.datamodel.DynamoDB;

public class AnnouncementService {
	private static DynamoDB dynamoDb;
	private static DynamoDBMapper mapper;

	public AnnouncementService() {
		dynamoDb = new DynamoDB();
		dynamoDb.init();

		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}

	public List<Announcement> getAllAnnouncements() {
		List<Announcement> list = mapper.scan(Announcement.class, new DynamoDBScanExpression());
		return list;
	}

	public Announcement getAnnouncement(String announcementId) {
		Announcement announcement = mapper.load(Announcement.class, announcementId);
		return announcement;
	}

	public Announcement deleteAnnouncement(String announcementId) {
		Announcement announcement = getAnnouncement(announcementId);
		mapper.delete(announcement);
		return announcement;
	}

	public Announcement addAnnouncement(Announcement announcement) {
		mapper.save(announcement);
		return announcement;
	}

	public Announcement updateAnnouncementInformation(String announcementId, Announcement announcement) {
		DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
				.withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE).build();
		announcement.setAnnouncementId(announcementId);
		mapper.save(announcement, dynamoDBMapperConfig);

		return announcement;
	}
}
