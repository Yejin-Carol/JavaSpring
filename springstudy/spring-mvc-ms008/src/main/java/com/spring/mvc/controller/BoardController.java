package com.spring.mvc.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mvc.entity.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//MISSION 008- method1 POST
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
		logger.info("read");
		
		Board board = new Board();
		
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		
		return entity;
}
	//MISSION 008- method2 PUT json
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT, produces="application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo) {
		logger.info("readToJson");
		
		Board board = new Board();
		
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		
		return entity;
}
	/*
	//MISSION 008- method3 PUT xml
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT, consumes="application/xml")
	public String method3(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("method3");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return "entity";
}*/
	
/*
	@RequestMapping(value="/{boardNo}", method = RequestMethod.POST) 
	@ResponseBody
	public String method1(@PathVariable("boardNo") int boardNo) {
		logger.info("method1");
		logger.info("200 OK");
		logger.info("boardNo: " + boardNo);
		
		return "200 OK";
	}
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT,
			consumes="application/json") 
	@ResponseBody
	public String method2(@PathVariable("boardNo") int boardNo) {
		logger.info("method1");
		logger.info("200 OK");
		logger.info("boardNo: " + boardNo);
		ObjectMapper objMapper = new ObjectMapper();
		String json = "{\"status\":\"OK\"}";
		return HttpStatus.OK.toString();
	}
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT,
			consumes="application/xml") 
	@ResponseBody
	public String method3(@PathVariable("boardNo") int boardNo) {
		logger.info("method3");
		logger.info("200 OK");
		logger.info("boardNo: " + boardNo);
		
		return "200 OK";
	}
	
*/
}
