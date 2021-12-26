package com.spring.mvc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.domain.Member;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// Mission 30- 모델을 통한 데이터 전달 

		
		@RequestMapping(value="/read01", method=RequestMethod.GET)
		public String register01(Model model) {

			logger.info("register01");
			model.addAttribute("userId", "test");
			model.addAttribute("password", "123456");
			model.addAttribute("userName", "홍길동");
			model.addAttribute("email", "test@naver.com");
			
			return "read01";
		}
		
		@RequestMapping(value="/read02", method=RequestMethod.GET)
		public String register02(Model model) {
			logger.info("register02");		
			
			Member member = new Member();
			member.setUserId("test");
			member.setPassword("123456");
			member.setUsername("홍길동");
			member.setEmail("test@naver.com");
			
			model.addAttribute(member);
			
			return "read02";
		}
		
		// Mission 31
		@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
		public String registerForm() {
			logger.info("registerForm");
			return "registerForm";
		}	
		
		// Mission 31-@ModelAttribute 사용 method1 
		
		@RequestMapping(value="/register1", method=RequestMethod.POST)
		public String register1(@ModelAttribute("userId") String userId, @ModelAttribute("password") String password) {
		logger.info("Mission31-method1");
		logger.info("userId: " + userId);
		logger.info("password: " + password);
		return "result1";
	}
		
		// Mission 31-method2 (member 객체로!)
		
		@RequestMapping(value="/register2", method=RequestMethod.POST)
		public String register2(@ModelAttribute("member") Member member, Model model) {
			model.addAttribute("member", member);
			logger.info("Mission31-method1");
			logger.info("userId: " + member.getUserId());
			logger.info("password: " + member.getPassword());
			
		return "result2";
	}
		
		// Mission 32 RedirectAttribute
		
		@RequestMapping(value="/register3", method=RequestMethod.POST)
		public String register3(Member member, RedirectAttributes ra) {
			logger.info("Mission32");
			ra.addFlashAttribute("msg", "success");
		return "redirect:/result3";
	}
		
		@RequestMapping(value="/result3", method=RequestMethod.GET)
		public String result3() {
			logger.info("result3");
		return "result3";
	}
		
		
		
		
}
