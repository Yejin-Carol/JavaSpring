package com.spring.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

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

		//MISSION 008- method1 GET	
				@RequestMapping(value="/{boardNo}", method = RequestMethod.GET)
				@ResponseBody
				public String method1(@PathVariable("boardNo") int boardNo) {
					logger.info("method1");
					logger.info("boardNo: " + boardNo);
				
					return "200 OK";
			}
		
			//MISSION 008- method2 GET json
			@RequestMapping(value="/{boardNo}", method = RequestMethod.GET, produces="application/json")
			@ResponseBody
			public String method2(@PathVariable("boardNo") int boardNo) {
				logger.info("method2-Json");
				logger.info("boardNo: " + boardNo);
				
				ObjectMapper objMapper = new ObjectMapper();
				String json = "{\"status\":\"OK\"}";
			
				return HttpStatus.OK.toString();
		}
	
	
}
