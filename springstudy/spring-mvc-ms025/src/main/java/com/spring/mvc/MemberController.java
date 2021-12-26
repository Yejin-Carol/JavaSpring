package com.spring.mvc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mvc.domain.Member;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// registerAllForm
		@RequestMapping(value = "/registerAllForm", method = RequestMethod.GET)
		public String registerAllForm(Model model) {
			logger.info("registerAllForm");
			return "registerAllForm";
		}

	
	// mission 25- Method2
		@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
		public String registerUser(Member member) {
			logger.info("registerCheckbox");
			logger.info("Member : " + member.toString());
			
			return "success";
	}	
	// mission 26
		
		@RequestMapping(value= "/registerFile01", method=RequestMethod.POST)
		public String registerFile01(@RequestParam(value="picture") MultipartFile picture) throws Exception {
			logger.info("registerFile01");
			logger.info("originalName: " + picture.getOriginalFilename());
			
			return "success";
		}
	
	// mission 27
		
		// registerAllForm
		@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
		public String registerForm(Model model) {
			logger.info("registerForm");
			return "registerForm";
		}	

		// mission 27-1
		
		@RequestMapping(value= "/register01/{userId}", method=RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<String> register01(@PathVariable("userId") String userId) {
			
			logger.info("register01");
			logger.info("userId="+userId);
			ResponseEntity<String> entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
			return entity;
		}
		
	
		// mission 27-2
		
		@RequestMapping(value= "/register02", method=RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<String> register02(String userId, String password) {			
			logger.info("registerForm-register02");
			logger.info("userId=" + userId);
			logger.info("password= " + password);
			
			ResponseEntity<String> entity = new ResponseEntity<String>("success", HttpStatus.OK);
			
			return entity;
				}
		
		// mission 28
			@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
			@ResponseBody
			public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
			      String originalFilename = file.getOriginalFilename();
			      
			      logger.info("originalName: " + originalFilename);

			      ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS " 
			      + originalFilename, HttpStatus.OK);

			      return entity;
		}
	}
