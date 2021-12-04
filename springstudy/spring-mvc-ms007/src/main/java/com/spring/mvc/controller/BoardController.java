package com.spring.mvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.mvc.domain.Board;


@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//MISSION 007- method1 POST	
		@RequestMapping(value="/{boardNo}", method = RequestMethod.POST)
		public ResponseEntity<String> method1(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
			logger.info("method1");
			logger.info(board.toString());
			
			ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			return entity;
	}
		//MISSION 007- method2 PUT json
		@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT, produces="application/json")
		public ResponseEntity<String> method2(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
			logger.info("method2-Json");
			ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			return entity;
	}


}
