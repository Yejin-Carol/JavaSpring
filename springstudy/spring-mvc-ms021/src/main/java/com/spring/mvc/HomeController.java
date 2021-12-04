package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// registerForm
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm(Model model) {
		logger.info("registerForm");
		return "registerForm";
	}

	// mission 21-1 (mission20-method3과 동일)
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String method1(@PathVariable String userId) {
		logger.info("method1");
		logger.info("userId: " + userId);

		return "success";
	}

	// mission 21-2
	@RequestMapping(value = "/register/{userId}/{coin}", method = RequestMethod.GET)
	public String method2(@PathVariable String userId, @PathVariable String coin) {
		logger.info("method2");
		logger.info("userId: " + userId);
		logger.info("coin: " + coin);

		return "success";
	}

	// mission 21-3
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String method3(@RequestParam("userId") String userId) {
		logger.info("method3");
		logger.info("userId: " + userId);
		return "success";
	}
	
	// mission 21-4 (view에 username 없으므로 required=false)
		@RequestMapping(value = "/register0201", method = RequestMethod.POST)
		public String method4(@RequestParam(required=false) String username) {
			logger.info("method4");
			logger.info("username: " + username);
			return "success";
		}
	

	// mission 21-5
	@RequestMapping(value = "/register0202", method = RequestMethod.POST)
	public String method5(@RequestParam("userId") String username){
		
		logger.info("method5");
		logger.info("username: " + username);
		return "success";
	}
	
	// mission 21-6
			@RequestMapping(value = "/register0301", method = RequestMethod.POST)
			public String method6(String username){
				logger.info("method6");
				logger.info("username: " + username);
				return "success";
			}
	
	// mission 21-7 요청 병렬로 받기 (@PathVriable, @RequestParam)
		@RequestMapping(value = "/register0302", method = RequestMethod.POST)
		public String method7(@RequestParam("userId") String memberId){
			
			logger.info("method7");
			logger.info("userId: " + memberId);
			return "success";
		}
	

}
