package com.csye6225.spring2019.courseservice.datamodel;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDB {

	private static AmazonDynamoDB dynamoDb;

	public void init() {
		if (dynamoDb == null) {
//			ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
//			credentialsProvider.getCredentials();
			DefaultAWSCredentialsProviderChain credentialsProvider = DefaultAWSCredentialsProviderChain.getInstance();
			dynamoDb = AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider)
					.withRegion("us-west-1").build();
		}
	}

	public AmazonDynamoDB getClient() {
		return dynamoDb;
	}
}
