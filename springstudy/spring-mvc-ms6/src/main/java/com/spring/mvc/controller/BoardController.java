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

import com.spring.mvc.domian.Board;

import jdk.internal.jline.internal.Log;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	//8) read(int boardNo) /get?read, GET
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="read")
	public String read() {
		logger.info("read");
		return "board/read";
	}
	
	
	@RequestMapping(value = "/{boardNo}", method = {RequestMethod.GET, RequestMethod.PUT}, headers = "X-HTTP-Method-Override=PUT")
    public ResponseEntity<String> getBoard(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
      logger.info("PUT ModifyByHeader");
      System.out.println(board);
      System.out.println(board.getBoardNo());
      ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
      return entity;
   }

	@RequestMapping("/hello-basic")
	public String helloBasic() {
		Log.info("helloBasic");
		return "ok";
	}
	
	
}
