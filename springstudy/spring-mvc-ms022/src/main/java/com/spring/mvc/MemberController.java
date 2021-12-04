package com.spring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	
	// mission 22-1 
		@RequestMapping(value = "/register01", method = RequestMethod.POST)
		public String register01(Member member) {
						
			logger.info("method1");
			logger.info("Member : " + member.toString());
			return "success";

	}
		
		// mission 22-2 
		@RequestMapping(value = "/register02", method = RequestMethod.POST)
		public String register02(Member member, int coin) {
			logger.info("method2");
			logger.info("Member : " + member.toString());
			logger.info("coin : " + coin);
			return "success";
	}
		// mission 22-3
		@RequestMapping(value = "/register03", method = RequestMethod.POST)
		public String register03(int uid, Member member) {
			logger.info("method3");
			logger.info("uid : " + uid);
			logger.info("Member : " + member.toString());
			
			return "success";
	}
		


}
