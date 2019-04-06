package com.csye6225.spring2019.courseservice.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2019.courseservice.Services.BoardService;
import com.csye6225.spring2019.courseservice.datamodel.Board;

@Path("boards")
public class BoardResource {
	BoardService boardService = new BoardService();

	@GET
	public List<Board> getAllboards() {
		return boardService.getAllBoard();
	}

	// ... webapi/boards/1
	@GET
	@Path("/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Board getboard(@PathParam("boardId") String boardId) {
		return boardService.getBoard(boardId);
	}

	@DELETE
	@Path("/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Board deleteboard(@PathParam("boardId") String boardId) {
		return boardService.deleteBoard(boardId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board addboard(Board board) {
		return boardService.addBoard(board);
	}

	@PUT
	@Path("/{boardId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board updateboard(@PathParam("boardId") String boardId, Board board) {
		return boardService.updateBoardInformation(boardId, board);
	}
}
