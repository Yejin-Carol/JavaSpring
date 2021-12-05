package com.spring.mvc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.domain.Member;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// registerForm
		@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
		public String registerForm(Model model) {
			logger.info("registerForm");
			return "registerForm";
		}

	
	// mission 23
		@RequestMapping(value = "/register01", method = RequestMethod.GET)
		public String register01(@RequestParam("userId") String userId, @RequestParam("dateOfBirth") Date dateOfBrith) {
						
			logger.info("register01");
			logger.info("userId = " + userId);
			logger.info("dateOfBirth = " + dateOfBrith);
			return "success";

	}
		
		// mission 24 @DateTImeFormat 
		@RequestMapping(value = "/register02", method = RequestMethod.POST)
		public String register02(Member member) {
			logger.info("register02");
			logger.info("Member : " + member.toString());
			
			return "success";
	}
		
		
		


}
