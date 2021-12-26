package com.spring.mvc;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

import jakarta.validation.Valid;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
		//Mission 33 hibernate-validator
		
		@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
		public String registerForm(Model model) {
			logger.info("registerForm01");
			model.addAttribute("member", new Member());
			
			return "registerForm";
		}
	
	
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public String register(@Valid Member member, BindingResult bindingResult, Model model) throws Exception {
			
			logger.info("Mission34 register");		
			/* hasErrors(): 에러발생시 true 반환
			 * hasGlobalErrors(): 객체 레벨의 에러가 발생한 경우 true 반환
			 * hasFieldErrors(): 필드 레벨의 에러 발생시 true반환
			 * hasFieldErrors(String): 인수에 지정한 필드에서 에러가 발생한 경우 true 반환
			 * 
			 */
			System.out.println(member.toString());
			if(bindingResult.hasErrors()) {
				List<ObjectError> errors = bindingResult.getAllErrors();
				for(ObjectError error : errors) {
					System.out.println(error.getDefaultMessage());
				}
//				
//				List<ObjectError>globalErrors = result.getGlobalErrors();
//				List<FieldError>fieldErrors=result.getFieldErrors();
//				
//				logger.info("allError.size()=" + allErrors.size());
//				logger.info("globalErrors.size()=" + globalErrors.size());
//				logger.info("fieldErrors.size()=" + fieldErrors.size());
//				
//				for(int i =0; i< allErrors.size(); i++) {
//					ObjectError objectError = allErrors.get(i);
//					logger.info("allError=" + objectError);
//				}
//				for(int i =0; i<globalErrors.size(); i++) {
//					ObjectError objectError = globalErrors.get(i);
//					logger.info("globalError=" + objectError);	
//				}
//				for(int i =0; i<fieldErrors.size(); i++) {
//					FieldError fieldError = fieldErrors.get(i);
//					logger.info("fieldError=" + fieldError);
//					logger.info("fieldError.getDefaultMessage="+ fieldError.getDefaultMessage());
//				}
				return "registerForm";			
			}
			
			return "success";
	}
		
		@RequestMapping(value="/result", method=RequestMethod.GET)
		public String result(Member member) {
			logger.info("register");
			logger.info("member.getUserId()=" + member.getUserId());
			logger.info("member.getPassword()=" + member.getPassword());
			logger.info("member.getUserName()=" + member.getUsername());
			logger.info("member.getEmail()=" + member.getEmail());
			logger.info("member.getGender()=" + member.getGender());
		return "success";
	}
		
		
		
}
