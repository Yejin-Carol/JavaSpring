package com.spring.mvc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//mission 19-1
	@ResponseBody
	@RequestMapping(value="/test1101", method=RequestMethod.GET)
	public ResponseEntity<byte[]> test1101() throws Exception {
		logger.info("test1101");
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream("C:\\upload\\test.png");
			headers.setContentType(MediaType.IMAGE_PNG);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;		
	}
	
	//mission 19-2
	@ResponseBody
	@RequestMapping(value="/test1102", method=RequestMethod.GET)
	public ResponseEntity<byte[]> test1102() throws Exception {
		logger.info("test1102");

		String filename = "test.zip";
		
		logger.info("filename = " + filename);
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream("C:\\upload\\" + filename);
			
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" + new String(filename.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;		
	}	
	
	//mission 20-1
	@RequestMapping(value="/registerForm", method=RequestMethod.GET)
	public String method1(Model model) {
		logger.info("method1-registerForm");	
			return "registerForm";
		}
	
	//mission 20-2
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String method2(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		logger.info("method2");
		logger.info("userId: " + userId);
		logger.info("password: " + password);
		
		return "success";	
	}
	
	
	//mission 20-3
	@RequestMapping(value="/register/{userId}", method=RequestMethod.GET)
	public String method3(@PathVariable String userId) {
		logger.info("method3");
		logger.info("userId: " + userId);
		
		return "success";	
	}
	
	
	//mission 20-4 & 5 & 6
		@RequestMapping(value="/register01", method=RequestMethod.POST)
		public String method4(@RequestParam("userId") String userId, @RequestParam("password") String password) {
			logger.info("method4");
			logger.info("userId: " + userId);
			logger.info("password: " + password);			
			
			return "success";	
		}
		
	//mission 20-7
		@RequestMapping(value="/register02", method=RequestMethod.POST)
		public String method7(@RequestParam("userId") String userId, @RequestParam("password") String password, @RequestParam("coin") String coin) {
			logger.info("method7");
			logger.info("userId: " + userId);
			logger.info("password: " + password);			
			logger.info("coin: " + coin);
			return "success";	
		}

	
}
