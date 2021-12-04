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
	
	@RequestMapping(value = "/{boardNo}", method = {RequestMethod.GET, RequestMethod.PUT}, headers = "X-HTTP-Method-Override=PUT")
	   public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
	      logger.info("modifyByHeader");
	      logger.info(board.toString());

	      ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

	      return entity;
	   }

}
