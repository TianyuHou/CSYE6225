package com.csye6225.spring2019.courseservice.Services;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.spring2019.courseservice.datamodel.Board;
import com.csye6225.spring2019.courseservice.datamodel.DynamoDB;

public class BoardService {
	private static DynamoDB dynamoDb;
	private static DynamoDBMapper mapper;

	public BoardService() {
		dynamoDb = new DynamoDB();
		dynamoDb.init();

		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}

	public List<Board> getAllBoard() {
		List<Board> list = mapper.scan(Board.class, new DynamoDBScanExpression());
		return list;
	}

	public Board getBoard(String boardId) {
		Board board = mapper.load(Board.class, boardId);
		return board;
	}

	public Board deleteBoard(String boardId) {
		Board board = getBoard(boardId);
		mapper.delete(board);
		return board;
	}

	public Board addBoard(Board board) {
		mapper.save(board);
		return board;
	}

	public Board updateBoardInformation(String boardId, Board board) {
		DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
				.withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
				.withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE).build();
		
		board.setBoardId(boardId);
		mapper.save(board, dynamoDBMapperConfig);

		return board;
	}
}
